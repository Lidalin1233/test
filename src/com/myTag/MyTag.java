package com.myTag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag extends SimpleTagSupport {

	/**
	 * 自定义标签内容
	 */
	StringWriter sw = new StringWriter();
	/**
	 * 自定义标签属性
	 */
	private String msg;
	private Integer count;

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("我的自定义jsp标签!"); //直接把文字输出到页面

		/*		
		getJspBody().invoke(sw);
		out.println(sw.toString());

		if (null != msg) {
			 
			out.println(msg);
		}*/

		if (count == 1 && "s".equals(msg)) {
			//sw.write("say hello");
			//getJspBody().invoke(sw);
			for (int i = 0; i < 10; i++) {
				out.println("<br />say hello  "+ i);
			}
		}
	}
	
}
