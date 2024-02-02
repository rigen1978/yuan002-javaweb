package com.yuan.web.d2_requset;/**
 * @className: RequsetDemo1
 * @package: com.yuan.web.d2_requset
 * @description:
 * @author: liyuan
 * @create: 2024/02/02 11:56
 * @version: 1.0
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/req6")
public class RequsetDemo6 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("domo6 running~~~");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
