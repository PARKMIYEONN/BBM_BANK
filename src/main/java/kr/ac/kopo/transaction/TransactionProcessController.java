package kr.ac.kopo.transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.biz.transaction.TransactionDAO;
import kr.ac.kopo.biz.transaction.TransactionVO;
import kr.ac.kopo.controller.Controller;

public class TransactionProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String bankCode = request.getParameter("bankCode");
		String accNo = request.getParameter("accNo");
		String deAccNO = (request.getParameter("acc_no")).replaceAll(bankCode, "");
		String transType = "이체";
		long transAmount = Long.parseLong(request.getParameter("amount"));
		String transInfo = request.getParameter("info");
		
		TransactionVO vo = new TransactionVO();
		vo.setBankCode(bankCode);
		vo.setDepositAccNo(deAccNO);
		vo.setTransType(transType);
		vo.setTransInfo(transInfo);
		vo.setTransAmount(transAmount);
		vo.setAccNo(deAccNO);
		
		
		TransactionDAO dao = new TransactionDAO();
		int ddd;
		try {
			ddd = dao.transfer(accNo, deAccNO, transAmount);
			System.out.println(ddd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.transactionHistory(vo);
		
		
		return "/jsp/account/myaccount.jsp";
	}

	
}
