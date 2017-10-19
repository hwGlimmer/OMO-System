package com.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.*;

import com.dao.UserDao;
import com.entity.Admin;
import com.entity.Users;

/**
 * ���ܣ�ʵ���û���صĹ���
 * 
 * @author ��ΰ ʱ�䣺2017-08-20
 */
@Controller
public class UserAction implements SessionAware {
	private Users users;
	private String type;
	private String loginName;
	private String loginPwd;
	private Map<String, Object> session;
	@Resource
	private UserDao userDao;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	// ע���û�
	public String addUser() {
		userDao.addUser(users);
		return "success";
	}
	// �û���֤
	public String check() {
		List list;
		if ("userLogin".equals(type)) {// �ͻ���½��֤
			Users u = new Users();
			u.setLoginName(loginName);
			u.setLoginPwd(loginPwd);
			list = userDao.checkUser(u);
			if (list.size() > 0) {
				session.put("user", list.get(0));
			}
		} else if ("adminLogin".equals(type)) {// ����Ա��֤
			Admin a = new Admin();
			a.setLoginName(loginName);
			a.setLoginPwd(loginPwd);
			list = userDao.checkAdmin(a);
			if (list.size() > 0) {
				session.put("admin", list.get(0));
			}
		}
		return "success";
	}
	 // �޸��û���Ϣ
	public String updateUser(){
		boolean flag = userDao.updateUser(users);
		if(flag){
			session.put("user", users);
		}
		return "success";
	}
	// ע��
	public String logOut() throws Exception{
		if("userlogout".equals(type)){
			session.remove("user");
		}
		if("adminlogout".equals(type)){
			session.remove("admin");
		}
		return "show";
	}
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLoginName() {
		return loginName;
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

}
