package com.dao;

import java.util.List;

import com.entity.Admin;
import com.entity.Users;
/**
 * 功能：用户相关的dao层接口
 * @author 胡伟
 * 时间：2017/8/20
 *
 */
public interface UserDao {
	// 新增用户
	public boolean addUser(Users users);

	// 用户验证
	public List<Users> checkUser(Users users);

	// 管理员验证
	public List<Admin> checkAdmin(Admin admin);

	// 客户修改信息
	public boolean updateUser(Users users);
}
