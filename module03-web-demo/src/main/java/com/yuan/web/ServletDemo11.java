package com.yuan.web;

import javax.servlet.ServletException;
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
 * * 任意匹配：/
 */

//@WebServlet(urlPatterns = "/")
public class ServletDemo11 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("demo11 get...");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	}
}
