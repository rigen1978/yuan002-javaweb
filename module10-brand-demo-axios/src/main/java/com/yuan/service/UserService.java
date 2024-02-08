package com.yuan.service;

import com.yuan.mapper.UserMapper;
import com.yuan.pojo.User;
import com.yuan.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @className: UserService
 * @package: com.yuan.service
 * @description:
 * @author: liyuan
 * @create: 2024/02/04 19:15
 * @version: 1.0
 */
public class UserService {
	//SqlSessionFactoryを取得
	SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

	/**
	 * ログイン処理
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password) {
		//sqlを実行する為に、sqlSessionを取得
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//sqlを実行,selectListメソッド
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.select(username, password);

		// 後処理（sqlSessionのクローズ）
		sqlSession.close();

		//データをリターンする
		return user;
	}


	/**
	 * 新規登録
	 * @param user
	 * @return
	 */
	public boolean register(User user) {
		//sqlを実行する為に、sqlSessionを取得
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//sqlを実行,selectListメソッド
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User registerUser = userMapper.selectByUsername(user.getUsername());
		if (registerUser == null) {
			//ユーザーが存在していません、登録できます
			userMapper.add(user);
			sqlSession.commit();
		}
		sqlSession.close();
		return registerUser == null;
	}
}
