package com.yuan.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @className: ServletDemo1
 * @package: com.yuan.web
 * @description:
 * @author: liyuan
 * @create: 2024/02/01 12:19
 * @version: 1.0
 */
@WebServlet("/demo1")
public class ServletDemo3 implements Servlet {

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		System.out.println("servlet hello world~~");
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {

	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
}
