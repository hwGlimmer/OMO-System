package com.dao;

import java.util.List;

import com.entity.Admin;
import com.entity.Users;
/**
 * ���ܣ��û���ص�dao��ӿ�
 * @author ��ΰ
 * ʱ�䣺2017/8/20
 *
 */
public interface UserDao {
	// �����û�
	public boolean addUser(Users users);

	// �û���֤
	public List<Users> checkUser(Users users);

	// ����Ա��֤
	public List<Admin> checkAdmin(Admin admin);

	// �ͻ��޸���Ϣ
	public boolean updateUser(Users users);
}
