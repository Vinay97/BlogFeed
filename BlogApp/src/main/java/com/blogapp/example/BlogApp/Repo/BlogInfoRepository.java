package com.blogapp.example.BlogApp.Repo;

import org.springframework.data.repository.CrudRepository;

import com.blogapp.example.BlogApp.Model.BlogInfo;

public interface BlogInfoRepository extends CrudRepository<BlogInfo, Long>{

}
