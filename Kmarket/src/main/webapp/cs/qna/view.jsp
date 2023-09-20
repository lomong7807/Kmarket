<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<jsp:include page="../_asideQna.jsp"/>
						<article>
							<nav>
								<h2 class="title">[${qna.cate2_name}] ${qna.title}</h2>
								<p>
									<span>${qna.maskingUid}</span>
									<span>${qna.rdate}</span>
								</p>
							</nav>
							
							<div class="content">
								<p>
									${qna.content}
								</p>
								<p>
									※ 피싱 관련 피해신고<br/><br/>
									▶ 경찰청 사이버수사국 (국번없이)182 :
									http://cyberbureau.police.go.kr<br/>
									▶ KISA 인터넷침해대응센터 (국번없이)118 :
									http://www.krcert.or.kr<br/>
									감사합니다.<br/>
								</p>
							</div>
							<c:if test="${ans ne null}">
							<div class="answer">
								<h2 class="title">☞ [답변] ${ans.title}</h2>
								<p>
									${ans.content}
								</p>
							</div>
							</c:if>
							<a href="${ctxPath}/cs/qna/list.do?cate1=${cate1}" class="btnList">목록보기</a>
						</article>
					</section>
				</div>
			</section>
<%@ include file="../_footer.jsp" %>