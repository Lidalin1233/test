package com.servlet;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/TeacherPageServlet")
public class TeacherPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	TeacherService teachers = new TeacherService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pageNowStr = request.getParameter("pageNow");
		String sname=request.getParameter("sname");
		int pageCount = teachers.getCount(sname,3); 
		request.setAttribute("pageCount", pageCount);
		List<Teacher>list=teachers.queryAll(sname,pageNowStr,3); 
		request.setAttribute("list", list);
		int p = Integer.parseInt(pageNowStr);
		if (p <= pageCount) {

			request.setAttribute("pageNow", new Integer(pageNowStr)); // 默认当前页是第1页
		} else {
			request.setAttribute("pageNow", pageCount);
		}
		if (p <= 0) {
			request.setAttribute("pageNow", 1);
		}
		request.getRequestDispatcher("Teacher.jsp").forward(request, response);
	}
}