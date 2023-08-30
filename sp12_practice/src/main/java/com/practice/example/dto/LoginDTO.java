package com.practice.example.dto;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;



public class LoginDTO extends User {
	
	
	private String id;

	public LoginDTO(String id, String pwd, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(id, pwd, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	    
	      this.id = id;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LoginDTO [id=" + id + "]";
	}
	
}
