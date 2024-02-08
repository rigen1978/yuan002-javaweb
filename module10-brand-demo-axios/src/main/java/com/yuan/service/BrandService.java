package com.yuan.service;

import com.yuan.mapper.BrandMapper;
import com.yuan.pojo.Brand;
import com.yuan.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @className: BrandService
 * @package: com.yuan.service
 * @description:
 * @author: liyuan
 * @create: 2024/02/04 1:03
 * @version: 1.0
 */
public class BrandService {
	//SqlSessionFactoryを取得
	SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

	/**
	 * すべてのデータを取得
	 * @return
	 */
	public List<Brand> selectAll() {
		//sqlを実行する為に、sqlSessionを取得
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//sqlを実行,selectListメソッド
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
		List<Brand> brands = brandMapper.selectAll();

		// 後処理（sqlSessionのクローズ）
		sqlSession.close();

		//データをリターンする
		return brands;

	}

	/**
	 * 登録
	 * @param brand
	 */
	public void add(Brand brand) {
		//sqlを実行する為に、sqlSessionを取得
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//sqlを実行,selectListメソッド
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
		brandMapper.add(brand);

		//commit処理
		sqlSession.commit();

		// 後処理（sqlSessionのクローズ）
		sqlSession.close();
	}

	/**
	 * すべてのデータを取得
	 * @return
	 */
	public Brand selectById(int id) {
		//sqlを実行する為に、sqlSessionを取得
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//sqlを実行,selectListメソッド
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
		Brand brand = brandMapper.selectById(id);

		// 後処理（sqlSessionのクローズ）
		sqlSession.close();

		//データをリターンする
		return brand;

	}

	/**
	 * 更新
	 * @param brand
	 */
	public void update(Brand brand) {
		//sqlを実行する為に、sqlSessionを取得
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//sqlを実行,selectListメソッド
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
		brandMapper.update(brand);

		//commit処理
		sqlSession.commit();

		// 後処理（sqlSessionのクローズ）
		sqlSession.close();
	}

}
