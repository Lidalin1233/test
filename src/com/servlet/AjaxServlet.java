package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxs")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name=req.getParameter("name");
		String code=req.getParameter("code");
		String nas ="����";
		 //��װjson��ʽ���������ڷ��ص�ҳ��
		resp.setCharacterEncoding("utf-8");
		String parseJSON = "{\"name\":\"����\"}";
          //д��ҳ��
		resp.getWriter().write(parseJSON);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}