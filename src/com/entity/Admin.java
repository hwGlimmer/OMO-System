package com.entity;
/**
 * 功能：管理员信息实体类 
 * @author 胡伟
 * 时间：2017/8/20
 */
public class Admin implements java.io.Serializable {

	// Fields

	private Integer id;
	private String loginName;//管理员账号
	private String loginPwd;//管理员密码

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(String loginName, String loginPwd) {
		this.loginName = loginName;
		this.loginPwd = loginPwd;
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
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

}