/*
 * 文件名：UserDo.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： UserDo.java
 * 修改人：lizhi 1708029
 * 修改时间：2019年8月6日
 * 修改内容：新增
 */
package com.itmuch.cloud.entity;
/**
 * @Title:  UserDo.java
 * @Package: com.itmuch.cloud.entity.UserDo.java
 * @Description: 
 * @Company: ylink
 * @author  lizhi 
 * @date  2019年8月6日 下午3:17:13
 */

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String username;
	
	@Column
	private String name;
	
	@Column
	private int age;
	
	@Column
	private BigDecimal balance;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "UserDo [id=" + id + ", username=" + username + ", name=" + name + ", age=" + age + ", balance="
				+ balance + "]";
	}
}
