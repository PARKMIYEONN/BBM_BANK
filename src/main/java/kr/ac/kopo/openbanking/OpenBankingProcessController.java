package kr.ac.kopo.openbanking;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

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
		long totalBalance = dao.selectedtotalbalance(user.getUserEmail(), bankCode);
		
		NumberFormat currencyFormatKorea = NumberFormat.getInstance(Locale.KOREA);
        String formattedAmountKorea = currencyFormatKorea.format(totalBalance) + "원";
		
		request.setAttribute("accountList", accountList);
		request.setAttribute("totalBalance", formattedAmountKorea);
		
		return "/jsp/openbanking/openbanking.jsp";
	}

	
}
