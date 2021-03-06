package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entry.Student;
import com.service.StudentService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/studentqueryservlet")
public class StudentQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentService queryService = new StudentService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sname = request.getParameter("sname");
		if (sname != null) {
			sname = new String(sname.getBytes("iso-8859-1"), "utf-8");
		}
		int pageCount = queryService.getCount(sname, 3);
		request.setAttribute("pageCount", pageCount);
		List<Student> list = queryService.queryAll(sname, "1", 3);
		request.setAttribute("ss", sname);
		request.setAttribute("list", list);
		request.setAttribute("pageNow", new Integer(1));
		request.getRequestDispatcher("Student.jsp").forward(request, response);
	}
}