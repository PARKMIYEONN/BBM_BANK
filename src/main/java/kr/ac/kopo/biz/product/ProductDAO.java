package kr.ac.kopo.biz.product;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.ac.kopo.util.ConnectionFactory;

public class ProductDAO {

	public void insertProduct(ProductVO vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into b_products(product_name, product_type, end_date, product_rate) ");
		sql.append(" values(?, ?, ?, ?) ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, vo.getProductName());
			pstmt.setString(2, vo.getProductType());
			pstmt.setString(3, vo.getEndDate());
			pstmt.setInt(4, vo.getProductRate());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
