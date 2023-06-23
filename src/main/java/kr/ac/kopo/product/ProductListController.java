package kr.ac.kopo.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.biz.product.ProductDAO;
import kr.ac.kopo.biz.product.ProductVO;
import kr.ac.kopo.controller.Controller;

public class ProductListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ProductDAO dao = new ProductDAO();
		List<ProductVO> product = dao.productList();
		request.setAttribute("products", product);
		return "/jsp/product/productlist.jsp";
	}

	
	
}
