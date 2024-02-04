package com.yuan.web;

import com.yuan.pojo.Brand;
import com.yuan.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * @className: SelectAllServlet
 * @package: com.yuan.web
 * @description:
 * @author: liyuan
 * @create: 2024/02/04 1:07
 * @version: 1.0
 */
@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
	private BrandService brandService = new BrandService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//検索を行う、結果をもどす
		List<Brand> brands = brandService.selectAll();
		//request領域に格納する
		req.setAttribute("brands", brands);
		//brand.jspページに飛ぶ
		req.getRequestDispatcher("/brand.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
