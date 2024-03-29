package com.yuan.web.d3_response;
/**
 * @className: ResponseDemo1
 * @package: com.yuan.web.d3_response
 * @description:
 * @author: liyuan
 * @create: 2024/02/03 0:17
 * @version: 1.0
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("resp1....");

		//重定向
        /*//1.设置响应状态码 302
        response.setStatus(302);
        //2. 设置响应头 Location
        response.setHeader("Location","/request-demo/resp2");*/

		//简化方式完成重定向
		//动态获取虚拟目录
		String contextPath = request.getContextPath();

		response.sendRedirect(contextPath + "/resp2");
		//response.sendRedirect("https://www.itcast.cn");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
