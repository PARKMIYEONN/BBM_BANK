package kr.ac.kopo.transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.controller.Controller;

public class TransactionController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String bankCode = request.getParameter("bankCode");
		String accNo = request.getParameter("accNo");
		String transType = "이체";
		long transAmount = Long.parseLong(request.getParameter("amount"));
		String transInfo = request.getParameter("Info");
		
		
		return null;
	}

	
}
