package kr.ac.kopo.openbanking;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.biz.account.AccountDAO;
import kr.ac.kopo.biz.account.AccountVO;
import kr.ac.kopo.biz.user.UserVO;
import kr.ac.kopo.controller.Controller;

public class OpenBankingController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO)session.getAttribute("loginUser");
		AccountDAO dao = new AccountDAO();
		List<AccountVO> accountListBJ =  dao.accountListBJ(user.getUserEmail());
		
		request.setAttribute("accountListBJ", accountListBJ);
		
		return "/jsp/openbanking/openbanking.jsp";
	}

	
}
