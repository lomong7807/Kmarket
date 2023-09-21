<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<jsp:include page="../_asideNotice.jsp"/>
	<article>
			<nav>
				<h1>${name_dis.cate1_name}</h1>
				<h2>${name_dis.cate1_discription}</h2>
			</nav>
		<table>
			<c:forEach var="notice_list" items="${notice_lists}">
				<tr>
					<td><a href="./view.do?cate1=${notice_list.cate1}&no=${notice_list.no}">${notice_list.title}</a></td>
					<td>${notice_list.rdate}</td>
				</tr>
			</c:forEach>
		</table>
			
		<div class="page">
		    <c:if test="${pageGroupStart > 1}">
		        <a href="${ctxPath}/cs/notice/list.do?cate1=${notice_list.cate1}&pg=${pageGroupStart - 1}" class="prev">이전</a>
		    </c:if>
		    <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
		        <c:choose>
		            <c:when test="${currentPage == i}">
		                <a href="${ctxPath}/cs/notice/list.do?cate1=${cate1}&pg=${i}" class="num on current">${i}</a>
		            </c:when>
		            <c:otherwise>
		                <a href="${ctxPath}/cs/notice/list.do?cate1=${cate1}&pg=${i}" class="num">${i}</a>
		            </c:otherwise>
		        </c:choose>
		    </c:forEach>
		    <c:if test="${pageGroupEnd < lastPageNum}">
		        <a href="${ctxPath}/cs/notice/list.do?cate1=${cate1}&pg=${pageGroupEnd + 1}" class="next">다음</a>
		    </c:if>
		</div>
	</article>
	</section>
	</div>
</section>
	
	
<%@ include file = "../_footer.jsp" %>