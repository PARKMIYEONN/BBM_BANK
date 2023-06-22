package kr.ac.kopo.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	
	public BoardVO getPost(BoardVO vo) {
		StringBuilder sql = new StringBuilder();
		BoardVO board = null;
		sql.append("select * from b_posts where post_no = ?");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			
			pstmt.setInt(1, vo.getPostNo());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardVO();
				board.setPostNo(rs.getInt("post_no"));
				board.setWriter(rs.getString("user_id"));
				board.setTitle(rs.getString("post_title"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getString("post_reg_date"));
				board.setPostPermission(rs.getInt("post_permission"));
				board.setHit(rs.getInt("post_hit"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		StringBuilder sql = new StringBuilder();
		List<BoardVO> boardList = new ArrayList<>();
		BoardVO board = null;
		sql.append("select * from b_posts order by post_no");
		try(Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new BoardVO();
				board.setPostNo(rs.getInt("post_no"));
				board.setWriter(rs.getString("user_id"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getString("post_reg_date"));
				board.setTitle(rs.getString("post_title"));
				board.setPostPermission(rs.getInt("post_permission"));
				board.setHit(rs.getInt("post_hit"));
				
				boardList.add(board);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}
	

}
