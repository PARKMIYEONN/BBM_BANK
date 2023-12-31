package kr.ac.kopo.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.biz.account.AccountDAO;
import kr.ac.kopo.controller.Controller;

public class ReactivateDormantAccountController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String accNo = request.getParameter("accNo");
		
		request.setAttribute("accNo", accNo);
		return "/jsp/account/reactivatedormantaccount.jsp";
	}
	
}
