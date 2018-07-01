package com.sky.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sky.bean.resouce;
import com.sky.service.dowloadService;

public class showServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dowloadService service = new dowloadService();
		
		try {
			List<resouce> rList = service.show();
			request.setAttribute("rList", rList);
			request.getRequestDispatcher("/dowload.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
