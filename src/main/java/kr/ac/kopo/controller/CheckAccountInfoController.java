package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.biz.account.AccountDAO;
import kr.ac.kopo.biz.account.AccountVO;
import kr.ac.kopo.biz.user.UserVO;

public class CheckAccountInfoController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String accNo = request.getParameter("accNo");
		String accPassword = request.getParameter("accpassword");
		String userName = request.getParameter("name");
		String userEmail = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String phoneNo = request.getParameter("phone");
		
		System.out.println(accNo);
		System.out.println(accPassword);
		System.out.println(userName);
		System.out.println(userEmail);
		System.out.println(birthday);
		System.out.println(phoneNo);
		
		UserVO vo = new UserVO();
		vo.setUserName(userName);
		vo.setUserEmail(userEmail);
		vo.setUserBirthday(birthday);
		vo.setUserTel(phoneNo);
		
		AccountVO avo = new AccountVO();
		avo.setAccPassword(accPassword);
		avo.setAccNo(accNo);
		
		AccountDAO dao = new AccountDAO();
		boolean ismatched = dao.checkAccountInfo(avo, vo);
		
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
