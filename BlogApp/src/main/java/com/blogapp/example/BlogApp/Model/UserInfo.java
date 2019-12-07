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
@Table(name = "USERINFO")
public class UserInfo {
	@Id
	@Column(name = "U_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long uId;
	
	@Column(name="USER_ID", length=50, nullable=false, unique=true)
	private String userId;
	
	@Column(name="FIRST_NAME", length=50, nullable=false, unique=false)
	private String firstName;
	
	@Column(name="LAST_NAME", length=50, nullable=true, unique=false)
	private String lastName;
	
	@Column(name="PASSWORD", length = 100, nullable=false)
	private String password;
	
	

	public long getuId() {
		return uId;
	}

	public void setuId(long uId) {
		this.uId = uId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
