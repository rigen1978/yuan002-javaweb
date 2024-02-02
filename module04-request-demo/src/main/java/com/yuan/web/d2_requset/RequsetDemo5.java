package com.yuan.web.d2_requset;/**
 * @className: RequsetDemo2
 * @package: com.yuan.web.d2_requset
 * @description:
 * @author: liyuan
 * @create: 2024/02/02 12:01
 * @version: 1.0
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/req5")
public class RequsetDemo5 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("demo5...");
		//System.out.println(request);
		//存储数据
		//request.setAttribute("msg","hello");

		//forward
		request.getRequestDispatcher("/req6").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
