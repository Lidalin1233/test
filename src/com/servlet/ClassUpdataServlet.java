package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ClassService;

@WebServlet("/updateClass1")
public class ClassUpdataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClassService updateService = new ClassService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String code = request.getParameter("code");
			String newname = request.getParameter("newname");
			String newclassteacher = request.getParameter("newclassteacher");
			updateService.update(code, newname, newclassteacher);
			request.getRequestDispatcher("classesqueryservlet").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
