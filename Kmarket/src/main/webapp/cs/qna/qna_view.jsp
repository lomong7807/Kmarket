<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<script>
	$(document).ready(function(){
		$(".theme-link").click(function(){
			// 현재 클릭한 링크를 강조하기 위해 "on" 클래스를 추가한다.
			$(".theme-link").removeClass("on");
			$(this).addClass("on");
		});
	});

	//버튼 클릭 시 이벤트 처리
	document.addEventListener("DOMContentLoaded", function () {
	  // btnList 버튼을 클릭하면 실행될 함수
	  document.querySelector(".btnList").addEventListener("click", function () {
	    // 모든 li 태그 숨기기
	    const liElements = document.querySelectorAll(".theme-link");
	    liElements.forEach(function (li) {
	      li.style.display = "none";
	    });
	  });
	});
</script>
      <section id="cs">
        <div class="qna">
          <nav>
            <div>
              <p>홈<span>></span>문의하기</p>
            </div>
          </nav>
          <section class="view">
            <aside>
              <h2>문의하기</h2>
              <ul>
              	<li class="theme-link"><a href="./qna_list_all.do">전체</a></li>
              	<li class="theme-link"><a href="./qna_list_member.do">회원</a></li>
                <li class="theme-link"><a href="./qna_list_coupon_event.do">쿠폰/이벤트</a></li>
                <li class="theme-link"><a href="./qna_list_order_payment.do">주문/결제</a></li>
                <li class="theme-link"><a href="./qna_list_delivery.jsp">배송</a></li>
                <li class="theme-link"><a href="./qna_list_cancel_return_exchange.jsp">취소/반품/교환</a></li>
                <li class="theme-link"><a href="./qna_list_travel_lodgment_airline">여행/숙박/항공</a></li>
                <li class="theme-link"><a href="./qna_list_safe.jsp">안전거래</a></li>
              </ul>
            </aside>
            <article>
              <nav>
                <h2 class="title"><input type="text" name="title" value="${board.title}" readonly/></h2>                
                <p>
                  <span><input type="text" name="uid" value="${board.uid}" readonly/></span>
                  <span><input type="text" name="rDate" value="${board.rDate}" readonly/></span>
                  
                </p>
              </nav>

              <div class="content">
                <p>${board.content}</p>
              </div>
              <a href="./list.jsp" class="btnList">목록보기</a>
            </article>
          </section>
        </div>
      </section>
<%@ include file="../_footer.jsp" %>