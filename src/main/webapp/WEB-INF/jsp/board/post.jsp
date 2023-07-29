<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <div class="col-md-8">
            <div class="card">
                <div class="card-body">
                    <h3 class="post-info">${post.postNo}. <span class="card-title">${post.title}</span></h3>
                    <hr> <!-- 날짜와 콘텐츠 구분선 -->
                    <div class="card-text">
                        <p class="post-info">${post.writer} | ${post.regDate}</p>
                        <div class="content-area">
                            <p>${post.content}</p>
                        </div>
                    </div>
                </div>
            </div>
            
             <!-- Comments Section -->
            <div class="card mt-4">
                <div class="card-body">
                    <h4 class="card-title">댓글</h4>
                    <hr> <!-- Comments and Form Separator -->
                    <div class="comments">
                        <!-- Loop through comments and display them -->
                        <c:forEach items="${comments}" var="comment">
                            <div class="comment">
                                <p class="comment-info">${post.writer} | ${post.regDate}</p>
                                <p>${post.content}</p>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <!-- End of Comments Section -->
        </div>
    </div>
</section>




<style>
    .post-info {
        font-size: 16px;
        color: #888;
    }
    .content-area {
        margin-top: 10px;
    }
    
    .card-title {
        font-size: 20px;
    }
</style>


	
	<footer>
		<%@ include file="/jsp/include/bottom.jsp" %>
	</footer>
</body>
</html>