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
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
      <ul class="navbar-nav">
        <li class="nav-item dropdown">
          <button class="btn btn-dark dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </button>
          <ul class="dropdown-menu dropdown-menu-dark">
            <li><a class="dropdown-item" href="/MYBANK/newaccount.do">계좌 생성</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>

<h1 class="text-center">계좌 생성</h1>
  <form action="abc.do" method="POST" >
  
<label for="product-select">상품명:</label>
<select id="product-select" name="productName">
  <option disabled selected>상품 선택</option>
  <c:forEach var="product" items="${products}">
    <option value="${product.productName}">${product.productName}</option>
    <c:if test="${product.productType eq '예금'}">
      <input type="hidden" name="productType" value="예금">
    </c:if>
    <c:if test="${product.productType eq '적금'}">
      <input type="hidden" name="productType" value="적금">
    </c:if>
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