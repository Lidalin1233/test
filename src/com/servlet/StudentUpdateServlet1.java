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
@WebServlet("/updateStudent1")
public class StudentUpdateServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	StudentService u=new StudentService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String code = request.getParameter("code");
			String name = request.getParameter("newname");
			String forclass = request.getParameter("newforclass");
			String tel = request.getParameter("newtel");	
			String addr = request.getParameter("newaddr");	
			Student s=new Student();
			s.setAddr(addr);
			s.setCode(code);
			s.setForclass(forclass);
			s.setName(name);
			s.setTel(tel);
			u.update(s);
			request.getRequestDispatcher("Student.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}