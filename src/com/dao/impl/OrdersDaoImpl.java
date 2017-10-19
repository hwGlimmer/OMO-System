package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dao.OrdersDao;
import com.entity.Mealseries;
import com.entity.Orders;

@Repository
public class OrdersDaoImpl implements OrdersDao {
	private SessionFactory sessionFactory;
	// 注入sessionFactory

	@Resource
	public void setSF(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 根据用户id查询订单
	@Override
	public List<Orders> findOrdersByUserID(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Orders.class);
		c.add(Restrictions.eq("users.id", userId));
		return c.list();
	}

	// 根据oid删除订单
	@Override
	public boolean delOrdersById(Orders orders) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(orders);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	// 根据oid查询订单
	@Override
	public Orders findOrdersByID(int ordersId) {
		// 获取session
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Orders.class);
		c.add(Restrictions.eq("oid", ordersId));
		return (Orders) c.list().get(0);
	}

	// 分页查询数据库中所有订单
	@Override
	public List<Orders> findAllOrders(int page, int pageSize) {
		// 获取session
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Orders.class);
		c.setFirstResult((page - 1) * pageSize);
		c.setMaxResults(pageSize);
		return c.list();
	}

	// 根据条件查询订单信息(状态和搜索的订单号)
	@Override
	public List<Orders> findOrdersByParam(int page, int pageSize, Orders orders) {
		// 获取session
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Orders.class);
		// 按订单号筛选
		if (orders.getOid().toString()!= null && orders.getOid().toString().equals("")) {
			// 查询
			c.add(Restrictions.eq("oid",orders.getOid()));
		}
		// 按状态筛选
		if (orders.getOrderState() != null && !orders.getOrderState().equals("")) {
			c.add(Restrictions.eq("orderState", orders.getOrderState()));
		}

		c.setFirstResult((page - 1) * pageSize);
		c.setMaxResults(pageSize);
		return c.list();
	}

	// 获取订单总数
	@Override
	public int findSumOrders() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(o) from Orders o";
		Query query = session.createQuery(hql);
		int i = Integer.valueOf(query.uniqueResult().toString());
		return i;
	}

	// 修改订单（主要是管理员处理订单，更改状态）
	@Override
	public boolean updateOrder(Orders orders) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(orders);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

}
