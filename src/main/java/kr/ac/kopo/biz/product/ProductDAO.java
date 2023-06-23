package kr.ac.kopo.biz.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<ProductVO> productList(){
		StringBuilder sql = new StringBuilder();
		ProductVO product = null;
		List<ProductVO> productList = new ArrayList<>();
		sql.append("select product_name, product_type, to_char(release_date, 'yyyy-mm-dd')as release_date, to_char(end_date, 'yyyy-mm-dd')as end_date, product_rate  from b_products");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				product = new ProductVO();
				product.setProductName(rs.getString("product_name"));
				product.setProductType(rs.getString("product_type"));
				product.setReleaseDate(rs.getString("release_date"));
				product.setEndDate(rs.getString("end_date"));
				product.setProductRate(rs.getInt("product_rate"));
				productList.add(product);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}
}
