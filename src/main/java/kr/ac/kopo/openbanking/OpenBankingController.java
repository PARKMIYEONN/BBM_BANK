package kr.ac.kopo.openbanking;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.biz.bank.BankDAO;
import kr.ac.kopo.biz.bank.BankVO;
import kr.ac.kopo.controller.Controller;

public class OpenBankingController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		BankDAO dao = new BankDAO();
		List<BankVO> bankList = dao.bankList();
		request.setAttribute("bankList", bankList);
		return "/jsp/openbanking/selectbank.jsp";
	}

	
}
