package kr.ac.kopo.biz.transaction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;

public class TransactionDAO {
	
	public int bankSelect(TransactionVO vo) throws Exception{
		int returnVal = 0;
		switch(vo.getDepositBankCode()){
		case "1003" : returnVal = this.transfer(vo.getAccNo(), vo.getDepositAccNo(), vo.getTransAmount());
						this.transactionHistory(vo);
						this.depositHistory(vo);
				break;
		case "0413" : returnVal = this.transferBJ(vo.getAccNo(), vo.getDepositAccNo(), vo.getTransAmount());
						this.transactionHistory(vo);
						this.depositHistoryBJ(vo);
				break;
		}
		return returnVal;
	}
	
	public int transfer(String senderAccNo, String recieverAccNo, long amount) throws Exception{
		Connection conn = null;
		CallableStatement callableStatment = null;
		
		StringBuilder sql = new StringBuilder();
		try{
			conn = new ConnectionFactory().getConnection();
			
			conn.setAutoCommit(false);
			
			sql.append("{call transfer(?, ?, ?)}");
			callableStatment = conn.prepareCall(sql.toString());
			
			callableStatment.setString(1, senderAccNo);
			callableStatment.setString(2, recieverAccNo);
			callableStatment.setLong(3, amount);
			
			callableStatment.executeUpdate();
			conn.commit();
			
			return 1;
			
		} catch (SQLException e) {
			conn.rollback();
			return 0;
			
		}finally {
			if(callableStatment != null) {
				callableStatment.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
			
	}
	
	public int transferBJ(String senderAccNo, String recieverAccNo, long amount) throws Exception{
		Connection conn = null;
		CallableStatement callableStatment = null;
		
		StringBuilder sql = new StringBuilder();
		try{
			conn = new ConnectionFactory().getConnection();
			
			conn.setAutoCommit(false);
			
			sql.append("{call transfer_BJ(?, ?, ?)}");
			callableStatment = conn.prepareCall(sql.toString());
			
			callableStatment.setString(1, senderAccNo);
			callableStatment.setString(2, recieverAccNo);
			callableStatment.setLong(3, amount);
			
			callableStatment.executeUpdate();
			conn.commit();
			
			return 1;
			
		} catch (SQLException e) {
			conn.rollback();
			return 0;
			
		}finally {
			if(callableStatment != null) {
				callableStatment.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
			
	}
	
	public void transactionHistory(TransactionVO vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into b_transaction(t_cd, acc_no, t_type, t_amount, t_info, bank_cd, deposit_bank_cd, deposit_account, t_pre_balance ) ");
		sql.append(" values(sequence_TransNO.nextval, ?, ?, ?, ?, ? ,? , ?,?) ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, vo.getAccNo());
			System.out.println(vo.getAccNo());
			pstmt.setString(2, "출금");
			pstmt.setLong(3, vo.getTransAmount());
			if(vo.getTransInfo().equals("")) {
				pstmt.setString(4, this.getName(vo.getDepositAccNo()));
				
			}else {
				pstmt.setString(4, vo.getTransInfo());
			}
			pstmt.setString(5, vo.getBankCode());
			System.out.println(vo.getBankCode());
			pstmt.setString(6, vo.getDepositBankCode());
			pstmt.setString(7, vo.getDepositAccNo());
			System.out.println(vo.getDepositAccNo());
			pstmt.setLong(8, vo.getPreBalance()-vo.getTransAmount());
			
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void depositHistory(TransactionVO vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into b_transaction(t_cd, acc_no, t_type, t_amount, t_info, bank_cd, deposit_bank_cd, deposit_account, t_pre_balance) ");
		sql.append(" values(sequence_TransNO.nextval, ?, ?, ?, ?, ? ,? , ?,?) ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, vo.getDepositAccNo());
			pstmt.setString(2, "입금");
			pstmt.setLong(3, vo.getTransAmount());
			if(vo.getTransInfo().equals("")) {
				pstmt.setString(4, this.getName(vo.getAccNo()));
				
			}else {
				pstmt.setString(4, vo.getTransInfo());
			}
			pstmt.setString(5, vo.getDepositBankCode());
			pstmt.setString(6, vo.getBankCode());
			pstmt.setString(7, vo.getAccNo());	
			pstmt.setLong(8, this.getBalance(vo.getDepositAccNo()));
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void depositHistoryBJ(TransactionVO vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into history@BjBank(no, bank_cd, account_id, deposit_hs ,tr_bank , tr_account, history_bl) ");
		sql.append(" values(HISTORY_NO.NEXTVAL@BjBank, ?, ?, ?, ?, ? ,? ) ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, vo.getDepositBankCode());
			pstmt.setString(2, vo.getDepositAccNo());
			pstmt.setString(3, "입금");
			pstmt.setString(4, vo.getBankCode());
			pstmt.setString(5, vo.getAccNo());
			pstmt.setLong(6, vo.getTransAmount());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public List<TransactionVO> transactionList(String accNo){
		StringBuilder sql = new StringBuilder();
		List<TransactionVO> transactionList = new ArrayList<>();
		TransactionVO tvo = null;
		sql.append("SELECT t_cd, acc_no, TO_CHAR(t_date, 'YYYY-MM-DD HH24:MI:SS') AS t_date, t_type, t_amount, t_info, bank_cd, deposit_bank_cd, deposit_account, t_pre_balance ");
		sql.append(" FROM b_transaction ");	
		sql.append(" where acc_no = ? order by t_cd desc");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, accNo);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				tvo = new TransactionVO();
				tvo.setAccNo(rs.getString("acc_no"));
				tvo.setBankCode(rs.getString("bank_cd"));
				tvo.setDepositAccNo(rs.getString("deposit_account"));
				tvo.setDepositBankCode(rs.getString("deposit_bank_cd"));
				tvo.setTransAmount(rs.getLong("t_amount"));
				tvo.setTransCode(rs.getInt("t_cd"));
				tvo.setTransDate(rs.getString("t_date"));
				tvo.setTransInfo(rs.getString("t_info"));
				tvo.setTransType(rs.getString("t_type"));
				tvo.setPreBalance(rs.getLong("t_pre_balance"));
				transactionList.add(tvo);
				
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionList;
	}
	
	public String getName(String accNo) {
		StringBuilder sql = new StringBuilder();
		String userName = null;
		sql.append("select ui.user_name, a.acc_no from b_account a join b_user_info ui on a.user_id = ui.user_id where acc_no = ?");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, accNo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				userName = rs.getString("user_name");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userName;
	}
	

	
	public long getBalance(String accNo) {
		StringBuilder sql = new StringBuilder();
		long rBalance = 0;
		sql.append("select balance from b_account where acc_no = ? ");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, accNo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				rBalance = rs.getLong("balance");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rBalance;
	}
	
	

}
