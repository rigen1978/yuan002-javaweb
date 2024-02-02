package com.yuan.web.d2_requset;
/**
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
import java.nio.charset.StandardCharsets;

@WebServlet("/req4")
public class RequsetDemo4 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println("文字化け前：" + username);
		System.out.println("----------------------------------");
		username = new String(username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
		System.out.println("文字化け解決：" + username);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
