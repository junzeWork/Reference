package com.yc.springmvc.bean;

public class Result{
	private String url;
	private String msg;
	
	public Result() {
	}
	public Result(String url, String msg) {
		this.url = url;
		this.msg = msg;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}