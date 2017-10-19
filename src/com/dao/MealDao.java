package com.dao;

import java.util.List;

import com.entity.Meal;
/**
 * 功能：菜品相关的dao层接口
 * @author 胡伟
 * 时间：2017/8/20
 *
 */
public interface MealDao {

	// 查询菜品总数
	public int findAllCount();

	// 分页查询
	public List<Meal> findAlllMeal(int page, int pageSize);

	// 根据条件查询菜品信息
	public List<Meal> findByParam(int page, int pageSize, Meal meal);

	// 根据条件查询菜品总数
	public int findCountByParam(Meal meal);

	// 根据id查询菜品
	public Meal findById(int id);
	
	// 添加菜品
	public boolean addMeal(Meal meal);
	
	// 修改菜品
	public boolean updateMeal(Meal meal);
	
	// 删除菜品
	public boolean delMeal(Meal meal);
}
