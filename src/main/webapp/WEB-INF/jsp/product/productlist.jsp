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

	
	<section class="container">
  <div class="row justify-content-center">
    <div class="col-md-12">
      <h1 class="text-center">상품 조회</h1>
      <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>상품이름</th>
            <th>상품종류</th>
            <th>생성일</th>
            <th>이율</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="product" items="${products}">
            <tr>
              <td>${product.productName }</td>
              <td>${product.productType }</td>
              <td>${product.releaseDate }</td>
              <td>${product.productRate }</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      
    </div>
    	<form action="insertproduct.do" method="post" class="text-center">
        <button type="submit" class="btn btn-primary">상품등록</button>
      </form>
  </div>
</section>

<style>
  .container {
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
  }
</style>
	
	<footer>
		<%@ include file="/jsp/include/bottom.jsp" %>
	</footer>
</body>
</html>