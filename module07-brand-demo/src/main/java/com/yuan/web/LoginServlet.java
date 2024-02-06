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
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ユーザ名とパスワードをとる
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// rememberチェックボックスの値をとる
		String remember = request.getParameter("remember");

		// ユーザーの検索
		User loginUser = userService.login(username, password);

		// 結果を判断する
		if (loginUser != null) {
			//ログイン成功

			//remember機能
			if ("1".equals(remember)) {
				// cookieに格納
				Cookie c_username = new Cookie("username", username);
				Cookie c_password = new Cookie("password", password);

				//Cookieの持つ時間を設定する
				c_username.setMaxAge(60 * 60 * 24 * 7);
				c_password.setMaxAge(60 * 60 * 24 * 7);

			}


			HttpSession session = request.getSession();
			session.setAttribute("user", loginUser);

			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/selectAllServlet");
		} else {
			// ログイン失敗
			request.setAttribute("login_msg", "ユーザー名とパスワードが違います。");
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
