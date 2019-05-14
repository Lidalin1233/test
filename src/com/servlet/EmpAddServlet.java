package com.servlet;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entry.Emp;
import com.service.EmpService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/EmpAddServlet")
public class EmpAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	EmpService emps=new EmpService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String number = request.getParameter("number");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String zw = request.getParameter("zw");
		Emp e=new Emp();
		e.setAddr(addr);
		e.setName(name);
		e.setNumber(number);
		e.setTel(tel);
		e.setZw(zw);
		emps.add(e);
		request.setAttribute("pageNow", new Integer(1));
		request.getRequestDispatcher("empqueryservlet").forward(request, response);
	}
}