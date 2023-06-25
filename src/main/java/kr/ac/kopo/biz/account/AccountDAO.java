package kr.ac.kopo.biz.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashSet;
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
