<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
  	html {
  		height:100%;
  	}
  	
  	body{
  		margin:0;
  		
  		display: flex;
  		flex-direction: column;
  		justify-content: space-between;
  		min-height: 100%;
  	}
  	
    .footer-container {
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      align-items: center;
      padding: 1rem;
      margin: 2rem 0;
      border-top: 1px solid #ccc;
    }

    .footer-left {
      display: flex;
      align-items: center;
      flex-basis: 100%;
      margin-bottom: 1rem;
    }

    .footer-logo {
      display: inline-block;
      width: 30px;
      height: 24px;
      margin-right: 0.5rem;
    }

    .footer-text {
      color: #999;
    }

    .footer-right {
      display: flex;
      align-items: center;
      justify-content: flex-end;
      flex-basis: 100%;
    }

    .footer-link {
      display: flex;
      align-items: center;
      margin-left: 1rem;
      color: #999;
      text-decoration: none;
    }

    .footer-link svg {
      width: 24px;
      height: 24px;
      margin-right: 0.5rem;
    }

    .footer-link img {
      width: 24px;
      height: 24px;
    }

    @media (min-width: 768px) {
      .footer-left {
        flex-basis: auto;
        margin-bottom: 0;
      }

      .footer-right {
        flex-basis: auto;
      }
    }
  </style>
</head>
<body>
  <footer class="footer-container">
    <div class="footer-left">
      <svg class="bi footer-logo">
      </svg>
      <span class="footer-text">BBM Bank</span>
    </div>
    <ul class="nav footer-right">
      <li class="ms-3">
        <a class="footer-link" href="https://github.com/PARKMIYEONN">
          <svg class="bi" width="24" height="24">
          </svg>
          <img src="/MYBANK/jsp/image/github.png" alt="Logo">
        </a>
      </li>
    </ul>
  </footer>
</body>
</html>

