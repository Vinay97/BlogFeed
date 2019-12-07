package com.blogapp.example.BlogApp.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TOPIC")
public class Topic {
	
	@Id
	@Column(name = "TID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tId;
	
	@Column(name = "TOPIC_NAME",length=50, nullable=false, unique=true)
	private String topicName;
	
	

	public long gettId() {
		return tId;
	}

	public void settId(long tId) {
		this.tId = tId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
}
