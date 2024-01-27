package com.yuan.d1_jdbc;

import com.yuan.pojo.Account;
import java.sql.*;
import java.util.ArrayList;
import org.junit.Test;

/**
 * @className: JDBCDemo4_Statement DQL
 * @package: com.yuan.d1_jdbc
 * @description:
 * @author: liyuan
 * @create: 2024/01/26 12:44
 * @version: 1.0
 */
public class JDBCDemo5_ResultSet {
  @Test
  public void testResultSet() throws Exception {
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
    String sql = "select * from account";
    // 4.ｓｑｌ実行するStatement()を獲得
    Statement stmt = conn.createStatement();
    // 5.ｓｑｌ実行
    ResultSet rs = stmt.executeQuery(sql);
    // 6.検索結果を表示
    while (rs.next()) {
      int id = rs.getInt(1);
      String name = rs.getString(2);
      double money = rs.getDouble(3);

      System.out.println(id);
      System.out.println(name);
      System.out.println(money);
      System.out.println("--------------------------------");
    }
    // 7.後処理（リソースのクローズ）
    rs.close();
    stmt.close();
    conn.close();
  }

  /*
   accountテーブルのデータを検索し、その結果をaccount(javabean)に格納し、その結果をArrayListに追加する
   １：javabean Accountを定義する
   ２：そうの結果をAccountにカプセル化にする
   ３：最後にArrayListに追加
  */
  @Test
  public void testResultSet2() throws Exception {
    ArrayList<Account> accountList = new ArrayList<>();

    String url = "jdbc:mysql:///db1?useSSL=false";
    String username = "root";
    String password = "123456";
    Connection conn = DriverManager.getConnection(url, username, password);

    Statement stmt = conn.createStatement();

    String sql = "select * from account";

    ResultSet rs = stmt.executeQuery(sql);

    while (rs.next()) {
      Account account = new Account();
      int id = rs.getInt("id");
      String name = rs.getString("name");
      double money = rs.getDouble("money");

      account.setId(id);
      account.setName(name);
      account.setMoney(money);

      accountList.add(account);
    }

    System.out.println(accountList);

    // 7.後処理（リソースのクローズ）
    rs.close();
    stmt.close();
    conn.close();
  }
}
