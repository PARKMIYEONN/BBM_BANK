<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<div class="d-flex justify-content-center">
		<a>
		<img src="/MYBANK/jsp/image/ppj.png" alt="mainbreadproduct" width="100%">
		</a>
		<a>
		<img src="/MYBANK/jsp/image/pwy.png" alt="mainwhaleproduct" width="100%">
		</a>
		</div>
		
		<iframe src="http://172.31.9.168:8080/rateProj/rate" width="1000px" height="100px" scrolling="auto"></iframe>
		
	</section>
	
	<footer>
		<%@ include file="/jsp/include/bottom.jsp" %>
	</footer>
</body>
</html>