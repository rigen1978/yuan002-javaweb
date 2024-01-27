package com.yuan.d1_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Test;

/**
 * @className: JDBCDemo6_UserLogin
 * @package: com.yuan.d1_jdbc
 * @description:
 * @author: liyuan
 * @create: 2024/01/27 11:36
 * @version: 1.0
 */
public class JDBCDemo6_UserLogin {
  @Test
  public void testLogin_Inject() throws Exception {
    // SQLインジェクション
    // SQLインジェクション攻撃とは、WebサイトやWebアプリケーションの脆弱性（=弱点）につけこみ「SQL（データベースを操作するための言語）」を用いて、
    // 不正なSQL文を「データベース」り、個人情報の窃取やデータ改ざんなどを行うサイバー攻撃手法です。
    String url = "jdbc:mysql:///db1?useSSL=false";
    String username = "root";
    String password = "123456";
    Connection conn = DriverManager.getConnection(url, username, password);

    String name = "hfkjsfhskj";
    String pwd = "' or '1' = '1";

    String sql =
        "select * from tb_user where username = '" + name + "' and password = '" + pwd + "'";
    System.out.println(sql);
    // stmt
    Statement stmt = conn.createStatement();
    // sql
    ResultSet rs = stmt.executeQuery(sql);

    // 登録判断
    if (rs.next()) {
      System.out.println("登录成功~");
    } else {
      System.out.println("登录失败~");
    }

    // 7. 後処理（リソースのクローズ）
    rs.close();
    stmt.close();
    conn.close();
  }
}
