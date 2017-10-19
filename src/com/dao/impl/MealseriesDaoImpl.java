package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.dao.MealseriesDao;
import com.entity.Mealseries;
@Repository
public class MealseriesDaoImpl implements MealseriesDao {
	
	private SessionFactory sessionFactory;
	//注入sessionFactory
	
	@Resource
	public void setSF(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	// 查询所有菜系
	public List<Mealseries> findAllMS() {
		//获取session
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Mealseries";
		Query query = session.createQuery(hql);
		List<Mealseries> list = query.list();
		return list;
	}

}
