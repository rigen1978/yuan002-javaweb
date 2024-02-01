package com.yuan.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: ServletDemo1
 * @package: com.yuan.web
 * @description:
 * @author: liyuan
 * @create: 2024/02/01 12:19
 * @version: 1.0
 */

/**
 * urlPattern:一个Servlet可以配置多个访问路径
 */

@WebServlet(urlPatterns = {"/demo7", "/demo8"})
public class ServletDemo7 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("demo7 get...");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	}
}