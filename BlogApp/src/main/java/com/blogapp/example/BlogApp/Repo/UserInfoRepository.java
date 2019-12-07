package com.blogapp.example.BlogApp.Repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.blogapp.example.BlogApp.Model.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long>{
	
	@Query(value = "select * from userinfo where USER_ID=?1", nativeQuery = true)
	UserInfo getUserByUserId(String userId);
	
	@Query(value = "select PASSWORD from userinfo where USER_ID=?1", nativeQuery = true)
	String getUserPassword(String userId);
	
	UserInfo findByUserId(String userId);
}
