package kr.co.kmarket.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.MemberDTO;

/**
 *	작업시작일 : 2023/09/23
 *	작업종료일 : 2023/09/24
 *	작업자 : 한상민
 *  내용 : sessUser의 level이 seller 등급만 이용 가능하게 함.
 */

public class CheckSellerFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.debug("doFilter...");

		HttpServletRequest httprRequest = (HttpServletRequest) request;
		HttpSession session = httprRequest.getSession();
		MemberDTO sessUser = (MemberDTO) session.getAttribute("sessUser");
        String contextPath = ((HttpServletRequest) request).getContextPath();
		
        if(sessUser == null) { 
			logger.info("sessUser is NULL : " + request.getRemoteAddr());
			((HttpServletResponse)response).sendRedirect(contextPath + "/member/login.do?success=104");
			
		}else if(sessUser.getLevel() >= 4) {
			logger.debug("sessUser's Level : " + sessUser.getLevel());
			chain.doFilter(request, response);
			
		}else {
			logger.info("sessUser is NOT SELLER : " + sessUser.getUid() +"("+ request.getRemoteAddr() +")");
			((HttpServletResponse)response).sendRedirect(contextPath + "/index.do?success=104");
		} 
	}
}