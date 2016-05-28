package org.springmvc_demo.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

	private static final long serialVersionUID = 216615822538235296L;
	
	private Date createDate;
	private String email;
	private String pwd;
	private Integer userId;
	
	private String userName;
	
	public User() {}
	
	public User(Integer userId, String userName, String email, String pwd) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.pwd = pwd;
	}

	public User(Integer userId, String userName, String email, String pwd,
			Date createDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.pwd = pwd;
		this.createDate = createDate;
	}
	
	
	public User(String userName, String email, String pwd) {
		super();
		this.userName = userName;
		this.email = email;
		this.pwd = pwd;
	}
	
	
	public User(String userName, String email, String pwd, Date createDate) {
		super();
		this.userName = userName;
		this.email = email;
		this.pwd = pwd;
		this.createDate = createDate;
	}
	
	public Date getCreateDate() {
		return createDate;
	}

	public String getEmail() {
		return email;
	}


	public String getPwd() {
		return pwd;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setEmail(String email) {
		if( email != null && !"".equals(email.trim()) )
			this.email = email;
	}

	public void setPwd(String pwd) {
		if( pwd != null && !"".equals(pwd.trim()) )
			this.pwd = pwd;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [createDate=" + createDate + ", email=" + email
				+ ", pwd=" + pwd + ", userId=" + userId
				+ ", userName=" + userName + "]";
	}
}
