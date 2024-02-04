package com.yuan.session;
/**
 * @className: Servlet
 * @package: com.yuan.session
 * @description:
 * @author: liyuan
 * @create: 2024/02/04 14:48
 * @version: 1.0
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/demo1")
public class SessionDemo1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//存储到Session中
		//1. 获取Session对象
		HttpSession session = request.getSession();
		System.out.println(session);
		//2. 存储数据
		session.setAttribute("username", "zs");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
