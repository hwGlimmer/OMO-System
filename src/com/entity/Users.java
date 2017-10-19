package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * ���ܣ��û���Ϣʵ���� 
 * @author ��ΰ
 * ʱ�䣺2017/8/20
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer id;
	private String loginName;//�ͻ�����
	private String loginPwd;//�ͻ�����
	private String trueName;//��ʵ����
	private String email;//����
	private String phone;//�绰
	private String address;//סַ
	private Set<Orders> orderses = new HashSet<Orders>();//һ�Զ�

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(String loginName, String loginPwd, String trueName,
			String email, String phone, String address, Set orderses) {
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.trueName = trueName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.orderses = orderses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	
	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getTrueName() {
		return this.trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

}