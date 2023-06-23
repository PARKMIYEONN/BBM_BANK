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
	<div>
		<table>
		<c:forEach var="product" items="${ products }">
			<tr>
				<td>${product.productName }</td>
				<td>${product.productType }</td>
				<td>${product.releaseDate }</td>
				<td>${product.endDate }</td>
				<td>${product.productRate }</td>
			</tr>
			</c:forEach>
		</table>
		<form action="insertproduct.do" method="post" class="text-center">
        <button type="submit" class="btn btn-primary">상품등록</button>
      </form>
		</div>
	</section>
	
	<footer>
		<%@ include file="/jsp/include/bottom.jsp" %>
	</footer>
</body>
</html>