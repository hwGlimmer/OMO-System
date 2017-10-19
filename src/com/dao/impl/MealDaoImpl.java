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

import com.dao.MealDao;
import com.entity.Meal;

@Repository
public class MealDaoImpl implements MealDao {

	private SessionFactory sessionFactory;
	// ע��sessionFactory

	@Resource
	public void setSF(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// ��ȡ��Ʒ����
	@Override
	public int findAllCount() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(m) from Meal m";
		Query query = session.createQuery(hql);
		int i = Integer.valueOf(query.uniqueResult().toString());
		return i;
	}

	// ��ҳ��ѯ��Ʒ
	@Override
	public List<Meal> findAlllMeal(int page, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Meal.class);
		c.setFirstResult((page - 1) * pageSize);
		c.setMaxResults(pageSize);
		return c.list();
	}

	// ��������(�����������߲�ϵɸѡ)��ѯ��Ʒ��Ϣ
	@Override
	public List<Meal> findByParam(int page, int pageSize, Meal meal) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Meal.class);
		// ������ɸѡ
		if (meal.getMealName() != null && !meal.getMealName().equals("")) {
			// ģ����ѯ
			c.add(Restrictions.like("mealName", meal.getMealName(), MatchMode.ANYWHERE));
		}
		// ����ϵ��ɸѡ
		if (meal.getMealseries() != null && !meal.getMealseries().getSeriesId().equals("")) {
			c.add(Restrictions.eq("mealseries.seriesId", meal.getMealseries().getSeriesId()));
		}
		c.setFirstResult((page - 1) * pageSize);
		c.setMaxResults(pageSize);
		return c.list();
	}

	// ����������ѯ��Ʒ����
	@Override
	public int findCountByParam(Meal meal) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Meal.class);
		// ������ɸѡ
		if (meal.getMealName() != null && !meal.getMealName().equals("")) {
			// ģ����ѯ
			c.add(Restrictions.like("mealName", meal.getMealName(), MatchMode.ANYWHERE));
		}
		// ����ϵ��ɸѡ
		if (meal.getMealseries() != null && !meal.getMealseries().getSeriesId().equals("")) {
			c.add(Restrictions.eq("mealseries.seriesId", meal.getMealseries().getSeriesId()));
		}
		return c.list().size();
	}

	// ����id��ѯ��Ʒ
	@Override
	public Meal findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Meal meal = (Meal) session.get(Meal.class, id);
		return meal;
	}

	// ��Ӳ�Ʒ
	@Override
	public boolean addMeal(Meal meal) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(meal);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	// �޸Ĳ�Ʒ
	@Override
	public boolean updateMeal(Meal meal) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(meal);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	// ɾ����Ʒ
	@Override
	public boolean delMeal(Meal meal) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(meal);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
}
