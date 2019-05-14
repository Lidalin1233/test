package com.entry;

import java.util.List;

public class Student {
	private Integer id;
	private String code;
	private String name;
	private String forclass;
	private String addr;
	private String tel;
	private List<Student>w;
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
	public String getForclass() {
		return forclass;
	}
	public void setForclass(String forclass) {
		this.forclass = forclass;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<Student> getW() {
		return w;
	}
	public void setW(List<Student> w) {
		this.w = w;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", code=" + code + ", name=" + name + ", forclass=" + forclass + ", addr=" + addr
				+ ", tel=" + tel + ", w=" + w + "]";
	}
	
}
