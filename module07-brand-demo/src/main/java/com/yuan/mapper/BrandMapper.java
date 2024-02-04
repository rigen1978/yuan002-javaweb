package com.yuan.mapper;

import com.yuan.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @className: BrandMapper
 * @package: com.yuan.mapper
 * @description:
 * @author: liyuan
 * @create: 2024/02/04 0:43
 * @version: 1.0
 */
public interface BrandMapper {
	/**
	 * すべてのデータを取得
	 * @return
	 */
	@Select("select * from tb_brand")
	@ResultMap("brandResultMap")
	List<Brand> selectAll();

	/**
	 * 新規登録
	 * @param brand
	 */
	@Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
	void add(Brand brand);

	/**
	 * idにより検索
	 * @param id
	 * @return
	 */
	@Select("select * from tb_brand where id = #{id}")
	@ResultMap("brandResultMap")
	Brand selectById(int id);


	/**
	 * 更新処理
	 * @param brand
	 */
	@Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} where id = #{id}")
	void update(Brand brand);


}
