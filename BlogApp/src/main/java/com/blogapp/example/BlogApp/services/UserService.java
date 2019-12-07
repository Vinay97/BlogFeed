package com.blogapp.example.BlogApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.blogapp.example.BlogApp.Model.Topic;
import com.blogapp.example.BlogApp.Model.UserInfo;
import com.blogapp.example.BlogApp.Repo.TopicRepository;
import com.blogapp.example.BlogApp.Repo.UserInfoRepository;
import com.blogapp.example.BlogApp.security.PasswordEncoderConfig;

@Component
public class UserService {
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	PasswordEncoderConfig passwordEncoderConfig;
	
	public long addNewUser(UserInfo userInfo) {
		if(userInfoRepository.getUserByUserId(userInfo.getUserId())!=null) {
			return -1;
		}
		PasswordEncoder passwordEncoder = passwordEncoderConfig.passwordEncoder();
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		return userInfoRepository.save(userInfo).getuId();
	}
	
	public boolean login(String userId, String password) {
		String encodedPassword = userInfoRepository.getUserPassword(userId);
		if(encodedPassword!=null) {
		PasswordEncoder passwordEncoder = passwordEncoderConfig.passwordEncoder();
		if(passwordEncoder.matches(password, encodedPassword)) {
			return true;
		}
		}
			return false;
	}
	
	public Topic addTopic(Topic topic) {
		return topicRepository.save(topic);
	}
}
