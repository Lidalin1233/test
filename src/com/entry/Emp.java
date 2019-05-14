package com.entry;

import java.util.List;

public class Emp {
	private Integer id;
	private String number;
	private String name;
	private String addr;
	private String tel;
	private String zw;
	private List<Emp>w;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getZw() {
		return zw;
	}
	public void setZw(String zw) {
		this.zw = zw;
	}
	public List<Emp> getW() {
		return w;
	}
	public void setW(List<Emp> w) {
		this.w = w;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", number=" + number + ", name=" + name + ", addr=" + addr + ", tel=" + tel + ", zw="
				+ zw + ", w=" + w + "]";
	}
	
}
