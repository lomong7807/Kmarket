<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 개발/배포에서 ContextPath 포함 여부에 따른 동적처리 -->
<c:set var="ctxPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>케이마켓 고객센터</title>
		<link rel="stylesheet" href="${ctxPath}/cs/css/style.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"/>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
		<script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
	</head>
	<body>
		<div id="wrapper">
			<header>
				<div class="top">
					<div>
						<p>
							<a href="${ctxPath}/member/login.do">로그인</a>
							<a href="${ctxPath}/member/register.do">회원가입</a>
							<a href="#">마이페이지</a>
							<a href="#">
							<i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;장바구니</a>
						</p>
					</div>
				</div>
				<div class="logo">
					<div>
						<a href="${ctxPath}/cs"><img src="${ctxPath}/cs/images/logo.png" alt="로고" />고객센터</a>
					</div>
				</div>
			</header>