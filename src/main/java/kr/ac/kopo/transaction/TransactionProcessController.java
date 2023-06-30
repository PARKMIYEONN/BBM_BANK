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
		System.out.println(bankCode);
		String DbankCode = request.getParameter("DbankCode");
		String accNo = request.getParameter("accNo");
		String deAccNO = request.getParameter("acc_no");
		long transAmount = Long.parseLong(request.getParameter("amount"));
		String transInfo = request.getParameter("info");
		long preBalance = Long.parseLong(request.getParameter("balance"));
		
		TransactionVO vo = new TransactionVO();
		vo.setBankCode(bankCode);
		vo.setDepositBankCode(DbankCode);
		vo.setDepositAccNo(deAccNO);
		
		vo.setTransInfo(transInfo);
		vo.setTransAmount(transAmount);
		vo.setAccNo(accNo);
		vo.setPreBalance(preBalance);
		
		
		TransactionDAO dao = new TransactionDAO();
		int rcheck;
		try {
			rcheck = dao.bankSelect(vo);
			System.out.println(rcheck);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return "redirect:/myaccount.do";
	}

	
}
