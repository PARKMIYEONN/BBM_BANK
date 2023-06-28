package kr.ac.kopo.transaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.biz.bank.BankDAO;
import kr.ac.kopo.biz.bank.BankVO;
import kr.ac.kopo.controller.Controller;

public class TransactionController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String accNo = request.getParameter("accNo");
		String bankCode = request.getParameter("bankCode");
		HttpSession session = request.getSession();
		BankDAO dao = new BankDAO();
		List<BankVO> bank = dao.bankList();
		session.setAttribute("bankinfo", bank);
		session.setAttribute("accNo", accNo);
		session.setAttribute("bankCode", bankCode);
		return "/jsp/transaction/transaction.jsp";
	}

	
}
