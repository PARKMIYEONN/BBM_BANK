package kr.ac.kopo.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.biz.account.AccountDAO;
import kr.ac.kopo.biz.account.AccountVO;
import kr.ac.kopo.biz.user.UserVO;
import kr.ac.kopo.controller.Controller;

public class MyAccountController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		UserVO uvo = (UserVO)session.getAttribute("loginUser");
		String id = uvo.getUserId();
		AccountDAO dao = new AccountDAO();
		List<AccountVO> accList = dao.myAcc(uvo.getUserId());
		
		request.setAttribute("myAccount", accList);
		
		return "/jsp/account/myaccount.jsp";
	}

	
}
