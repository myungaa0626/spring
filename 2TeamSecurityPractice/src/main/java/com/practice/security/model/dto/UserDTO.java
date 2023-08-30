package com.practice.security.model.dto;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserDTO extends User {

	private String userid;
	private Date regDate;

	public UserDTO(String username, String password, Collection<? extends GrantedAuthority> authorities, String userid,
			Date regDate) {

		super(username, password, authorities);
		this.userid = userid;
		this.regDate = regDate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", regDate=" + regDate + "]";
	}



}