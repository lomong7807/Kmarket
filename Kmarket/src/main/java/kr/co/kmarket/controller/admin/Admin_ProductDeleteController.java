package kr.co.kmarket.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.service.ProductService;

@WebServlet("/admin/product/delete.do")
public class Admin_ProductDeleteController extends HttpServlet {

	private static final long serialVersionUID = 1232344352L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.sendRedirect("/admin/product/list.do");
	}
	
}