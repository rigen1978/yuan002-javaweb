package com.yuan.web;
/**
 * @className: ServletDemo1
 * @package: com.yuan.web
 * @description:
 * @author: liyuan
 * @create: 2024/02/03 11:44
 * @version: 1.0
 */

import com.yuan.pojo.Brand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/demo1")
public class ServletDemo1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Brand> brands = new ArrayList<Brand>();
		brands.add(new Brand(1, "本田", "本田自動車", 100, "乗りやすい", 1));
		brands.add(new Brand(2, "日産", "日産自動車", 200, "安い", 0));
		brands.add(new Brand(3, "トヨタ", "トヨタ自動車", 1000, "安い,乗りやすい", 1));

		//requestに格納
		request.setAttribute("brands", brands);
		request.setAttribute("status", 1);

		//el-demo.jspに渡す
		//request.getRequestDispatcher("/el-demo.jsp").forward(request, response);
		// request.getRequestDispatcher("/jstl-if.jsp").forward(request,response);
		request.getRequestDispatcher("/jstl-foreach.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
