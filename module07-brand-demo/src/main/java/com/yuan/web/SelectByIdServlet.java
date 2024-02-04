package com.yuan.web;

import com.yuan.pojo.Brand;
import com.yuan.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @className: SelectAllServlet
 * @package: com.yuan.web
 * @description:
 * @author: liyuan
 * @create: 2024/02/04 1:07
 * @version: 1.0
 */
@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
	private BrandService brandService = new BrandService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//id
		String id = req.getParameter("id");

		Brand brand = brandService.selectById(Integer.parseInt(id));

		//request領域に格納する
		req.setAttribute("brand", brand);
		//brand.jspページに飛ぶ
		req.getRequestDispatcher("/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
