package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entry.Emp;
import com.service.EmpService;

@WebServlet("/empUpdate1")
public class EmpUpdataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpService updateService = new EmpService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			String number = request.getParameter("newnumber");
			String name = request.getParameter("newname");
			String tel = request.getParameter("newtel");
			String addr = request.getParameter("newaddr");
			String zw = request.getParameter("newzw");
			Emp t=new Emp();
			t.setAddr(addr);
			t.setName(name);
			t.setNumber(number);
			t.setTel(tel);
			t.setZw(zw);
			updateService.update(t);
			request.getRequestDispatcher("empqueryservlet").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
