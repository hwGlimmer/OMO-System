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
	// 注入sessionFactory

	@Resource
	public void setSF(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 获取菜品总数
	@Override
	public int findAllCount() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(m) from Meal m";
		Query query = session.createQuery(hql);
		int i = Integer.valueOf(query.uniqueResult().toString());
		return i;
	}

	// 分页查询菜品
	@Override
	public List<Meal> findAlllMeal(int page, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Meal.class);
		c.setFirstResult((page - 1) * pageSize);
		c.setMaxResults(pageSize);
		return c.list();
	}

	// 根据条件(菜名搜索或者菜系筛选)查询菜品信息
	@Override
	public List<Meal> findByParam(int page, int pageSize, Meal meal) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Meal.class);
		// 按菜名筛选
		if (meal.getMealName() != null && !meal.getMealName().equals("")) {
			// 模糊查询
			c.add(Restrictions.like("mealName", meal.getMealName(), MatchMode.ANYWHERE));
		}
		// 按菜系名筛选
		if (meal.getMealseries() != null && !meal.getMealseries().getSeriesId().equals("")) {
			c.add(Restrictions.eq("mealseries.seriesId", meal.getMealseries().getSeriesId()));
		}
		c.setFirstResult((page - 1) * pageSize);
		c.setMaxResults(pageSize);
		return c.list();
	}

	// 根据条件查询菜品总数
	@Override
	public int findCountByParam(Meal meal) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Meal.class);
		// 按菜名筛选
		if (meal.getMealName() != null && !meal.getMealName().equals("")) {
			// 模糊查询
			c.add(Restrictions.like("mealName", meal.getMealName(), MatchMode.ANYWHERE));
		}
		// 按菜系名筛选
		if (meal.getMealseries() != null && !meal.getMealseries().getSeriesId().equals("")) {
			c.add(Restrictions.eq("mealseries.seriesId", meal.getMealseries().getSeriesId()));
		}
		return c.list().size();
	}

	// 根据id查询菜品
	@Override
	public Meal findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Meal meal = (Meal) session.get(Meal.class, id);
		return meal;
	}

	// 添加菜品
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

	// 修改菜品
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

	// 删除菜品
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
