package kr.ac.kopo.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.biz.account.AccountDAO;
import kr.ac.kopo.controller.Controller;

public class ReactivateDormantAccountProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String accNo = request.getParameter("accNo");
		AccountDAO dao = new AccountDAO();
		dao.reactivateDA(accNo);
		
		return "redirect:/myaccount.do";
	}
	
}