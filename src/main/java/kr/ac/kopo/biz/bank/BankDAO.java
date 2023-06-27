package kr.ac.kopo.biz.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;

public class BankDAO {
	
	public List<BankVO> bankList(){
		StringBuilder sql = new StringBuilder();
		BankVO bank = null;
		List<BankVO> bankList = new ArrayList<>();
		sql.append("select * from bank_info order by bank_cd");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bank = new BankVO();
				bank.setBankCode(rs.getString("bank_cd"));
				bank.setBankName(rs.getString("bank_nm"));
				bankList.add(bank);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bankList;
		
	}

}
