package com.servlet;


import java.io.IOException;


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
@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	StudentService cls=new StudentService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String forclass=request.getParameter("studentname");
		Student s=new Student();
		s.setCode(code);
		s.setForclass(forclass);
		s.setTel(tel);
		s.setAddr(addr);
		s.setName(name);
		cls.add(s);
		request.setAttribute("pageNow", new Integer(1));
		request.getRequestDispatcher("studentqueryservlet").forward(request, response);
	}
}