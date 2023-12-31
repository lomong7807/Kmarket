<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./_header.jsp" %>
<script>
	$(function() {
		$('.regSelBtn').click(function(e) {
			e.preventDefault();
			if(confirm('판매자 회원가입 페이지로 이동하시겠습니까?')){
				location.href = '${ctxPath}/member/signup.do?type=seller';
			}else{
				return false;
			}
		})
	});
</script>
      <section id="cs">
        <div class="main">
          <h1 class="title"><strong>케이마켓</strong>이 도와드릴게요!</h1>   
          
          
          <!-- 공지사항 -->           
          <section class="notice">
            <h1>공지사항<a href="${ctxPath}/cs/notice/list.do?cate1=1">전체보기</a></h1>
            <ul>
            <c:forEach var="notice_list" items="${notice_lists}" begin="0" step="1" end="4">            
            	<li>
            		<a href="${ctxPath}/cs/notice/view.do?cate1=${notice_list.cate1}&no=${notice_list.no}" class="title">[${notice_list.cate1_name}] <c:out value="${notice_list.title}"/></a>
            		<span class="date">${notice_list.rdate}</span>
            	</li>
            </c:forEach>
            </ul>
          </section>
        
        
          <!-- 자주 묻는 질문 --> 
          <section class="faq">
            <h1>자주 묻는 질문<a href="${ctxPath}/cs/faq/list.do?group=2&cate1=1">전체보기</a>
            </h1>
            <ol>
              <li>
                <a href="${ctxPath}/cs/faq/list.do?cate1=1"><span>회원</span></a>
              </li>
              <li>
                <a href="${ctxPath}/cs/faq/list.do?cate1=2"><span>쿠폰/이벤트</span></a>
              </li>
              <li>
                <a href="${ctxPath}/cs/faq/list.do?cate1=3"><span>주문/결제</span></a>
              </li>
              <li>
                <a href="${ctxPath}/cs/faq/list.do?cate1=4"><span>배송</span></a>
              </li>
              <li>
                <a href="${ctxPath}/cs/faq/list.do?cate1=5"><span>취소/반품/교환</span></a>
              </li>
              <li>
                <a href="${ctxPath}/cs/faq/list.do?cate1=6"><span>여행/숙박/항공</span></a>
              </li>
              <li>
                <a href="${ctxPath}/cs/faq/list.do?cate1=7"><span>안전거래</span></a>
              </li>
            </ol>
          </section>
        
        
        
		  <!-- 문의하기 --> 
          <section class="qna">
            <h1>문의하기<a href="${ctxPath}/cs/qna/list.do?cate1=1">전체보기</a></h1>
            <ul>
            <c:forEach var="qna_list" items="${qna_lists}" begin="0" step="1" end="4">
            	<li>
                	<a href="${ctxPath}/cs/qna/view.do?cate1=${qna_list.cate1}&no=${qna_list.no}" class="title">[${qna_list.cate1_name}] <c:out value="${qna_list.title}"/></a>
                	<p>
                  		<span class="uid">${qna_list.maskingUid}</span>
                  		<span class="date">${qna_list.rdate}</span>
                	</p>
            	</li>
            </c:forEach>
            </ul>
            <a href="${ctxPath}/cs/qna/write.do?cate1=1" class="ask">문의글 작성 ></a>
          </section>

          <section class="tel">
            <h1>
              1:1 상담이 필요하신가요?
            </h1>

            <article>
              <div>
                <h3>고객센터 이용안내</h3>
                <p>
                  <span>일반회원/비회원</span><br>
                  <strong>1566-0001</strong><span>(평일 09:00 ~ 18:00)</span>
                </p>
                <p>
                  <span>스마일클럽 전용</span><br>
                  <strong>1566-0002</strong><span>(365일 09:00 ~ 18:00)</span>
                </p>
              </div>
            </article>
            <article>
              <div>
                <h3>판매상담 이용안내</h3>
                <p>
                  <span>판매고객</span><br>
                  <strong>1566-5700</strong><span>(평일 09:00 ~ 18:00)</span>
                </p>
                <p>
                  <a href="#" class="regSelBtn">판매자 가입 및 서류 접수 안내 〉</a>
                </p>                
              </div>
            </article>
          </section>        
      </section>
<%@ include file = "./_footer.jsp" %>