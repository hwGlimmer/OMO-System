package com.dao;

import java.util.List;

import com.entity.Meal;
/**
 * ���ܣ���Ʒ��ص�dao��ӿ�
 * @author ��ΰ
 * ʱ�䣺2017/8/20
 *
 */
public interface MealDao {

	// ��ѯ��Ʒ����
	public int findAllCount();

	// ��ҳ��ѯ
	public List<Meal> findAlllMeal(int page, int pageSize);

	// ����������ѯ��Ʒ��Ϣ
	public List<Meal> findByParam(int page, int pageSize, Meal meal);

	// ����������ѯ��Ʒ����
	public int findCountByParam(Meal meal);

	// ����id��ѯ��Ʒ
	public Meal findById(int id);
	
	// ��Ӳ�Ʒ
	public boolean addMeal(Meal meal);
	
	// �޸Ĳ�Ʒ
	public boolean updateMeal(Meal meal);
	
	// ɾ����Ʒ
	public boolean delMeal(Meal meal);
}
