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
	//ע��sessionFactory
	
	@Resource
	public void setSF(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	// ��ѯ���в�ϵ
	public List<Mealseries> findAllMS() {
		//��ȡsession
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Mealseries";
		Query query = session.createQuery(hql);
		List<Mealseries> list = query.list();
		return list;
	}

}
