<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BBM은행</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

  <!-- 부트스트랩 CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

  <!-- 부트스트랩 JavaScript (Popper.js와 Bootstrap 스크립트 포함) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>

//비밀번호 유효성 검사 함수
function validatePassword() {
    var password = $("#password").val();
    var passwordRegex = /^\d{6}$/;
    if (!passwordRegex.test(password)) {
        $("#password").addClass("is-invalid");
        return false;
    } else {
        $("#password").removeClass("is-invalid");
        return true;
    }
}

function checkPassword(){
	var password = $("#password").val();
	var chkpassword = $("#chkpassword").val();
	if(password !== chkpassword){
		$("#chkpassword").addClass("is-invalid");
		return false;
	} else {
		$("#chkpassword").removeClass("is-invalid");
		return true;	
	}
}

$(document).ready(function() {
 
    $("#password").on("input", function() {
        validatePassword();
    });
    
    $("#chkpassword").on("input", function() {
    	checkPassword();
    });

});

</script>
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
    <a class="nav-link" href="#">Link</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Disabled</a>
  </li>
</ul>

<h1 class="text-center">계좌 생성</h1>
  <form action="abc.do" method="POST" >
  
<label for="product-select">상품명:</label>
<select id="product-select" name="productName">
  <option disabled selected>상품 선택</option>
  <c:forEach var="product" items="${products}">
    <option value="${product.productName}">${product.productName}</option>
   
  </c:forEach>
</select>



    <div class="form-group">
      <label for="password">계좌 비밀번호</label>
      <input type="password" id="password" name="password" class="form-control" placeholder="6자리 숫자 입력">
    </div>
    <div class="form-group">
      <label for="chkpassword">계좌 비밀번호 확인</label>
      <input type="password" id="chkpassword" name="chkpassword" class="form-control" placeholder="비밀번호 확인">
    </div>
   
    
    <button type="submit" class="btn btn-primary">계좌 생성</button>
  </form>
	</section>
	
	<footer>
		<%@ include file="/jsp/include/bottom.jsp" %>
	</footer>
</body>
</html>