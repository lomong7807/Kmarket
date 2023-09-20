<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<main id="product">
    <%@ include file="./_aside.jsp" %>
    <!-- 주문 페이지 시작 -->
    <section class="order">
        <!-- 제목, 페이지 네비게이션 -->
        <nav>
            <h1>주문결제</h1>
            <p>
                HOME > 장바구니 > 
                <strong>주문결제</strong>
            </p>
        </nav>
        <form action="#">
            <!-- 주문 상품 목록 -->
            <table>
                <thead>
                    <tr>
                        <th>상품명</th>
                        <th>총수량</th>
                        <th>판매가</th>
                        <th>배송비</th>
                        <th>소계</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="empty">
                        <td colspan="7">장바구니에 상품이 없습니다.</td>
                    </tr>
                    <c:forEach var="cart" items="${carts}">
                    <tr>
                        <td>
                            <article>
                                <a href="${ctxPath}/product/view.do?cate1=${cart.prodCate1}&cate2=${cart.prodCate2}&prodNo=${cart.prodNo}">
                                    <img src="${ctxPath}/thumb/${cart.prodCate1}/${cart.prodCate2}/${cart.thumb1}" alt="">
                                </a>
                                <div>
                                    <h2>
                                        <a href="${ctxPath}/product/view.do?cate1=${cart.prodCate1}&cate2=${cart.prodCate2}&prodNo=${cart.prodNo}">${cart.prodName}</a>
                                    </h2>
                                    <p>상품설명:${cart.descript}</p>
                                </div>
                            </article>
                        </td>
                        <td><fmt:formatNumber value="${cart.count}" pattern="#,###" /></td>
                        <td><fmt:formatNumber value="${cart.orgPrice}" pattern="#,###" /></td>
                        <c:if test="${cart.delivery ne 0}">
                        <td><fmt:formatNumber value="${cart.delivery}" pattern="#,###" /></td>
                        </c:if>
                        <c:if test="${cart.delivery eq 0}">
                        <td class="free-delivery">${cart.delivery}</td>
                        </c:if>
                        <td><fmt:formatNumber value="${cart.total}" pattern="#,###" /></td>
                    </tr>
                    </c:forEach>
                    <tr>
                        <td>
                            <article>
                                <a href="#">
                                    <img src="./images/80x80.png" alt="">
                                </a>
                                <div>
                                    <h2>
                                        <a href="#">상품명</a>
                                    </h2>
                                    <p>상품설명</p>
                                </div>
                            </article>
                        </td>
                        <td>1</td>
                        <td>27000</td>
                        <td>무료배송</td>
                        <td>27000</td>
                    </tr>
                    <tr>
                        <td>
                            <article>
                                <a href="#">
                                    <img src="./images/80x80.png" alt="">
                                </a>
                                <div>
                                    <h2>
                                        <a href="#">상품명</a>
                                    </h2>
                                    <p>상품설명</p>
                                </div>
                            </article>
                        </td>
                        <td>1</td>
                        <td>27000</td>
                        <td>무료배송</td>
                        <td>27000</td>
                    </tr>
                </tbody>
            </table>
            <!-- 최종 결제 정보 -->
            <div class="final">
                <h2>최종결제 정보</h2>
                <table border="0">
                    <tbody>
                        <tr>
                            <td>총</td>
                            <td>2 건</td>
                        </tr>
                        <tr>
                            <td>상품금액</td>
                            <td>27000</td>
                        </tr>
                        <tr>
                            <td>할인금액</td>
                            <td>-1000</td>
                        </tr>
                        <tr>
                            <td>배송비</td>
                            <td>0</td>
                        </tr>
                        <tr>
                            <td>포인트 할인</td>
                            <td>-1000</td>
                        </tr>
                        <tr>
                            <td>전체주문금액</td>
                            <td>25000</td>
                        </tr>
                    </tbody>
                </table>
                <input type="button" name value="결제하기">
            </div>
            <!-- 배송정보 -->
            <article class="delivery">
                <h1>배송정보</h1>
                <table>
                    <tbody>
                        <tr>
                            <td>주문자</td>
                            <td>
                                <input type="text" name="orderer">
                            </td>
                        </tr>
                        <tr>
                            <td>휴대폰</td>
                            <td>
                                <input type="text" name="hp">
                                <span>- 포함 입력</span>
                            </td>
                        </tr>
                        <tr>
                            <td>우편번호</td>
                            <td>
                                <input type="text" name="zip">
                                <input type="button" value="검색">
                            </td>
                        </tr>
                        <tr>
                            <td>기본주소</td>
                            <td>
                                <input type="text" name="addr1">
                            </td>
                        </tr>
                        <tr>
                            <td>상세주소</td>
                            <td>
                                <input type="text" name="addr2">
                            </td>
                        </tr>
                    </tbody>
                </table>
            </article>
            <!-- 할인정보 -->
            <article class="discount">
                <h1>할인정보</h1>
                <div>
                    <p>
                        현재 포인트 : 
                        <span>7200</span>
                        점
                    </p>
                    <label>
                        <input type="text" name="point">
                        점
                        <input type="button" value="적용">
                    </label>
                    <span>포인트 5000점 이상이면 현금처럼 사용 가능합니다.</span>
                </div>
            </article>
            <!-- 결제방법 -->
            <article class="payment">
                <h1>결제방법</h1>
                <div>
                    <span>신용카드</span>
                    <p>
                        <label>
                            <input type="radio" name="payment" value="type1">
                            신용카드 결제
                        </label>
                        <label>
                            <input type="radio" name="payment" value="type2">
                            체크카드 결제
                        </label>
                    </p>
                </div>
                <div>
                    <span>계좌이체</span>
                    <p>
                        <label>
                            <input type="radio" name="payment" value="type3">
                            실시간 계좌이체
                        </label>
                        <label>
                            <input type="radio" name="payment" value="type4">
                            무통장 입금
                        </label>
                    </p>
                </div>
                <div>
                    <span>기타</span>
                    <p>
                        <label>
                            <input type="radio" name="payment" value="type3">
                            휴대폰 결제
                        </label>
                        <label>
                            <input type="radio" name="payment" value="type4">
                            카카오페이
                            <img src="./images/ico_kakaopay.gif" alt="카카오페이">
                        </label>
                    </p>
                </div>
            </article>
            <!-- 경고 -->
            <article class="alert">
                <ul>
                    <li>
                        <span>
                            케이마켓의 모든 판매자는 안전거래를 위해 구매금액, 결제수단에 상관없이 모든거래에 대하여 케
                            이마켓 유한책임회사의 구매안전서비스(에스크로)를 제공하고 있습니다.
                        </span>
                    </li>
                    <li>
                        <span>
                            케이마켓 유한책임회사의 전자금융거래법에 의해 결제대금예치업 등록번호는 02-006-00008 입니다.
                        </span>
                    </li>
                    <li>
                        <span>
                            등록여부는 금융감독원 홈페이지(www.fss.or.kr)의 업무자료>인허가업무안내>전자금융업등록현황
                            에서 확인하실수 있습니다.
                        </span>
                    </li>
                </ul>
            </article>
        </form>
    </section>
    <!-- 주문 페이지 끝 -->
</main>
<%@ include file="./_footer.jsp" %>