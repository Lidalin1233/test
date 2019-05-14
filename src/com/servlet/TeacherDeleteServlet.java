package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.TeacherService;

@WebServlet("/teacherdelete")
public class TeacherDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TeacherService dateService = new TeacherService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String code = request.getParameter("code");//获取页面参数
			dateService.delete(code);
			request.setAttribute("pageNow", 1);
			request.getRequestDispatcher("teacherqueryservlet").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}