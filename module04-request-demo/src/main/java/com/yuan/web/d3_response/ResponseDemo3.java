package com.yuan.web.d3_response;
/**
 * @className: ResponseDemo1
 * @package: com.yuan.web.d3_response
 * @description:
 * @author: liyuan
 * @create: 2024/02/03 0:17
 * @version: 1.0
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp3")
public class ResponseDemo3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//1. 获取字符输出流
		PrintWriter writer = response.getWriter();
		//content-type
		//response.setHeader("content-type","text/html");

		writer.write("你好");
		writer.write("<h1>aaa</h1>");
		//细节：流不需要关闭

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
