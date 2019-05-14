package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entry.Classs;
import com.service.ClassService;
import com.utils.JsonUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/classesqueryservlet")
public class ClassQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassService queryService = new ClassService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sname = request.getParameter("sname");
		if (sname != null) {
			sname = new String(sname.getBytes("iso-8859-1"), "utf-8");
		}
		int pageCount = queryService.getCount(sname, 3);
		request.setAttribute("pageCount", pageCount);																																																																																																						
		List<Classs> list = queryService.queryAll(sname, "1", 3);
		String parseJSON=JsonUtils.beanListToJson(list);
		response.getWriter().write(parseJSON);
		//request.setAttribute("ss", sname);
		//request.setAttribute("list", list);
		//request.setAttribute("pageNow", new Integer(1));
		//request.getRequestDispatcher("class.jsp").forward(request, response);
	}
}