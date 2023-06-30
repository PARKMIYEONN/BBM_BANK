package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.biz.account.AccountDAO;

public class CheckTransactionPassword implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String password = request.getParameter("password");
		System.out.println("계좌 비밀번호" + password);
		String accNo = request.getParameter("accNo");
		System.out.println("내 계좌 번호" + accNo);
		
		AccountDAO dao = new AccountDAO();
		boolean ismatched = dao.checkPassword(password, accNo);
		
		String msg = "";
		if(ismatched) {
			msg = "success";
		} else {
			msg = "fail";
		}
		
		request.setAttribute("msg", msg);
		return "/jsp/login/duplicateMsg.jsp";
	}

	
}
