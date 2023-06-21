package kr.ac.kopo.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.ac.kopo.util.ConnectionFactory;

public class BoardDAO {
	
	public void posting(BoardVO board) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into b_posts(post_no, user_id, content, post_title, post_permission, post_hit) ");
		sql.append(" values(sequence_postNo.nextval, ?, ?, ?, ?, 0)");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getTitle());
			pstmt.setInt(4, board.getPostPermission());
			
			pstmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
