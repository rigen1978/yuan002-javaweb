package com.yuan.web;
/**
 * @className: Servlet
 * @package: com.yuan.web
 * @description:
 * @author: liyuan
 * @create: 2024/02/08 1:05
 * @version: 1.0
 */

import com.alibaba.fastjson.JSON;
import com.yuan.pojo.Brand;
import com.yuan.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
	private BrandService brandService = new BrandService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 调用Service查询
		List<Brand> brands = brandService.selectAll();

		//2. 将集合转换为JSON数据   序列化
		String jsonString = JSON.toJSONString(brands);

		//3. 响应数据
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(jsonString);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
