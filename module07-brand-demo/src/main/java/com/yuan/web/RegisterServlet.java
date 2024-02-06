package com.yuan.web;
/**
 * @className: Servlet
 * @package: com.yuan.web
 * @description:
 * @author: liyuan
 * @create: 2024/02/04 19:18
 * @version: 1.0
 */

import com.yuan.pojo.User;
import com.yuan.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ユーザ名とパスワードをとる
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		//入力したの認証コードを獲得
		String checkCode = request.getParameter("checkCode");

		//システムから生成したの認証コードをSessionから獲得
		HttpSession session = request.getSession();
		String checkCodeGen = (String) session.getAttribute("checkCodeGen");

		//判断する
		if (!checkCodeGen.equalsIgnoreCase(checkCode)) {
			request.setAttribute("register_msg", "認証コード入力エラー");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;

		}
		//新規登録処理
		boolean flag = userService.register(user);
		if (flag) {
			request.setAttribute("register_msg", "登録成功しました。");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
			request.setAttribute("register_msg", "このアカウントが存在しています。");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
