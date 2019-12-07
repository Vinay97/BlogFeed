package com.blogapp.example.BlogApp.Repo;

import org.springframework.data.repository.CrudRepository;

import com.blogapp.example.BlogApp.Model.Topic;

public interface TopicRepository extends CrudRepository<Topic, Long>{

}
