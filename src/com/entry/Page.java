package com.entry;

import java.util.ArrayList;
import java.util.List;

public class Page {
private Integer pageSize=3;
private Integer pageNow;
private Integer pageCount;
public List<?>list=new ArrayList<>();
public Integer getPageSize() {
	return pageSize;
}
public void setPageSize(Integer pageSize) {
	this.pageSize = pageSize;
}
public Integer getPageNow() {
	return pageNow;
}
public void setPageNow(Integer pageNow) {
	this.pageNow = pageNow;
}
public Integer getPageCount() {
	return pageCount;
}
public void setPageCount(Integer pageCount) {
	this.pageCount = pageCount;
}
public List<?> getList() {
	return list;
}
public void setList(List<?> list) {
	this.list = list;
}

}
