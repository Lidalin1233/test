package com.entry;

import java.util.List;

public class Classs {
private Integer id;
private String code;
private String name;
private String classteacher;
private List<Classs>w;
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
public String getClassteacher() {
	return classteacher;
}
public void setClassteacher(String classteacher) {
	this.classteacher = classteacher;
}
public List<Classs> getW() {
	return w;
}
public void setW(List<Classs> w) {
	this.w = w;
}
@Override
public String toString() {
	return "Classs [id=" + id + ", code=" + code + ", name=" + name + ", classteacher=" + classteacher + ", w=" + w
			+ "]";
}

}
