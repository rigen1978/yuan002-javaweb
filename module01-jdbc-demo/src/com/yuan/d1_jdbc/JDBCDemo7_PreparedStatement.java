package com.yuan.d1_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.Test;

/**
 * @className: JDBCDemo7_PreparedStatement
 * @package: com.yuan.d1_jdbc
 * @description:
 * @author: liyuan
 * @create: 2024/01/27 11:55
 * @version: 1.0
 */
/*
Statementクラスの場合
	Statementクラスのオブジェクトを取得する。 Connectionクラスのオブジェクト.createStatement()で取得できます。
	Statementクラスのオブジェクトを用いて、SQL文を実行する。 Statementクラスのオブジェクト.execute()で実行できます。

PreparedStatementクラスの場合
	実行したいSQL文の値を?に置き換えておきます。その際、シングルクオートで囲む必要はありません。
	PreparedStaetmentクラスのオブジェクトを取得する。 Connectionクラスのオブジェクト.preparedStatement()で取得できます。引数でSQL文も渡しておきます。
	PreparedStatementクラスのオブジェクト.setHoge()で、?に値を挿入します。その際、整数型の場合はsetInt()、文字列型の値が入る場合はsetString()して下さい。 引数には、?の位置を指定します。SQL文の左側の?から1番目の?なら、第一引数に1、第二引数には挿入したい値を渡してあげてください。
	PreparedStatementクラスのオブジェクト.executeQuery()または.executeUpdate()で実行できます。 返却されるResultSetの有無で使用するメソッドが変わります。
 */
public class JDBCDemo7_PreparedStatement {
  @Test
  public void testPreparedStatement() throws Exception {
    // String url = "jdbc:mysql:///db1?useSSL=false";

    // useServerPrepStmts
    //     有効（true）にするとサーバーサイドPrepared Statementを使用する
    String url = "jdbc:mysql:///db1?useSSL=false&useServerPrepStmts=true";
    String username = "root";
    String password = "123456";
    Connection conn = DriverManager.getConnection(url, username, password);

    String name = "田中";
    String pwd = "123";
    // String pwd = "' or '1' = '1";

    String sql = "select * from tb_user where username = ? and password = ?";

    // stmt
    PreparedStatement pstmt = conn.prepareStatement(sql);
    // ?の値を設置
    pstmt.setString(1, name);
    pstmt.setString(2, pwd);

    // sql
    ResultSet rs = pstmt.executeQuery();

    // 登録判断
    if (rs.next()) {
      System.out.println("登录成功~");
    } else {
      System.out.println("登录失败~");
    }

    // 7. 後処理（リソースのクローズ）
    rs.close();
    pstmt.close();
    conn.close();
  }

  /*
  useSSL
    MySQL の SSL 接続の有効化

  prepStmtCacheSize
    Prepared Statementのキャッシュ数。デフォルトは25
    cachePrepStmtsをtrueにする必要あり

  prepStmtCacheSqlLimit
    キャッシュするPrepared Statementの（SQL文の）長さ
    cachePrepStmtsをtrueにする必要あり
    デフォルトは256

  cachePrepStmts
    有効（true）にするとクライアントサイドまたはサーバーサイドのPrepared Statementの適合性をチェックする（キャッシュの有効化）
    デフォルトは無効（false）

  useServerPrepStmts
    有効（true）にするとサーバーサイドPrepared Statementを使用する
    デフォルトは無効（false）

  rewriteBatchedStatements
    有効（true）にすると、executeBatchの呼び出しを伴うinsertおよびreplaceをバルクinsertまたはバルクreplaceに書き換える
    デフォルトは無効（false）

  useLocalSessionState
    有効（true）にするとオートコミットやトランザクションの分離レベルをローカルの情報を元に判断し、MySQLサーバーへの問い合わせを減らす
    デフォルトは無効（false）

  cacheResultSetMetadata
    有効（true）にすると、ResultSetMetaDataをキャッシュする
    デフォルトは無効（false）

  cacheServerConfiguration
    有効（true）にすると、 show variablesとshow collationの結果をキャッシュする
    デフォルトは無効（false）

  elideSetAutoCommits
    有効（true）にすると、Connection#setAutoCommit実行時にサーバーとドライバーの状態が異なる時のみset autocommit=nクエリーを発行する
    デフォルトは無効（false）

  maintainTimeStats
    無効（false）にすると、MySQLサーバーへの接続が失敗した時に詳細なエラーメッセージを出力するために維持するアイドル時間等の内部タイマーを無効にする
    デフォルトは有効（true）
     */

}
