package com.yuan.web;
/**
 * @className: Servlet
 * @package: com.yuan.web
 * @description:
 * @author: liyuan
 * @create: 2024/02/07 0:21
 * @version: 1.0
 */

import com.yuan.util.CheckCodeUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//認証コードを生成する
		ServletOutputStream os = response.getOutputStream();
		String checkCode = CheckCodeUtil.outputVerifyImage(100, 50, os, 4);

		//sessionに格納
		HttpSession session = request.getSession();
		session.setAttribute("checkCodeGen", checkCode);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
