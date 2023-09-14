<%@ include file="../_header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	$(document).ready(function(){
		$(".theme-link").click(function(){
			// 현재 클릭한 링크를 강조하기 위해 "on" 클래스를 추가한다.
			$(".theme-link").removeClass("on");
			$(this).addClass("on");
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
          <section class="write">
            <aside>
              <h2>문의하기</h2>
              <ul>
                <li class="theme-link"><a href="./qna_list_member.jsp">회원</a></li>
                <li class="theme-link"><a href="./qna_list_coupon_event.jsp">쿠폰/이벤트</a></li>
                <li class="theme-link"><a href="./qna_list_order_payment.jsp">주문/결제</a></li>
                <li class="theme-link"><a href="./qna_list_delivery.jsp">배송</a></li>
                <li class="theme-link"><a href="./qna_list_cancel_return_exchange.jsp">취소/반품/교환</a></li>
                <li class="theme-link"><a href="./qna_list_travel_lodgment_airline">여행/숙박/항공</a></li>
                <li class="theme-link"><a href="./qna_list_safe.jsp">안전거래</a></li>
              </ul>
            </aside>
            <article>
              <form action="#">
              	<input type="hidden" name="writer" value="${sessUser.uid}">
                <table>
                  <tr>
                    <td>문의유형</td>
                    <td>
                      <select name="type">
                        <option value="0">1차 선택</option>
                        <option>회원</option>
                        <option>쿠폰/이벤트</option>
                        <option>주문/결제</option>
                        <option>배송</option>
                        <option>취소/반품/교환</option>
                        <option>여행/숙박/항공</option>
                        <option>안전거래</option>
                      </select>
                      <select name="type">
                      	<option value="0">2차 선택</option>
                        <option>가입</option>
                        <option>탈퇴</option>
                        <option>회원정보</option>
                        <option>로그인</option>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <td>문의제목</td>                  
                    <td>
                      <input type="text" name="title" placeholder="제목을 입력하세요."/>
                    </td>
                  </tr>                
                  <tr>
                    <td>문의내용</td>                  
                    <td>
                      <textarea name="content" placeholder="내용을 입력하세요."></textarea>
                    </td>
                  </tr>
                </table>
                <div>
                  <a href="./list.jsp" class="btnList">취소하기</a>
                  <input type="submit" class="btnSubmit" value="등록하기"/>
                </div>
              </form>
            </article>
          </section>
        </div>
      </section>
<%@ include file = "../_footer.jsp" %>