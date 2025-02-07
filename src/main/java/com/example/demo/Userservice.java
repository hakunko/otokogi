package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Userservice{
	private final PasswordEncoder hashpass=new BCryptPasswordEncoder();
	
	public String hash(String pass) {
		return hashpass.encode(pass);
	}
	
	public boolean verify(String nowpass,String hashedpass) {
		return hashpass.matches(nowpass, hashedpass);
	}
}
