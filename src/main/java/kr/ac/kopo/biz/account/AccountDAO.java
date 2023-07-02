package kr.ac.kopo.biz.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import kr.ac.kopo.biz.user.UserVO;
import kr.ac.kopo.util.ConnectionFactory;

public class AccountDAO {
	
	public List<AccountVO> selectbankaccountlist(String email , String bankCode){
		List<AccountVO> accountList = null;
		switch(bankCode) {
		case "0413" : accountList =  this.accountListBJ(email);
					break;
		case "0504" : accountList =  this.accountListezi(email);
					break;
		case "9999" : accountList =  this.accountListKKP(email);
					break;
		}
		return accountList;
	}
	
	public long selectedtotalbalance(String email, String bankCode) {
		long tb = 0;
		switch(bankCode) {
		case "0413" : tb = this.totalBalancebj(email);
		break;
		case "0504" : tb = this.totalBalanceezi(email);
		break;
		}
		return tb;
	}
	
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
		sql.append("select acc_no, user_id, product_name, bank_cd, acc_type, dormant_acc, balance, to_char(acc_created_date, 'yyyy-mm-dd')as acc_created_date, acc_password from b_account where user_id = ? ");
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
	
	public long totalBalancebj(String userEmail) {
		StringBuilder sql = new StringBuilder();
		sql.append("select a.account_bl from account@BjBank a join member@BjBank m on a.member_id = m.member_id where member_em = ? ");
		long totalbalance = 0;
		try(Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, userEmail);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				totalbalance += rs.getLong("account_bl");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return totalbalance;
	}
	
	public long totalBalanceezi(String userEmail) {
		StringBuilder sql = new StringBuilder();
		sql.append("select a.balance from account@eziBank a join bk_user@eziBank m on a.user_id = m.user_id where user_email = ? ");
		long totalbalance = 0;
		try(Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, userEmail);
			
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
	
	public boolean checkPassword(String password, String accNo) {
		StringBuilder sql = new StringBuilder();
		String accPW = null;
		sql.append("select acc_password from b_account where acc_no = ?");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, accNo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				accPW = rs.getString("acc_password");
				System.out.println("확인해 보자");
				System.out.println(accPW.equals(password));
				if(accPW.equals(password)) {
					
					return true;
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean checkAccountInfo(AccountVO account, UserVO user) {
		StringBuilder sql = new StringBuilder();
		sql.append("select ui.user_name, ui.user_email, replace(ui.user_birthday, '/', '') as birthday, ui.user_tel, a.acc_password ");
		sql.append(" from b_user_info ui ");
		sql.append(" join b_account a on ui.user_id = a.user_id ");
		sql.append(" where a.acc_no = ? ");
	
		String accPW = null;
		String userName = null;
		String email = null;
		String birthday = null;
		String phone = null;
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, account.getAccNo());
			System.out.println(user.getUserBirthday());
			System.out.println(account.getAccNo());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				accPW = rs.getString("acc_password");
				userName = rs.getString("user_name");
				email = rs.getString("user_email");
				birthday = rs.getString("birthday");
				System.out.println(birthday);
				System.out.println(user.getUserBirthday());
				phone = rs.getString("user_tel");
				
				if(accPW.equals(account.getAccPassword()) && userName.equals(user.getUserName()) && email.equals(user.getUserEmail()) && birthday.equals(user.getUserBirthday()) && phone.equals(user.getUserTel())) {
					return true;
				}
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;		
	}
	
	public List<AccountVO> accountListBJ(String email){
		StringBuilder sql = new StringBuilder();
		sql.append("select ac.account_id, pr.product_nm, ac.account_bl, ac.account_date");
		sql.append(" from account @BjBank ac ");
		sql.append(" join product @BjBank pr on ac.product_cd = pr.product_cd ");
		sql.append(" join member @BjBank m on ac.member_id = m.member_id ");
		sql.append(" where m.member_em = ? ");
		List<AccountVO> accountList = new ArrayList<>();
		AccountVO account = null;
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				account = new AccountVO();
				account.setAccNo(rs.getString("account_id"));
				account.setProductName(rs.getString("product_nm"));
				account.setBankName("BjBank");
				account.setBalance(rs.getLong("account_bl"));
				account.setAccCreateDate(rs.getString("account_date"));
				
				accountList.add(account);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accountList;
	}
	
	public List<AccountVO> accountListezi(String email){
		StringBuilder sql = new StringBuilder();
		sql.append("select ac.acc_no, ac.item_name, ac.balance, ac.ac_date");
		sql.append(" from account @eziBank ac ");
		sql.append(" join bk_user @eziBank u on ac.user_id = u.user_id ");
		sql.append(" where u.user_email = ? ");
		List<AccountVO> accountList = new ArrayList<>();
		AccountVO account = null;
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				account = new AccountVO();
				account.setAccNo(rs.getString("acc_no"));
				account.setProductName(rs.getString("item_name"));
				account.setBankName("ezi은행");
				account.setBalance(rs.getLong("balance"));
				account.setAccCreateDate(rs.getString("ac_date"));
				
				accountList.add(account);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accountList;
	}
	
	public List<AccountVO> accountListKKP(String email){
		StringBuilder sql = new StringBuilder();
		sql.append("select ac.ac_number, p.pd_name, ac.ac_money, ac.ac_op_date");
		sql.append(" from account @KKPBank ac ");
		sql.append(" join financial_product @KKPBank p on ac.pd_number = p.pd_number ");
		sql.append(" join user_info @KKPBank u on ac.user_id = u.user_id ");
		sql.append(" where u.email = ? ");
		List<AccountVO> accountList = new ArrayList<>();
		AccountVO account = null;
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				account = new AccountVO();
				account.setAccNo(rs.getString("ac_number"));
				account.setProductName(rs.getString("pd_name"));
				account.setBankName("KKP은행");
				account.setBalance(rs.getLong("ac_money"));
				account.setAccCreateDate(rs.getString("ac_op_date"));
				
				accountList.add(account);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accountList;
	}
	
	public void reactivateDA(String accNo) {
		StringBuilder sql = new StringBuilder();
		sql.append("update b_account set dormant_acc = 0 where acc_no = ? ");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, accNo);
			pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
