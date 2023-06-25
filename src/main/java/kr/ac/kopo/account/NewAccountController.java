package kr.ac.kopo.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.biz.account.AccountDAO;
import kr.ac.kopo.biz.account.AccountVO;
import kr.ac.kopo.biz.product.ProductDAO;
import kr.ac.kopo.biz.product.ProductVO;
import kr.ac.kopo.biz.user.UserVO;
import kr.ac.kopo.controller.Controller;

public class NewAccountController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		ProductDAO dao = new ProductDAO();
		List<ProductVO> product = dao.productList();
		
		session.setAttribute("products", product);
		
		return "jsp/account/newaccount.jsp";
		
	}
	
	

}
