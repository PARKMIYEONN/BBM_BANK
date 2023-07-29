<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BBM은행</title>
  <style>
    .brown-theme {
      background-color: #8B4513;
    }

    .brown-theme .nav-link {
      color: white;
    }

    .brown-theme .nav-link:hover {
      color: #8B4513;
      background-color: white;
    }
  </style>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp"/>
	</header>
  <ul class="nav nav-pills nav-fill brown-theme">
      <li class="nav-item">
        <a class="nav-link" aria-current="page" href="/MYBANK/newaccount.do">계좌 생성</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/MYBANK/myaccount.do">계좌 조회</a>
      </li>
      <li class="nav-item">
         <a class="nav-link" href="/MYBANK/openbanking.do">오픈뱅킹</a>
      </li>
    </ul>
<section class="container">
  <div class="row justify-content-center">
    <div class="col-md-12">
      <h1 class="text-center">거래내역</h1>
      <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>거래 일시</th>
            <th>메모</th>
            <th>거래 구분</th>
            <th>거래 금액</th>
            <th>계좌 잔액</th>
            
          </tr>
        </thead>
        <tbody>
          <c:forEach var="history" items="${transactionList}">
            <tr>
              <td>${history.transDate}</td>
              <td>${history.transInfo}</td>
              <td>${history.transType}</td>
              <td>${history.transAmount}</td>
              <td>${history.preBalance}</td>
             
             
            </tr>
          </c:forEach>
        </tbody>
      </table>
      
    </div>
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