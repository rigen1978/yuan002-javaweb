package com.yuan.web.d1_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: ServletDemo3
 * @package: com.yuan.web.d1_servlet
 * @description:
 * @author: liyuan
 * @create: 2024/02/02 0:53
 * @version: 1.0
 */
@WebServlet("/demo3")
public class ServletDemo3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request クライアントからサーブレットに送られてくるリクエストに関する情報はこのオブジェクトに含まれています。
		// そこでまずは「HttpServletRequest」インターフェースについて見ていきます。
		String name = request.getParameter("name");//url?name=zhangsan

		//response サーブレットはクライアントに何か出力する場合、このオブジェクトを利用して出力を行います。
		// そこでまずは「HttpServletResponse」インターフェースについて見ていきます。
		response.setHeader("content-type", "text/html;charset=utf-8");
		response.getWriter().write("<h1>" + name + ",ようこそ！</h1>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post...");
	}
}