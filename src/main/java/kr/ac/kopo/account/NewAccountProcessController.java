package kr.ac.kopo.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.biz.account.AccountDAO;
import kr.ac.kopo.biz.account.AccountVO;
import kr.ac.kopo.biz.product.ProductDAO;
import kr.ac.kopo.biz.product.ProductVO;
import kr.ac.kopo.biz.user.UserVO;
import kr.ac.kopo.controller.Controller;

public class NewAccountProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		UserVO uvo = (UserVO)session.getAttribute("loginUser");
		String id = uvo.getUserId();
		String password = request.getParameter("password");
		String productName = request.getParameter("productName");
		System.out.println(productName);
		String bankCode = "1003";
		
		ProductDAO pdao = new ProductDAO();
		ProductVO product = pdao.selectProduct(productName);
		String accType = product.getProductType();
		long balance = 0;
		AccountDAO dao = new AccountDAO();
		String accNo = "1003" + dao.generateRandomNumber(8);
		System.out.println(accNo);
		
		AccountVO vo = new AccountVO();
		vo.setAccNo(accNo);
		vo.setUserId(id);
		vo.setAccPassword(password);
		vo.setBankCode(bankCode);
		vo.setAccType(accType);
		vo.setBalance(balance);
		vo.setProductName(productName);
		
		AccountDAO acc = new AccountDAO();
		acc.newAccount(vo);		
		
		return "jsp/account/accountpage.jsp";
	}

	
}
