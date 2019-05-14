package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.EmpService;

@WebServlet("/empdelectServlet")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpService dateService = new EmpService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String number = request.getParameter("number");//获取页面参数
			dateService.delete(number);
			request.setAttribute("pageNow", 1);
			request.getRequestDispatcher("empqueryservlet").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}