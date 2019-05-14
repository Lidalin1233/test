package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entry.Company;
import com.service.CompanyService;

@WebServlet("/companyupdSave")
public class CompanyUpdateSaveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	CompanyService companyService = new CompanyService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id =request.getParameter("id");
		String name = null == request.getParameter("name") ? "" : request.getParameter("name");
		String tel = null == request.getParameter("tel") ? "" : request.getParameter("tel");
		name = new String(name.getBytes("iso-8859-1"),"utf-8");
		tel = new String(tel.getBytes("iso-8859-1"),"utf-8");
		Company company = new Company();
		company.setId(Integer.parseInt(id));
		company.setName(name);
		company.setTel(tel);
		try {
			companyService.update(company);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("CompanyList.jsp");
	}
}
