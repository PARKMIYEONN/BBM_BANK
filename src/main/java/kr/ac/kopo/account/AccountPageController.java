package kr.ac.kopo.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.controller.Controller;

public class AccountPageController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		
		return "/jsp/account/accountpage.jsp";
	}

	
}
