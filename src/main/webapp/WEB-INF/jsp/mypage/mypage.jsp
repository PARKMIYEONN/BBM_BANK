<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BBM은행</title>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp"/>
	</header>
	<section>
		<ul>
			<li>아이디 : ${ user.userId }</li>
			<li>이름 : ${ user.userName }</li>
			<li>전화번호 : ${ user.userTel }</li>
			<li>이메일 : ${ user.userEmail }</li>
			<li>생 일 : ${ user.userBirthday }</li>
			<li>주소 : ${ user.userAddress }</li>
			<li><c:if test="${ user.gender == 1 }">남</c:if>
				<c:if test="${ user.gender == 2 }">여</c:if>
				
			<li>비밀번호 수정</li>
			<li>회원탈퇴</li>
		</ul>
		
	</section>
	
	<footer>
		<%@ include file="/jsp/include/bottom.jsp" %>
	</footer>
</body>
</html>