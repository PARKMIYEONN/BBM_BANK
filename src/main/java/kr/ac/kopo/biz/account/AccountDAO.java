package kr.ac.kopo.biz.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import kr.ac.kopo.util.ConnectionFactory;

public class AccountDAO {
	
	public void newAccount(AccountVO vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into b_account(acc_no, user_id, product_name, bank_cd, acc_type, balance, acc_password) ");
		sql.append(" values(?, ?, ?, ?, ?, ?, ?) ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, vo.getAccNo());
			pstmt.setString(2, vo.getUserId());
			pstmt.setString(3, vo.getProductName());
			pstmt.setString(4, vo.getBankCode());
			pstmt.setString(5, vo.getAccType());
			pstmt.setLong(6, vo.getBalance());
			pstmt.setString(7, vo.getAccPassword());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public List<AccountVO> myAcc(String id){
		StringBuilder sql = new StringBuilder();
		sql.append("select * from b_account where user_id = ? ");
		AccountVO account = null;
		List<AccountVO> accList = new ArrayList<>();
		try(Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				account = new AccountVO();
				account.setAccCreateDate(rs.getString("acc_created_date"));
				account.setAccNo(rs.getString("acc_no"));
				account.setAccPassword(rs.getString("acc_password"));
				account.setAccType(rs.getString("acc_type"));
				account.setBalance(rs.getLong("balance"));
				account.setBankCode(rs.getString("bank_cd"));
				account.setDormantAcc(rs.getInt("dormant_acc"));
				account.setProductName(rs.getString("product_name"));
				account.setUserId(id);
				accList.add(account);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accList;
	}
	
	public long totalBalance(String userId) {
		StringBuilder sql = new StringBuilder();
		sql.append("select balance from b_account where user_id = ? ");
		long totalbalance = 0;
		try(Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, userId);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				totalbalance += rs.getLong("balance");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return totalbalance;
	}
	
	public String generateRandomNumber(int length) {
        Random random = new Random();
        Set<Integer> generatedNumbers = new HashSet<>();
        
        StringBuilder rnum = new StringBuilder();
        while (rnum.length() < length) {
            int randomNumber = random.nextInt(10);
            
            // 중복 검사
            if (!generatedNumbers.contains(randomNumber)) {
                generatedNumbers.add(randomNumber);
                rnum.append(randomNumber);
            }
        }
        
        return rnum.toString();
    }

}
