package com.yuan.d3_example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.yuan.pojo.Brand;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.sql.DataSource;
import org.junit.Test;
// 1.
// 2.
// 3.
// 4.
// 5.
// 6.
// 7.
// 8.

/**
 * @className: BrandTest crud練習
 * @package: com.yuan.d3_example
 * @description:
 * @author: liyuan
 * @create: 2024/01/28 1:25
 * @version: 1.0
 */
public class BrandTest {

  /**
   * すべてのデータを取得
   */
  @Test
  public void testSelectAll() throws Exception {
    // 1.propertiesファイルを読み込む
    Properties prop = new Properties();
    //prop.load(new FileInputStream(
    //    "C:\\rigen\\workspace\\github\\yuan002-javaweb\\module01-jdbc-demo\\src\\druid.properties"));
    prop.load(new FileInputStream(
        "src\\druid.properties"));

    // 2.Druid接続プールを接続
    DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
    // 3.データベースを接続 Connection
    Connection conn = dataSource.getConnection();
    // 4.SQLを定義
    String sql = "select * from tb_brand";
    // 5.pstmsを獲得
    PreparedStatement pstmt = conn.prepareStatement(sql);
    // 6.引数を設置

    // 7.SQLを実行
    ResultSet rs = pstmt.executeQuery();
    // 8.結果をList<Brand>に格納する
    Brand brand = null;
    List<Brand> brandList = new ArrayList<>();
    while (rs.next()) {
      int id = rs.getInt("id");
      String brandName = rs.getString("brand_name");
      String companyName = rs.getString("company_name");
      int ordered = rs.getInt("ordered");
      String description = rs.getString("description");
      int status = rs.getInt("status");

      //Brandにセットする
      brand = new Brand();
      brand.setId(id);
      brand.setBrandName(brandName);
      brand.setCompanyName(companyName);
      brand.setOrdered(ordered);
      brand.setDescription(description);
      brand.setStatus(status);

      //ArrayListに格納する
      brandList.add(brand);

    }
    System.out.println(brandList);
    // 9.後処理（リソースのクローズ）
    rs.close();
    pstmt.close();
    conn.close();
  }
}
