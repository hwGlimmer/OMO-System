package com.entity;
/**
 * ���ܣ�����Ա��Ϣʵ���� 
 * @author ��ΰ
 * ʱ�䣺2017/8/20
 */
public class Admin implements java.io.Serializable {

	// Fields

	private Integer id;
	private String loginName;//����Ա�˺�
	private String loginPwd;//����Ա����

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