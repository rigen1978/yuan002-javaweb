package com.yuan.web;
/**
 * @className: RegisterServlet
 * @package: com.yuan.web
 * @description:
 * @author: liyuan
 * @create: 2024/02/03 1:17
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

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.ユーザ名とパスワードを取得
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//2. Userに格納
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

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

		User updateUser = userMapper.selectByUsername(username);

		if (updateUser == null) {
			//DBにない場合、新規登録をする
			userMapper.add(user);
			//commit処理
			sqlSession.commit();
			//後処理（sqlSessionのクローズ）
			sqlSession.close();
		} else {
			//ユーザーが存在する場合
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("ユーザーが存在しています、別のユーザー名で登録してください。");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
