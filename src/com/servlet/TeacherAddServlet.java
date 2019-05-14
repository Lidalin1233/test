package com.servlet;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entry.Teacher;
import com.service.TeacherService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/TeacherAddServlet")
public class TeacherAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	TeacherService teachers=new TeacherService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		Teacher s=new Teacher();
		s.setCode(code);
		s.setTel(tel);
		s.setName(name);
		teachers.add(s);
		request.setAttribute("pageNow", new Integer(1));
		request.getRequestDispatcher("teacherqueryservlet").forward(request, response);
	}
}