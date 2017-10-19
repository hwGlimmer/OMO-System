package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.entity.Admin;
import com.entity.Users;

@Repository
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	@Resource
	// ע��SessionFactory
	public void SetSF(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// �����û�
	@Override
	public boolean addUser(Users users) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(users);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}
	//�û���֤
	@Override
	public List<Users> checkUser(Users users) {
		List <Users> list = null;
		//����session����
		Session session = sessionFactory.getCurrentSession();
		//����Criteria����
		Criteria c = session.createCriteria(Users.class);
		Example e = Example.create(users);
		c.add(e);
		list = c.list();
		return list;
	}
	//����Ա��֤
	@Override
	public List<Admin> checkAdmin(Admin admin) {
		List <Admin> list = null;
		//����session����
		Session session = sessionFactory.getCurrentSession();
		//����Criteria����
		Criteria c = session.createCriteria(Admin.class);
		Example e = Example.create(admin);
		c.add(e);
		list = c.list();
		return list;
	}
	
	// �޸Ŀͻ�������Ϣ
	@Override
	public boolean updateUser(Users users) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(users);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
