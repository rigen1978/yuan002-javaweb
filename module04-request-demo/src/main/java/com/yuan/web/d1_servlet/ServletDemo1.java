package com.yuan.web.d1_servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @className: ServletDemo1
 * @package: com.yuan.web.d1_servlet
 * @description:
 * @author: liyuan
 * @create: 2024/02/02 0:52
 * @version: 1.0
 */
@WebServlet("/demo1")
public class ServletDemo1 implements Servlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("servlet hello~");
	}


	@Override
	public void init(ServletConfig config) throws ServletException {

	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}


	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}
}

