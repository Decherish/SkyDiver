package com.sky.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dowloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		// 1.得到要下载 的文件名称
		String filename = request.getParameter("filename");
		String savepath = request.getParameter("savepath").replace("/", "\\")
				+ "\\";
		// 2.在d:/upload目录下查找这个文件是否存在
		File file = new File(this.getServletContext().getRealPath("/upload")
				+ savepath + filename);
		if (file.exists()) {
			// 文件存在，进行下载
			// 下载注意事项1--设置下载文件的mimeType
			String mimeType = this.getServletContext().getMimeType(filename);
			response.setContentType(mimeType);
			String agent = request.getHeader("user-agent");
			if (agent.contains("MSIE")) {
				// IE浏览器
				filename = URLEncoder.encode(filename, "utf-8");

			} else {
				// 其它浏览器
				filename = URLEncoder.encode(filename, "utf-8");
			}
			// 下载注意事项2--永远是下载
			response.setHeader("content-disposition", "attachment;filename="
					+ filename);
			// 读取要下载文件的内容
			FileInputStream fis = new FileInputStream(file);
			// 将要下载的文件内容通过输出流写回到浏览器端.
			OutputStream os = response.getOutputStream();
			int len=-1;
			byte[] b =new byte[1024 * 100];
			while((len=fis.read(b))!= -1){
				os.write(b);
				os.flush();
			}
			os.close();
			fis.close();
		}else {
			throw new RuntimeException("文件不存在");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
