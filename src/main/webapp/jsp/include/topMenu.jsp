<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>MY은행</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style>

@font-face {
    font-family: 'NanumSquareNeo-Variable';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_11-01@1.0/NanumSquareNeo-Variable.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}

  .btn-outline-primary {
    border-color: #8B4513;
    color: #8B4513;
  }

  .btn-primary {
    background-color: #8B4513;
    border-color: #8B4513;
  }

  .btn-outline-primary:hover {
    background-color: #654321;
    border-color: #654321;
    color: #8B4513;
  }

  .btn-primary:hover {
    background-color: #654321;
    border-color: #654321;
  }
  
  body {
   margin : 0;
   font-family: 'NanumSquareNeo-Variable';
   padding : 2%;
}
  
</style>
</head>
<body>
<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
  <div class="col-md-3 text-center">
    <a href="/MYBANK/index.do" class="d-flex align-items-center text-dark text-decoration-none">
      <img src="/MYBANK/jsp/image/logob.png" alt="Logo" width="325">
      <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
    </a>
  </div>

  <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
    <li><a href="/MYBANK/index.do" class="nav-link px-2 link-secondary">Home</a></li>
    <li><a href="${pageContext.request.contextPath }/board" class="nav-link px-2 link-dark">문의게시판</a></li>
    <c:if test="${ loginUser.userId eq 'admin01' }">
    <li><a href="/MYBANK/productlist.do" class="nav-link px-2 link-dark">상품등록</a></li>
    </c:if>
    <c:if test="${ not empty loginUser}">
    <c:if test="${ loginUser.userId ne 'admin01' }">
    <li><a href="/MYBANK/accountpage.do" class="nav-link px-2 link-dark">내계좌</a></li>
    </c:if>
    </c:if>
  </ul>

  <div class="col-md-3 text-end">
    <c:if test="${ empty loginUser }">
      <button type="button" class="btn btn-outline-primary me-2" onclick="window.location.href='/MYBANK/login.do'">로그인</button>
      <button type="button" class="btn btn-primary" onclick="window.location.href='/MYBANK/join.do'">회원가입</button>
    </c:if>
    <c:if test="${ not empty loginUser }">
      <button type="button" class="btn btn-outline-primary me-2" onclick="window.location.href='/MYBANK/logout.do'">로그아웃</button>
      <button type="button" class="btn btn-primary" onclick="window.location.href='/MYBANK/mypage.do'">마이페이지</button>
    </c:if>
  </div>
</header>

<div class="topcontainer"></div>

</body>
</html>

