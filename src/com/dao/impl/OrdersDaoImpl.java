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
	// ע��sessionFactory

	@Resource
	public void setSF(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// �����û�id��ѯ����
	@Override
	public List<Orders> findOrdersByUserID(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Orders.class);
		c.add(Restrictions.eq("users.id", userId));
		return c.list();
	}

	// ����oidɾ������
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

	// ����oid��ѯ����
	@Override
	public Orders findOrdersByID(int ordersId) {
		// ��ȡsession
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Orders.class);
		c.add(Restrictions.eq("oid", ordersId));
		return (Orders) c.list().get(0);
	}

	// ��ҳ��ѯ���ݿ������ж���
	@Override
	public List<Orders> findAllOrders(int page, int pageSize) {
		// ��ȡsession
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Orders.class);
		c.setFirstResult((page - 1) * pageSize);
		c.setMaxResults(pageSize);
		return c.list();
	}

	// ����������ѯ������Ϣ(״̬�������Ķ�����)
	@Override
	public List<Orders> findOrdersByParam(int page, int pageSize, Orders orders) {
		// ��ȡsession
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Orders.class);
		// ��������ɸѡ
		if (orders.getOid().toString()!= null && orders.getOid().toString().equals("")) {
			// ��ѯ
			c.add(Restrictions.eq("oid",orders.getOid()));
		}
		// ��״̬ɸѡ
		if (orders.getOrderState() != null && !orders.getOrderState().equals("")) {
			c.add(Restrictions.eq("orderState", orders.getOrderState()));
		}

		c.setFirstResult((page - 1) * pageSize);
		c.setMaxResults(pageSize);
		return c.list();
	}

	// ��ȡ��������
	@Override
	public int findSumOrders() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(o) from Orders o";
		Query query = session.createQuery(hql);
		int i = Integer.valueOf(query.uniqueResult().toString());
		return i;
	}

	// �޸Ķ�������Ҫ�ǹ���Ա������������״̬��
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
