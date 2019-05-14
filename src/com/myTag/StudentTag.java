package com.myTag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.entry.Classs;
import com.service.ClassService;

public class StudentTag extends SimpleTagSupport {
	private String name;
	private String id;
	private String onchangeFun;

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setOnchangeFun(String onchangeFun) {
		this.onchangeFun = onchangeFun;
	}

	public void doTag() throws IOException {
		JspWriter out = getJspContext().getOut();
		ClassService clas = new ClassService();
		List<Classs> list = clas.qq();
		String str = "<select name ='" + name + "'id='" + id + "'onchange='" + onchangeFun + "'>";
		for (Classs classs : list) {
			str = str + "<option value='" + classs.getName() + "'>" + classs.getName() + "</option>";
		}
		str+="</select>";
		out.println(str);
	}
}
