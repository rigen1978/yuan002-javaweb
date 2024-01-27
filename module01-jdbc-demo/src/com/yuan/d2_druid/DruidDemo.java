package com.yuan.d2_druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;
import javax.sql.DataSource;

/**
 * @className: DruidDemo
 * @package: com.yuan.d2_druid
 * @description:
 * @author: liyuan
 * @create: 2024/01/28 0:54
 * @version: 1.0
 */

/*
データベース接続プール:
	接続が要求されるたびに作成するオーバーヘッドを軽減するために、アプリケーションは通常、接続プールを使用して接続をキャッシュし、再利用します。
	JDBC 情報元は接続プール API を定義します。必要に応じて、さまざまなオープンソース接続プール実装から選択できます。
*/
public class DruidDemo {
  public static void main(String[] args) throws Exception {
    // 1.jarファイルを導入する
    // 2.propertiesファイルを定義する

    // 3. propertiesファイルを読み込む
    Properties prop = new Properties();
    prop.load(new FileInputStream("module01-jdbc-demo/src/druid.properties"));
    // 4. Druid接続プールを取得
    DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

    // 5. データベースを接続 Connection
    Connection connection = dataSource.getConnection();

    System.out.println(connection);

    // System.out.println(System.getProperty("user.dir"));
  }
}
