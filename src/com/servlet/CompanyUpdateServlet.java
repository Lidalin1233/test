package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entry.Company;
import com.service.CompanyService;
import com.utils.JsonUtils;

@WebServlet("/companyupd")
public class CompanyUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	CompanyService companyService = new CompanyService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id= request.getParameter("id");
		try {
			Company comp = companyService.query(id);
			String jsonstr = JsonUtils.beanToJson(comp);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(jsonstr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
