package com.sky.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.New;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.sky.bean.resouce;
import com.sky.service.upLoadService;
import com.sky.uitl.FileUploadUtils;

public class uploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//创建描述
		String description = "";
		//创建时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		//创建service对象
		upLoadService service = new upLoadService();
		//缓存目录
		File file = new File(this.getServletContext().getRealPath("/temp"));
		// 1.创建 DiskFileItemFactory
		DiskFileItemFactory factory = new DiskFileItemFactory(1024 * 100 * 10, file);
		// 2.创建ServletFileUpload
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 判断是否为上传操作
		boolean flag = upload.isMultipartContent(request);
		if (flag) {
			// 解决上传文件的中文乱码问题
			upload.setHeaderEncoding("utf-8");
			try {
				List<FileItem> items = upload.parseRequest(request);
				for (FileItem item : items) {
					if(item.isFormField()){
						//获得描述
						description = item.getString("utf-8");
					}
					else if (!item.isFormField()) {
						// 获取上传组件名称
						String name = item.getName();
						// 获取真实名称
						String realname = FileUploadUtils.getRealName(name);
						// 获取随机名称
						String uuidname = FileUploadUtils.getUUIDfileName(name);
						// 获取随机目录
						String randomDirectory = FileUploadUtils
								.getRandomDirectory(name);
						// 可能存储的目录不存在，要创建
						String parentPath = this.getServletContext()
								.getRealPath("/upload");
						File rd = new File(parentPath, randomDirectory);
						if (!rd.exists()) {
							rd.mkdirs();
						}
						// 上传
						IOUtils.copy(item.getInputStream(),
								new FileOutputStream(new File(rd, realname)));
						item.delete();
						// 写入数据库
						service.upLoad(uuidname, realname, randomDirectory,
								time, description);
					}
				}
				response.getWriter().write("上传成功");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			response.getWriter().write("不是上传操作");
			return;
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
