<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>BBM은행</title>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>

<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp"/>
	</header>
	<section>
<ul class="nav nav-pills nav-fill">
  <li class="nav-item">
    <a class="nav-link active" aria-current="page" href="/MYBANK/newaccount.do">계좌 생성</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/MYBANK/myaccount.do">계좌 조회</a>
  </li>
  <li class="nav-item">
   <a class="nav-link" href="/MYBANK/openbanking.do">오픈뱅킹</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Disabled</a>
  </li>
</ul>

<h1 class="text-center">계좌 이체</h1>
  <form action="openbankingprocess.do" method="POST">
  
<label for="bank-select">은행 선택 : </label>
<select id="bank-select" name="bankCode">
  <option disabled selected>조회할 은행을 선택하세요</option>
  <c:forEach var="bank" items="${bankList}">
  <c:if test="${bank.bankCode ne '1003' }">
    <option value="${bank.bankCode}">${bank.bankName}</option>   
  </c:if>
  </c:forEach>
</select>   
    <button type="submit" class="btn btn-primary">조회</button>
  </form>
	</section>
	
	<footer>
		<%@ include file="/jsp/include/bottom.jsp" %>
	</footer>
</body>
</html>