package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.dao.MealDao;
import com.dao.MealseriesDao;
import com.entity.Meal;
import com.entity.Mealseries;

/**
 * ���ܣ������Ʒ����ز�����Action
 * @author ��ΰ
 * ʱ�䣺2017/8/26
 */
@Controller
public class ManagerMealAction {
	private List<Mealseries> listMSS;
	
	private List<Meal> listMM;
	private int totalPage;
	private int page;
	private int pageSize;
	private int totalNum;
	
	private Meal meal;
	
	private int status = 0;
	@Resource
	private MealseriesDao mealseriesDao ;
	@Resource
	private MealDao mealDao;
	//��ѯ���в�ϵ����Ʒ
		public String findAllMSS(){
			status = 1;
			meal = null;
			listMSS = mealseriesDao.findAllMS();//��ѯ����ϵ
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
			listMM = mealDao.findAlllMeal(page, pageSize);
			return "success";
		}
		// ��������(�����������߲�ϵɸѡ)��ѯ��Ʒ��Ϣ
		public String findByParam1(){
			status = 2;
			listMSS = mealseriesDao.findAllMS();//��ѯ����ϵ
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
			listMM = mealDao.findByParam(page, pageSize, meal);
			return "success";
		}
		public List<Mealseries> getListMSS() {
			return listMSS;
		}
		public void setListMSS(List<Mealseries> listMSS) {
			this.listMSS = listMSS;
		}
		public List<Meal> getListMM() {
			return listMM;
		}
		public void setListMM(List<Meal> listMM) {
			this.listMM = listMM;
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
		
}
