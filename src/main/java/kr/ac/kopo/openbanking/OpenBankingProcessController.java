package kr.ac.kopo.openbanking;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.biz.account.AccountDAO;
import kr.ac.kopo.biz.account.AccountVO;
import kr.ac.kopo.biz.user.UserVO;
import kr.ac.kopo.controller.Controller;

public class OpenBankingProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String bankCode = request.getParameter("bankCode");
		UserVO user = (UserVO)session.getAttribute("loginUser");
		AccountDAO dao = new AccountDAO();
		List<AccountVO> accountList =  dao.selectbankaccountlist(user.getUserEmail(), bankCode);
		
		request.setAttribute("accountList", accountList);
		
		return "/jsp/openbanking/openbanking.jsp";
	}

	
}
