package com.yuan.d1_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @className: JDBCDemo3_Connection
 * @package: com.yuan.d1_jdbc
 * @description:
 * @author: liyuan
 * @create: 2024/01/26 10:40
 * @version: 1.0
 */
public class JDBCDemo3_Connection {
  /*
   JavaでMySQLのデータベースにトランザクション処理
       1:トランザクション処理を行うと、複数のSQL文の内の１つ以上でエラーが発生した場合に、その全ての処理を無かった事にしてくれます。
  */
  public static void main(String[] args) throws Exception {
    // 1.JDBCドライバをドライバマネージャに登録する
    // これは省略できる
    Class.forName("com.mysql.jdbc.Driver");

    // 2.データベースをあらわす URL、接続に用いるユーザ名、ユーザのパスワードを指定している。
    // データベースに接続します
    String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
    String username = "root";
    String password = "123456";
    Connection conn = DriverManager.getConnection(url, username, password);
    // 3.sqlを定義する
    String sql1 = "update account set money = 3000 where id = 1";
    String sql2 = "update account set money = 3000 where id = 2";
    // 4.ｓｑｌ実行するStatement()を獲得
    Statement stmt = conn.createStatement();
    // 5.ｓｑｌ実行
    // 6.検索結果を表示
    try {

      // トランザクション処理には複数のSQL文をまとめてコミットを行う必要が有るので、自動コミット機能をオフにします。
      conn.setAutoCommit(false);

      int count1 = stmt.executeUpdate(sql1);
      System.out.println("count1: " + count1);
      // エラーがある場合
      int i = 3 / 0;
      int count2 = stmt.executeUpdate(sql2);
      System.out.println("count2: " + count2);

      // エラーがない場合、コミット
      conn.commit();
    } catch (Exception e) {
      // データベースの登録でエラーが発生したらロールバック処理ですべての変更を取り消します。
      conn.rollback();
      e.printStackTrace();
    }

    // 7.後処理（リソースのクローズ）
    stmt.close();
    conn.close();
  }
}
