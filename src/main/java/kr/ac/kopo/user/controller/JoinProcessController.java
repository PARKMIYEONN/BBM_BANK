package kr.ac.kopo.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.biz.user.UserDAO;
import kr.ac.kopo.biz.user.UserVO;
import kr.ac.kopo.controller.Controller;

public class JoinProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String birthday = request.getParameter("jumin1");
		int gender = Integer.parseInt(request.getParameter("jumin2"));
		String phone = request.getParameter("phone");
		String post = request.getParameter("post");
		String address = request.getParameter("address") + " " + request.getParameter("detailAddress") + " " + request.getParameter("extraAddress");
		
		UserVO vo = new UserVO();
		
		vo.setUserId(id);
		vo.setUserPassword(password);
		vo.setUserName(name);
		vo.setUserEmail(email);
		vo.setUserBirthday(birthday);
		vo.setGender(gender);
		vo.setUserTel(phone);
		vo.setUserPost(post);
		vo.setUserAddress(address);
		
		UserDAO dao = new UserDAO();
		dao.insertUser(vo);
		
		
		
		return "/index.jsp";
	}
	
	

}
