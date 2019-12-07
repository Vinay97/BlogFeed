package com.blogapp.example.BlogApp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogapp.example.BlogApp.Model.BlogInfo;
import com.blogapp.example.BlogApp.Model.Topic;
import com.blogapp.example.BlogApp.Model.UserInfo;
import com.blogapp.example.BlogApp.Repo.BlogInfoRepository;
import com.blogapp.example.BlogApp.Repo.TopicRepository;
import com.blogapp.example.BlogApp.Repo.UserInfoRepository;

@Component
public class BlogService {
	
	@Autowired
	BlogInfoRepository blogInfoRepository;
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	public BlogInfo addBlog(String userId, long tId, BlogInfo blogInfo) {
	UserInfo userInfo = userInfoRepository.findByUserId(userId);
	System.out.println(userInfo.getFirstName());
	Topic topic = topicRepository.findById(tId).get();
	if(userInfo!=null&&topic!=null) {
	blogInfo.setUserInfo(userInfo);
	blogInfo.setTopic(topic);
	System.out.println(blogInfo.getBlogTitle());
	return blogInfoRepository.save(blogInfo);
	}
	return null;
	}
	
	public List<BlogInfo> getAllBlog() {
		return (List<BlogInfo>) blogInfoRepository.findAll();
	}
	
	public List<Topic> getAllTopic(){
		return (List<Topic>) topicRepository.findAll();
	}
}
