package com.hyj.hyjurl.dto;

import java.util.Date;

public class MainDto {
	
	String result;
	
	int u_no;
	String s_url;
	String f_url;
	
	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
	}

	public String getS_url() {
		return s_url;
	}

	public void setS_url(String s_url) {
		this.s_url = s_url;
	}

	public String getF_url() {
		return f_url;
	}

	public void setF_url(String f_url) {
		this.f_url = f_url;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
