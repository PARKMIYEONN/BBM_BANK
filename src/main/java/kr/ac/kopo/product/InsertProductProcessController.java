package kr.ac.kopo.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.biz.product.ProductDAO;
import kr.ac.kopo.biz.product.ProductVO;
import kr.ac.kopo.controller.Controller;

public class InsertProductProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String productName = request.getParameter("pname");
		String productType = request.getParameter("ptype");
		String endDate = request.getParameter("edate");
		String pRate = request.getParameter("prate");
		
		ProductVO vo = new ProductVO();
		vo.setProductName(productName);
		vo.setProductType(productType);
		vo.setEndDate(endDate);
		vo.setProductRate(Integer.parseInt(pRate));
		
		ProductDAO dao = new ProductDAO();
		dao.insertProduct(vo);
		return "/jsp/product/insertproduct.jsp";
		
	}
	
}

	

