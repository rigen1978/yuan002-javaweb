package com.yuan.web;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * @className: ServletDemo1
 * @package: com.yuan.web
 * @description:
 * @author: liyuan
 * @create: 2024/02/01 12:19
 * @version: 1.0
 */
@WebServlet("/demo5")
public class ServletDemo5 extends MyHttpServlet {

	@Override
	protected void doGet(ServletRequest req, ServletResponse res) {
		System.out.println("get。。。。");
	}

	@Override
	protected void doPost(ServletRequest req, ServletResponse res) {
		System.out.println("post。。。。");
	}
}

