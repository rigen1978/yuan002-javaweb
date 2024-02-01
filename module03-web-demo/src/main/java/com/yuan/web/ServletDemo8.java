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
 * urlPattern:
 * * 精确匹配
 */

@WebServlet(urlPatterns = "/user/select")
public class ServletDemo8 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("demo8 get...");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	}
}