package com.blogapp.example.BlogApp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.example.BlogApp.Model.BlogInfo;
import com.blogapp.example.BlogApp.Model.Topic;
import com.blogapp.example.BlogApp.Model.UserInfo;
import com.blogapp.example.BlogApp.Model.UserLogin;
import com.blogapp.example.BlogApp.services.BlogService;
import com.blogapp.example.BlogApp.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BlogService blogService;
	
	@RequestMapping("/hello")
	public String helloBlog() {
		return "Hello Blog";
	}
	
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public ResponseEntity<Map<String,String>> addNewUser(@RequestBody UserInfo userInfo){
		ResponseEntity<Map<String, String>> res = null;
		long status = userService.addNewUser(userInfo);
		if(status==-1) {
			Map<String,String> map = new HashMap<>();
			map.put("status","Duplicate");
			res = new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
		}
		else {
			Map<String,String> map = new HashMap<>();
			map.put("status", "Added");
			res = new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
		}
		return res;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Map<String, String>> login(@RequestBody UserLogin userLogin){
		ResponseEntity<Map<String, String>> res = null;
		if(userService.login(userLogin.getUserId(), userLogin.getPassword())) {
			Map<String, String> map = new HashMap<>();
			map.put("status", "success");
			res = new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
			return res;
		}
			Map<String, String> map = new HashMap<>();
			map.put("status", "error");
			res = new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
			return res;
	}
	
	@RequestMapping(value = "/addTopic", method = RequestMethod.POST)
	public ResponseEntity<Topic> addNewTopic(@RequestBody Topic topic){
		ResponseEntity<Topic> res = null;
		Topic addedTopic = userService.addTopic(topic);
		if(addedTopic!=null) {
			res = new ResponseEntity<>(addedTopic, HttpStatus.OK);
			return res;
		}
		return res;
	}
	
	@RequestMapping(value = "/{userId}/{tId}/newBlog", method = RequestMethod.POST)
	public ResponseEntity<BlogInfo> addBlog(@PathVariable(value = "userId") String userId, @PathVariable(name = "tId")
	long tId,@RequestBody BlogInfo blogInfo){
		ResponseEntity<BlogInfo> res = null;
		BlogInfo getBlogInfo = blogService.addBlog(userId, tId, blogInfo);
		if(getBlogInfo!=null) {
			res = new ResponseEntity<BlogInfo>(getBlogInfo,HttpStatus.OK);
		}
		return res;
	}
	
	@RequestMapping(value = "/getAllBlog", method = RequestMethod.GET)
	public ResponseEntity<List<Map<String, Object>>> getAllBlog(){
		List<Map<String, Object>> listBlog = new ArrayList<>();
		List<BlogInfo> blogInfoList = blogService.getAllBlog();
		for(BlogInfo b : blogInfoList) {
			Map<String, Object> map = new HashMap<>();
			String userId = b.getUserInfo().getUserId();
			map.put("blogDetails", b);
			map.put("userName", userId);
			listBlog.add(map);
		}
		return new ResponseEntity<>(listBlog,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllTopic", method = RequestMethod.GET)
	public ResponseEntity<List<Topic>> getAllTopic(){
		return new ResponseEntity<>(blogService.getAllTopic(), HttpStatus.OK);
	}
}
