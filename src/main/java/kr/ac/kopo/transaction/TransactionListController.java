package kr.ac.kopo.transaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.biz.transaction.TransactionDAO;
import kr.ac.kopo.biz.transaction.TransactionVO;
import kr.ac.kopo.controller.Controller;

public class TransactionListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String accNo = request.getParameter("accNo");
		TransactionDAO tdao = new TransactionDAO();
		List<TransactionVO> transactionList = tdao.transactionList(accNo);
		
		request.setAttribute("transactionList", transactionList);
		
		return "/jsp/transaction/transactionlist.jsp";
	}

	
}
