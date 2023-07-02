package kr.ac.kopo.biz.transaction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.ac.kopo.util.ConnectionFactory;

public class OpenBankingTransactionDAO {
	
	public int transfer(String senderAccNo, String recieverAccNo, long amount) throws Exception{
		Connection conn = null;
		CallableStatement callableStatment = null;
		
		StringBuilder sql = new StringBuilder();
		try{
			conn = new ConnectionFactory().getConnection();
			
			conn.setAutoCommit(false);
			
			sql.append("{call transfer_eziToBj(?, ?, ?)}");
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
	
	public void depositHistoryezi(TransactionVO vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into history@eziBank(ts_no, acc_no, bankcode, sender, t_type, t_amount, balance, rc_bankcode, rc_account, receiver) ");
		sql.append(" values(ts_no.nextval@eziBank, ?, ?, ?, ?, ? ,? , ?, ?, ?) ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, vo.getAccNo());
			pstmt.setString(2, vo.getBankCode());
			pstmt.setString(3, new TransactionDAO().getNameezi(vo.getAccNo()));
			pstmt.setString(4, "입금");
			pstmt.setLong(5, vo.getTransAmount());
			pstmt.setLong(6, new TransactionDAO().getBalanceezi(vo.getAccNo()));
			pstmt.setString(7, vo.getBankCode());
			pstmt.setString(8, vo.getAccNo());
			pstmt.setString(9, new TransactionDAO().getName(vo.getDepositAccNo()));
			
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
