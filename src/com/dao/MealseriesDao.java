package com.dao;
import java.util.List;
/**
 * ���� 2017-08-20
 * ��ϵ��ص�dao��ӿ�
 */
import com.entity.Mealseries;
/**
 * ���ܣ���ϵ��ص�dao��ӿ�
 * @author ��ΰ
 * ʱ�䣺2017/8/20
 *
 */
public interface MealseriesDao {
	//��ѯ���еĲ�ϵ
	public List<Mealseries> findAllMS();
}
