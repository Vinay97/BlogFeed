package com.blogapp.example.BlogApp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {
	
	public PasswordEncoder passwordEncoder() {
		return new PasswordEncoder() {
			@Override
			public String encode(CharSequence rawPassword) {
				// TODO Auto-generated method stub
				return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(4));
			}
			
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				// TODO Auto-generated method stub
				return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
			}
	};
	}
}
