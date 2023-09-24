<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<main>
    <%@ include file="../_aside.jsp" %>
    <section id="admin-cs-view">
	     <nav>
	            <h3>문의사항</h3>
	            <p>
	                HOME > 고객센터 > <strong>문의사항</strong>
	            </p>
	        </nav>
	    <article>
	    <form action="${ctxPath}/admin/qna/answer.do" method="post">
            <input type="hidden" name="group" value="${qna.group}">
            <input type="hidden" name="no" value="${qna.no}">
            <input type="hidden" name="uid" value="${qna.uid}">
            <input type="hidden" name="cate1" value="${qna.cate1}">
            <input type="hidden" name="cate2" value="${qna.cate2}">
            <input type="hidden" name="title" value="${qna.title}">
			<table class="cstable">
				<tr class="cstable1">
					<td>유형</td>
					<td>${qna.cate1_name}-${qna.cate2_name}</td>
				</tr>
				<tr class="cstable2">
					<td>제목</td>
					<td>${qna.title}</td>
				</tr>
				<tr class="cstable3">
					<td>내용</td>
					<td>${qna.content}<br/><br/>
					※ 피싱 관련 피해신고<br/><br/>
					▶ 경찰청 사이버수사국 (국번없이)182 :
					http://cyberbureau.police.go.kr<br/>
					▶ KISA 인터넷침해대응센터 (국번없이)118 :
					http://www.krcert.or.kr<br/>
					감사합니다.<br/></td>
				</tr>
				<tr class="cstable4">
				<td>답변</td>
                  <td>
                      <textarea name="content" rows="4" cols="50"></textarea>
                  </td>
                </tr>
                </table>
                <input type="submit" value="답변 제출">
            </form>
            <a href="${ctxPath}/admin/qna/delete.do?no=${qna.no}" class="btnViewDelete">삭제</a>
            <a href="${ctxPath}/admin/qna/list.do?group=3&pg=1" class="btnList">목록</a>
		</article>
	</section>
</main>		
<%@ include file="../_footer.jsp" %>