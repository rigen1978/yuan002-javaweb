package com.yuan.mapper;

import com.yuan.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @className: UserMapper
 * @package: com.yuan.mapper
 * @description:
 * @author: liyuan
 * @create: 2024/02/03 0:31
 * @version: 1.0
 */
public interface UserMapper {
	/**
	 * ユーザー名とパスワードでログインデータを検索
	 * @param username
	 * @param password
	 * @return
	 */
	@Select("select * from tb_user where username = #{username} and password = #{password}")
	User select(@Param("username") String username, @Param("password") String password);

	/**
	 * ユーザー名が存在するかどうかをチェックする
	 * @param username
	 * @return
	 */
	@Select("select * from tb_user where username = #{username}")
	User selectByUsername(String username);

	/**
	 * 新規登録
	 * @param user
	 */
	@Insert("insert into tb_user values (null,#{username},#{password})")
	void add(User user);
}
