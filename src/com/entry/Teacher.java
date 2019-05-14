package com.entry;

import java.util.List;

public class Teacher {
	private Integer id;
	private String code;
	private String name;
	private String tel;
	private List<Teacher>w;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<Teacher> getW() {
		return w;
	}
	public void setW(List<Teacher> w) {
		this.w = w;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", code=" + code + ", name=" + name + ", tel=" + tel + ", w=" + w + "]";
	}
	
}
