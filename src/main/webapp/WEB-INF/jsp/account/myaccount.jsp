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
      <h1 class="text-center">내 계좌 조회</h1>
      <p>총 계좌 잔액 : ${ totalbalance }</p>
      <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>계좌번호</th>
            <th>상품이름</th>
            <th>은행이름</th>
            <th>잔액</th>
            <th>생성일</th>
            <th>조회</th>
            <th>이체</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="account" items="${myAccount}">
            <tr>
              <td>${account.accNo}</td>
              <td>${account.productName}</td>
              <td>${account.accType}</td>
              <td>${account.balance}</td>
              <td>${account.accCreateDate}</td>
              <td><form method="post" action="/MYBANK/transactionlist.do">
              <input type="hidden" name="accNo" value="${account.accNo}">
              <button>조회</button></form></td>
              <c:if test="${ account.dormantAcc eq '0' }">
              <td><form method="post" action="/MYBANK/transaction.do">
              <input type="hidden" name="balance" value="${account.balance}">
              <input type="hidden" name="accNo" value="${account.accNo}">
              <input type="hidden" name="bankCode" value="${account.bankCode}">      
              <button>이체</button></form></td>
              </c:if>
              
              <c:if test="${ account.dormantAcc eq '1' }">
              <td><form method="post" action="/MYBANK/reactivatedormantaccount.do">
              <input type="hidden" name="accNo" value="${account.accNo}">
              <button>휴면해제하기</button></form></td>
              </c:if>
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