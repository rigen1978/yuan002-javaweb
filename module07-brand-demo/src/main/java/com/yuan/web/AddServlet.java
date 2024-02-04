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
 * @className: AddServlet
 * @package: com.yuan.service
 * @description:
 * @author: liyuan
 * @create: 2024/02/04 2:13
 * @version: 1.0
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
	private BrandService brandService = new BrandService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.文字化け処理
		req.setCharacterEncoding("utf-8");

		// 2.formからとったデータをBrandに格納
		String brandName = req.getParameter("brandName");
		String companyName = req.getParameter("companyName");
		String ordered = req.getParameter("ordered");
		String description = req.getParameter("description");
		String status = req.getParameter("status");

		// 3
		Brand brand = new Brand();
		brand.setBrandName(brandName);
		brand.setCompanyName(companyName);
		brand.setOrdered(Integer.parseInt(ordered));
		brand.setDescription(description);
		brand.setStatus(Integer.parseInt(status));

		// 4.更新処理を行う
		brandService.add(brand);

		// 5.再表示処理
		req.getRequestDispatcher("/selectAllServlet").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
