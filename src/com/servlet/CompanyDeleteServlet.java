package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.CompanyService;

@WebServlet("/companydel")
public class CompanyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CompanyService dateService = new CompanyService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = null == request.getParameter("id") ? "" : request.getParameter("id");
		try {
			dateService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().write("{'msg':'true'}");
	}
}