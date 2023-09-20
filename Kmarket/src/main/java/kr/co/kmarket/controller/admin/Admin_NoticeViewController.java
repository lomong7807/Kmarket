package kr.co.kmarket.controller.admin;

import java.io.IOException;

import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.CsDTO;
import kr.co.kmarket.service.CsService;

@WebServlet("/admin/notice/view.do")
public class Admin_NoticeViewController extends HttpServlet {

	private static final long serialVersionUID = 824910349917258619L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CsService service = CsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.info("doGet()...");
		
		String cate1 = req.getParameter("cate1");
		String no    = req.getParameter("no");
		logger.debug("cate1 : " + cate1);
		logger.debug("no    : " + no);
		
		req.setAttribute("cate1", cate1);
		req.setAttribute("board", "view");
		
		CsDTO dto = service.selectBoard(no);
		logger.debug("dto : " + dto);
		req.setAttribute("notice", dto);
		
		if(dto.getGroup() == 1) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/notice/view.jsp");
			dispatcher.forward(req, resp);
			
		}else {
			resp.sendRedirect("./cs/notice/list.do?cate1="+cate1+"&success=101");
		}
	}
}