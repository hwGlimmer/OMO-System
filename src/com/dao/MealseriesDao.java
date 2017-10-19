package com.dao;
import java.util.List;
/**
 * 张清 2017-08-20
 * 菜系相关的dao层接口
 */
import com.entity.Mealseries;
/**
 * 功能：菜系相关的dao层接口
 * @author 胡伟
 * 时间：2017/8/20
 *
 */
public interface MealseriesDao {
	//查询所有的菜系
	public List<Mealseries> findAllMS();
}
