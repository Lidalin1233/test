package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entry.Company;
import com.entry.Page;
import com.service.CompanyService;
import com.utils.JsonUtils;

@WebServlet("/companyList")
public class CompanyListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	CompanyService companyService = new CompanyService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Page page = new Page();
		String name = null == request.getParameter("name") ? "" : request.getParameter("name");
		// name = new String(name.getBytes("iso-8859-1"),"utf-8");
		String tel = null == request.getParameter("tel") ? "" : request.getParameter("tel");
		Company comp = new Company();
		comp.setName(name);
		comp.setTel(tel);

		String pageNow = request.getParameter("pageNow");
		String pageSize = request.getParameter("pageSize");
		if (null != pageNow && "".equals(pageNow.trim())) {
			pageNow = "1";
		}
		if (null != pageSize ) {
		pageSize = page.getPageSize() + "";

		int pageCount = companyService.getCount(comp, Integer.parseInt(pageSize));// 得到总页数
		List<Company> list;
		try {
			list = companyService.queryAll(comp, Integer.parseInt(pageNow), Integer.parseInt(pageSize));
			response.setCharacterEncoding("utf-8");
			// request.setAttribute("list", list);
			page.setList(list);
			page.setPageCount(pageCount);
			page.setPageNow(Integer.parseInt(pageNow));
			String parse = JsonUtils.beanToJson(page);
			response.getWriter().write(parse);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// request.setAttribute("comp",comp);
		// request.getRequestDispatcher("CompanyList.jsp").forward(request, response);

	}
}
}
