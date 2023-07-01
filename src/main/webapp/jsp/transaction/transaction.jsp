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
<script>
//비밀번호 유효성 검사 함수
function validatePassword() {
    var password = $("#password").val();
    var passwordRegex = /^\d{6}$/;
    if (!passwordRegex.test(password)) {
        $("#password").addClass("is-invalid");
        $("#passwordErrorMessage").text("숫자만 입력 가능합니다");
        return false;
    } else {
        $("#password").removeClass("is-invalid");
        $("#passwordErrorMessage").text("");
        return true;
    }
}

function checkSubmit() {
    var password = $("#password").val();
    var accNo = $("#accNo").val();
    // 유효성 검사 수행
    if (validatePassword()) {
        // 유효성 검사 통과 시 AJAX 요청
        console.log('duplicate check start...')
        $.ajax({
            url: "/MYBANK/checktransactionpassword.do", // 중복 아이디 확인을 위한 서버 요청 URL
            method: "POST",
            data: {password: password,
            		accNo: accNo}, // 폼 데이터 직렬화하여 전송
            success: function(response) {
                response = response.trim();
                if (response === "fail") {
                    alert("비밀번호가 틀립니다");
                } else if (response === "success") {
                    // 유효성 검사와 중복 아이디 확인 모두 통과 시 회원가입 진행
                    $("#transactionForm")[0].submit();
                }
            }
        });
    }
    return false;
}

$(document).ready(function() {
	 
    $("#password").on("input", function() {
        validatePassword();
    });
    
    $("#transactionForm").on("submit", function(event){
    	event.preventDefault();
    })

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
    <a class="nav-link" href="/MYBANK/openbanking.do">오픈뱅킹</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Disabled</a>
  </li>
</ul>

<h1 class="text-center">계좌 이체</h1>
  <form action="transactionprocess.do" method="POST" name="transactionForm" id="transactionForm" onsubmit="return checkSubmit()">
  
<label for="bank-select">이체 은행:</label>
<select id="bank-select" name="DbankCode">
  <option disabled selected>은행 선택</option>
  <c:forEach var="bank" items="${ bankinfo }">
    <option value="${bank.bankCode}">${bank.bankName}</option>
    
   
  </c:forEach>
</select>



    <div class="form-group">
      <label for="acc_no">이체할 계좌 번호</label>
      <input type="hidden" id="accNo" name="accNo" value="${accNo}">
      <input type="hidden" id="balance" name="balance" value="${balance}">
      
      <input type="hidden" name="bankCode" value="${bankCode}">
      
      <input type="text" id="acc_no" name="acc_no" class="form-control" placeholder="이체할 계좌 번호를 입력하세요">
    </div>
    
    <div class="form-group">
      <label for="amount">이체 금액</label>
      <input type="text" id="amount" name="amount" class="form-control" placeholder="금액을 입력하세요">
    </div>
    <div class="form-group">
      <label for="info">받는 통장 메모</label>
      <input type="text" id="info" name="info" class="form-control" placeholder="받는 통장 메모">
    </div>
    <div class="form-group">
      <label for="password">계좌 비밀번호</label>
      <input type="password" id="password" name="password" class="form-control" placeholder="비밀번호 6자리를 입력하세요">
      <span id="passwordErrorMessage"></span>
    </div>
   
    
    <button type="submit" class="btn btn-primary">이체</button>
  </form>
	</section>
	
	<footer>
		<%@ include file="/jsp/include/bottom.jsp" %>
	</footer>
</body>
</html>