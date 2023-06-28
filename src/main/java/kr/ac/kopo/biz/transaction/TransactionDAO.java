package kr.ac.kopo.biz.transaction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.ac.kopo.util.ConnectionFactory;

public class TransactionDAO {
	
	public int bankSelect(String bankcd, String senderAccNo, String recieverAccNo, long amount) throws Exception{
		int returnVal = 0;
		switch(bankcd){
		case "1003" : returnVal = this.transfer(senderAccNo, recieverAccNo, amount);
				break;
		case "0413" : returnVal = this.transferBJ(senderAccNo, recieverAccNo, amount);
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
		sql.append("insert into b_transaction(t_cd, acc_no, t_type, t_amount, t_info, bank_cd, deposit_bank_cd, deposit_account) ");
		sql.append(" values(sequence_TransNO.nextval, ?, ?, ?, ?, ? ,? , ?) ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, vo.getAccNo());
			System.out.println(vo.getAccNo());
			pstmt.setString(2, vo.getTransType());
			pstmt.setLong(3, vo.getTransAmount());
			pstmt.setString(4, vo.getTransInfo());
			pstmt.setString(5, vo.getBankCode());
			System.out.println(vo.getBankCode());
			pstmt.setString(6, vo.getDepositBankCode());
			pstmt.setString(7, vo.getDepositAccNo());
			System.out.println(vo.getDepositAccNo());
			
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
