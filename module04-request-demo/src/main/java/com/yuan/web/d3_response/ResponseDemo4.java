package com.yuan.web.d3_response;
/**
 * @className: ResponseDemo1
 * @package: com.yuan.web.d3_response
 * @description:
 * @author: liyuan
 * @create: 2024/02/03 0:17
 * @version: 1.0
 */

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/resp4")
public class ResponseDemo4 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 读取文件
		FileInputStream fis = new FileInputStream("d://a.jpg");

		//2. 获取response字节输出流
		ServletOutputStream os = response.getOutputStream();

		//3. 完成流的copy
       /* byte[] buff = new byte[1024];
        int len = 0;
        while ((len = fis.read(buff))!= -1){
            os.write(buff,0,len);
        }*/

		IOUtils.copy(fis, os);

		fis.close();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
