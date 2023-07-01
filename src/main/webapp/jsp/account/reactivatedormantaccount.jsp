<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
  .container {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .form-group {
    width: 400px;
  }

  .text-center {
    text-align: center;
  }
  
   span {
    color: red;
    font-size: smaller;
  }
</style>
</head>
<body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

// 비밀번호 유효성 검사 함수
function validatePassword() {
    var password = $("#password").val();
    var passwordRegex = /^[a-zA-Z0-9]{1,16}$/;
    if (!passwordRegex.test(password)) {
        $("#password").addClass("is-invalid");
        $("#passwordErrorMessage").text("영문과 숫자만 입력 가능합니다");
        return false;
    } else {
        $("#password").removeClass("is-invalid");
        $("#passwordErrorMessage").text("");
        return true;
    }
}


function validatePhoneNumber() {
    var phoneNumber = $("#phone").val();
    var phoneNumberRegex = /^01[0-9]{1}-[0-9]{4}-[0-9]{4}$/;
    if (!phoneNumberRegex.test(phoneNumber)) {
        $("#phone").addClass("is-invalid");
        $("#phoneErrorMessage").text("-를 포함한 번호를 입력하세요");
        return false;
    } else {
        $("#phone").removeClass("is-invalid");
        $("#phoneErrorMessage").text("");
        return true;
    }
}

function validateEmail() {
    var email = $("#email").val();
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        $("#email").addClass("is-invalid");
        $("#emailErrorMessage").text("이메일 형식이 아닙니다");
        return false;
    } else {
        $("#email").removeClass("is-invalid");
        $("#emailErrorMessage").text("");
        return true;
    }
}


function checkSubmit() {
	var accNo = $("#accNo").val();
    var accpassword = $("#accpassword").val();
    var name = $("#name").val();
    var email = $("#email").val();
    var birthday = $("#jumin1").val();
    var phone = $("#phone").val();
    // 유효성 검사 수행
    if (validatePassword()) {
        // 유효성 검사 통과 시 AJAX 요청
        console.log('duplicate check start...')
        $.ajax({
            url: "/MYBANK/checktaccountinfo.do", // 중복 아이디 확인을 위한 서버 요청 URL
            method: "POST",
            data: {accNo: accNo,
            		accpassword: accpassword,
            		name: name,
            		email: email,
            		birthday: birthday,
            		phone: phone}, // 폼 데이터 직렬화하여 전송
            success: function(response) {
                response = response.trim();
                if (response === "fail") {
                    alert("정보가 올바르지 않습니다");
                } else if (response === "success") {
                    // 유효성 검사와 중복 아이디 확인 모두 통과 시 회원가입 진행
                    $("#reactivateForm")[0].submit();
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
    
    $("#phone").on("input", function() {
        validatePhoneNumber();
    });
    
    $("#email").on("input", function() {
        validateEmail();
    });

    // 회원가입 양식 제출 시 유효성 검사
    $("#reactivateForm").on("submit", function(event) {
        event.preventDefault(); // 기본 제출 동작 중지
    });
});

</script>
<header>
  <jsp:include page="/jsp/include/topMenu.jsp" />
</header>
<section class="container">
  <h1 class="text-center">휴면계좌 해제 신청</h1>
  <form action="reactivatedormantaccountprocess.do" method="POST" class="text-center" name="inputForm" id="reactivateForm" onsubmit="return checkSubmit()" >
     <div class="form-group">
      <label for="accpassword">계좌 비밀번호</label>
      <input type="password" id="accpassword" name="accpassword" class="form-control" placeholder="계좌비밀번호">
       <span id="accpasswordErrorMessage"></span>
    </div>
    <div class="form-group">
      <label for="name">이름</label>
      <input type="text" id="name" name="name" class="form-control" placeholder="이름">
    </div>
    <div class="form-group">
      <label for="email">이메일</label>
      <input type="email" id="email" name="email" class="form-control" placeholder="이메일">
       <span id="emailErrorMessage"></span>
    </div>
    <div class="form-group">
      <label for="jumin1">생년월일</label>
      <input type="text" id="jumin1" name="jumin1" class="form-control" placeholder="주민등록번호 앞 6자리" pattern="[0-9]{6}">
    </div>
    <div class="form-group">
      <label for="phone">전화번호</label>
      <input type="tel" id="phone" name="phone" class="form-control" placeholder="010-0000-0000" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}">
      <span id="phoneErrorMessage"></span>
 	<input type="hidden" id="accNo" name="accNo" value="${accNo}">
    </div>
    <button type="submit" class="btn btn-primary">해제 신청</button>
  </form>
</section>


<footer>
  <%@ include file="/jsp/include/bottom.jsp" %>
</footer>
</body>
</html>