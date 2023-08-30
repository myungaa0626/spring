package com.practice.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ShaEncoder {
	
	@Autowired
//	@Qualifier("passwordEncoder")
	ShaPasswordEncoder encoder;
	
	public String encoding(String str) {
		
		return encoder.encodePassword(str,null);
		
	}
	
	public String saltEncoding(String str, String salt) {
		
		return encoder.encodePassword(str,salt);
	}
	
	
	

}
