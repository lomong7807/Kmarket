<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>케이마켓::대한민국 1등 온라인 쇼핑몰</title>
    <link rel="stylesheet" href="./css/style.css"/>
    <link rel="stylesheet" href="../css/style.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <script>
		$(function() {
			
			// 로그인 상태에서 member그룹 접근시 메인화면으로 추후 필터 계획
			if(${sessUser ne null}) {
				location.href = '/Kmarket/index.do?success=101';
			}
			
			// 구현되지 않은 서비스 및 2차 개발 예정인 서비스 알림
			$('.unready').click(function() {
				alert('해당 서비스는 구현중에 있습니다.\n불편을 끼쳐드려 죄송합니다.');
			});
			
		});
	</script>
</head>
<body>
    <div id="wrapper">
        <header>
            <div class="top">
                <div>
					<c:choose>
					<c:when test="${sessUser eq null}">
                    <a href="/Kmarket/member/login.do">로그인</a>
                    <a href="/Kmarket/member/join.do">회원가입</a>
                    </c:when>
                    <c:otherwise>
                    <a href="#" class="unready">마이페이지</a>
                    </c:otherwise>
                    </c:choose>
                    <a href="#" class="unready"><i class="fa fa-shopping-cart" aria-hidden="true">
                    </i>&nbsp;장바구니</a>
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="/Kmarket/index.do">
                        <img src="../images/header_logo.png" alt="로고">
                    </a>
                </div>
            </div>
        </header>