package com.yuan.d1_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.junit.Test;

/**
 * @className: JDBCDemo4_Statement DML
 * @package: com.yuan.d1_jdbc
 * @description:
 * @author: liyuan
 * @create: 2024/01/26 12:44
 * @version: 1.0
 */
public class JDBCDemo4_Statement {
  @Test
  public void testDML() throws Exception {
    // 1.JDBCドライバをドライバマネージャに登録する
    // これは省略できる
    // Class.forName("com.mysql.jdbc.Driver");

    // 2.データベースをあらわす URL、接続に用いるユーザ名、ユーザのパスワードを指定している。
    // データベースに接続します
    // url localの場合、ポートは3306の時、もっと簡単の書き方がある
    // String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
    String url = "jdbc:mysql:///db1?useSSL=false";
    String username = "root";
    String password = "123456";

    Connection conn = DriverManager.getConnection(url, username, password);
    // 3.sqlを定義する
    String sql = "update account set money = 3000 where id = 1";
    // 4.ｓｑｌ実行するStatement()を獲得
    Statement stmt = conn.createStatement();
    // 5.ｓｑｌ実行
    int count = stmt.executeUpdate(sql);

    // 6.検索結果を表示
    if (count > 0) {
      System.out.println("更新は成功しました。~");
    } else {

      System.out.println("更新は失敗しました。");
    }
    // 7.後処理（リソースのクローズ）
    stmt.close();
    conn.close();
  }
}
