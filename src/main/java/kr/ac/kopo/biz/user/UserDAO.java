package kr.ac.kopo.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;

public class UserDAO {
	
	public void insertUser(UserVO user) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into b_user_info(user_id, user_password, user_name, user_email, user_birthday, gender, user_tel, user_post, user_address)");
		sql.append(" values(?,?,?,?,to_date(?,'yymmdd'),?,?,?,?) ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserEmail());
			pstmt.setString(5, user.getUserBirthday());
			pstmt.setInt(6, user.getGender());
			pstmt.setString(7, user.getUserTel());
			pstmt.setString(8, user.getUserPost());
			pstmt.setString(9, user.getUserAddress());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public UserVO loginUser(UserVO vo) {
		StringBuilder sql = new StringBuilder();
		UserVO user = null;
		sql.append("select user_id, user_password, user_name, user_email, user_birthday, gender, user_tel, user_post, user_address from b_user_info where user_id = ? and user_password = ?");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPassword());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setUserId(rs.getString("user_id"));
				user.setUserPassword(rs.getString("user_password"));
				user.setUserName(rs.getString("user_name"));
				user.setUserEmail(rs.getString("user_email"));
				user.setUserBirthday(rs.getString("user_birthday"));
				user.setGender(rs.getInt("gender"));
				user.setUserTel(rs.getString("user_tel"));
				user.setUserPost(rs.getString("user_post"));
				user.setUserAddress(rs.getString("user_address"));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean checkDuplicateId(String id) {

	      StringBuilder sql = new StringBuilder();
	      String id1 = null;
	      sql.append("select user_id from b_user_info ");
	      try (Connection conn = new ConnectionFactory().getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	            ResultSet rs = pstmt.executeQuery();) {
	         while (rs.next()) {
	            id1 = rs.getString("user_id");
	            if (id1.equals(id)) {
	               return true;

	            }

	         }

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return false;
	   }
	


}
