package com.yuan.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @className: LoginFilter
 * @package: com.yuan.web.filter
 * @description:
 * @author: liyuan
 * @create: 2024/02/07 0:32
 * @version: 1.0
 */

@WebFilter("/*")
public class LoginFilter implements Filter {


	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		String[] urls = {"/login.jsp", "/imgs/", "/css/", "/loginServlet", "/register.jsp", "/registerServlet", "/checkCodeServlet"};

		String url = req.getRequestURL().toString();

		for (String u : urls) {
			if (url.contains(u)) {
				filterChain.doFilter(servletRequest, servletResponse);
				return;
			}

		}

		HttpSession session = req.getSession();
		Object user = session.getAttribute("user");

		if (user != null) {
			filterChain.doFilter(servletRequest, servletResponse);
		} else {
			req.setAttribute("login_msg", "ログインしてください。");
			req.getRequestDispatcher("/login.jsp").forward(req, servletResponse);
		}


	}


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}


	@Override
	public void destroy() {
		Filter.super.destroy();
	}
}
