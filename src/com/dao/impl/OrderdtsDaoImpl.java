package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dao.OrderdtsDao;
import com.entity.Orderdts;
import com.entity.Orders;
@Repository
public class OrderdtsDaoImpl implements OrderdtsDao {
	private SessionFactory sessionFactory;
	//注入SessionFactory
	@Resource
	public void serSF(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	// 添加订单详情，生成订单，保存到数据库
	@Override
	public void addOrderdts(Orderdts orderdts) {
		Session session = sessionFactory.getCurrentSession();
		session.save(orderdts);
	}
	
	// 根据订单OID查询订单信息
	@Override
	public List<Orderdts> findByOid(int oid) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Orderdts.class);
		c.add(Restrictions.eq("orders.oid", oid));
		return c.list();
	}

}
