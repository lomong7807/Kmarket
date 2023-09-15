<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 개발/배포에서 ContextPath 포함 여부에 따른 동적처리 -->
<c:set var="ctxPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>케이마켓::대한민국 1등 온라인 쇼핑몰</title>
    <link rel="stylesheet" href="./css/style.css"/>
    <link rel="stylesheet" href="../css/style.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <script>
        $(document).ready(function () {
            $(".slider > ul").bxSlider({
            easing: "linear",
            });
        });

        $(function () {
            var best = $("aside > .best");

            $(window).scroll(function () {
            var t = $(this).scrollTop();

            if (t > 620) {
                best.css({
                position: "fixed",
                top: "0",
                });
            } else {
                best.css({ position: "static" });
            }
            });
        });
    </script>
    <style>
        #bannerTop {
          display: none;
          width: 100%;
          height: 80px;
          border-bottom: 1px solid #e9e9e9;        
          box-sizing: border-box;
        }
  
        #bannerTop.on {
          display: block;
        }
  
        #bannerTop > article {
          position: relative;
          width: 1200px;
          height: 100%;        
          margin: 0 auto;
          overflow: hidden;
        }
  
        #bannerTop > article > .btnClose {
          position: absolute;
          right: 0px;
          top: 0px;
          width: 40px;
          height: 40px;
          background-image: url('./images/ico_sprite.png');
          background-position: -122px -142px;
          background-color: transparent;
          font-size: 0;
          border: none;
          cursor: pointer;
        }
  
      </style>
</head>
<body>
    <div id="wrapper">
        <header>
            <div class="top">
                <div>
                    <a href="./member/login.html">로그인</a>
                    <a href="#">회원가입</a>
                    <a href="#">마이페이지</a>
                    <a href="#"><i class="fas fa-shopping-cart" aria-hidden="true"></i>&nbsp;장바구니</a>
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="../index.jsp">
                        <img src="../images/header_logo.png" alt="로고">
                    </a>
                </div>
            </div>
            <div class="menu">
                <div>
                  <ul>
                    <li><a href="#">히트상품</a></li>
                    <li><a href="#">추천상품</a></li>
                    <li><a href="#">최신상품</a></li>
                    <li><a href="#">인기상품</a></li>
                    <li><a href="#">할인상품</a></li>
                  </ul>
                  <ul>
                    <li><a href="#">공지사항</a></li>
                    <li><a href="#">자주묻는질문</a></li>
                    <li><a href="#">문의하기</a></li>
                    <li><a href="#">고객센터</a></li>
                  </ul>
                </div>
              </div>
        </header>