package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ClassService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/AddServlet")
public class ClassAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	ClassService cls = new ClassService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String classteacher = request.getParameter("classteacher");
		cls.add(code, name, classteacher);
		request.setAttribute("pageNow", new Integer(1));
		request.getRequestDispatcher("classesqueryservlet").forward(request, response);
	}
}