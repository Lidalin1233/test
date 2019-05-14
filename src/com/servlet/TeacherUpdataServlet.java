package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entry.Teacher;
import com.service.TeacherService;

@WebServlet("/teacherUpdate1")
public class TeacherUpdataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TeacherService updateService = new TeacherService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String code = request.getParameter("code");
			String newname = request.getParameter("newname");
			String newtel = request.getParameter("newtel");
			Teacher t=new Teacher();
			t.setCode(code);
			t.setName(newname);
			t.setTel(newtel);
			updateService.update(t);
			request.getRequestDispatcher("teacherqueryservlet").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
