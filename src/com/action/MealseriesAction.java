package com.action;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.dao.MealDao;
import com.dao.MealseriesDao;
import com.entity.Meal;
import com.entity.Mealseries;
/**
 * ���ܣ���ϵ��ص�Action
 * @author ��ΰ
 * ʱ�䣺2017/8/20
 *
 */
@Controller
public class MealseriesAction{
	private List<Mealseries> listMS;
	
	private List<Meal> listM;
	private int totalPage;
	private int page;
	private int pageSize;
	private int totalNum;
	
	private Meal meal;
	
	private int status = 0;
	
	private int id;
	@Resource
	private MealseriesDao mealseriesDao ;
	@Resource
	private MealDao mealDao;
	
	//��ѯ���в�ϵ����Ʒ
	public String findAllMS(){
		status = 1;
		meal = null;
		listMS = mealseriesDao.findAllMS();//��ѯ����ϵ
		//��ҳ��ѯ��Ʒ
		totalNum = mealDao.findAllCount();
		if(totalNum%pageSize==0){
			totalPage = totalNum/pageSize;
		}else{
			totalPage = totalNum/pageSize+1;
		}
		if(page<1){
			page=1;
		}else if(page>totalPage){
			page = totalPage;
		}
		listM = mealDao.findAlllMeal(page, pageSize);
		return "success";
	}
	// ��������(�����������߲�ϵɸѡ)��ѯ��Ʒ��Ϣ
	public String findByParam(){
		status = 2;
		listMS = mealseriesDao.findAllMS();//��ѯ����ϵ
		//��ҳ��ѯ��Ʒ
		totalNum = mealDao.findCountByParam(meal);
		if(totalNum%pageSize==0){
			totalPage = totalNum/pageSize;
		}else{
			totalPage = totalNum/pageSize+1;
		}
		if(page<1){
			page=1;
		}else if(page>totalPage){
			page = totalPage;
		}
		listM = mealDao.findByParam(page, pageSize, meal);
		return "success";
	}
	//����id��ѯ(��Ʒ)
	public String findById(){
		meal = mealDao.findById(id);
		return "success";
	}
	
	public List<Mealseries> getListMS() {
		return listMS;
	}
	
	public void setListMS(List<Mealseries> listMS) {
		this.listMS = listMS;
	}


	public List<Meal> getListM() {
		return listM;
	}


	public void setListM(List<Meal> listM) {
		this.listM = listM;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getTotalNum() {
		return totalNum;
	}


	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
