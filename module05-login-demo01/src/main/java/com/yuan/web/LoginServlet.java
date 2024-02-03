package com.yuan.web;
/**
 * @className: LoginServlet
 * @package: com.yuan.web
 * @description:
 * @author: liyuan
 * @create: 2024/02/03 0:39
 * @version: 1.0
 */

import com.yuan.mapper.UserMapper;
import com.yuan.pojo.User;
import com.yuan.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.ユーザ名とパスワードを取得
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//2.mybatisでデータの検索する
		//2.1 SqlSessionFactoryを取得
		//String resource = "mybatis-config.xml";
		//InputStream inputStream = Resources.getResourceAsStream(resource);
		//SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

		//2.2 sqlを実行する為に、sqlSessionを取得
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//2.3 Mapperを取得
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		//2.4 実行
		User user = userMapper.select(username, password);

		//2.5 後処理（sqlSessionのクローズ）
		sqlSession.close();

		// content typeを設置,文字化けを防ぐため
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();

		// ユーザが存在するかどうかを判断
		if (user != null) {
			printWriter.write("登録が成功しました。");
		} else {
			printWriter.write("このユーザーが存在していませんでした。");
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
