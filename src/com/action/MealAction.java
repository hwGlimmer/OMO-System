package com.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Controller;

import com.dao.MealDao;
import com.dao.MealseriesDao;
import com.entity.Meal;
import com.entity.Mealseries;

/**
 * 功能：菜品相关功能的Action
 * 
 * @author 胡伟 时间：2017/8/25
 */
@Controller
public class MealAction implements RequestAware,SessionAware {
	Map<String, Object> request;
	Map<String, Object> session;
	private int mealId;
	private int id;
	@Resource
	private MealseriesDao mealseriesDao;
	@Resource
	private MealDao mealDao;

	private Meal meal;
	private File doc;// 上传图片属性
	private String docFileName;// 上传图片名称
	private String docContentType;// 上传图片类型
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;

	}

	// 下拉列表获取菜系信息
	public String doAddMeal() {
		List<Mealseries> list = mealseriesDao.findAllMS();
		request.put("MealseriesList", list);//添加菜品时，获取下拉列表
		return "success";
	}

	// 添加菜品图片，返回到show.jsp界面
	public String addMeal() throws IOException {
		if (docFileName != null) {
			// 获取文件的绝对路径
			String path = ServletActionContext.getServletContext().getRealPath("/mealimages");
			// 修改文件名
			String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
			int random = new Random().nextInt(10000);
			int position = docFileName.lastIndexOf(".");
			String extension = docFileName.substring(position);
			docFileName = formatDate + random + extension;
			// 创建目标文件
			File target = new File(path, docFileName);
			// 将文件信息复制到目标文件
			FileUtil.copyFile(doc, target);
			meal.setMealImage(docFileName);
			mealDao.addMeal(meal);
		}
		return "success";
	}

	// 根据mealId删除菜品
	public String delMeal() {
		meal = mealDao.findById(mealId);
		mealDao.delMeal(meal);
		return "success";
	}

	
	// 修改之前根据id查询(菜品)
	public String findById() {
		/*List<Mealseries> list1 = mealseriesDao.findAllMS();*/
		
		//session.put("seriesInfo", list1);//修改菜品，获取下拉列表
		doAddMeal();
		meal = mealDao.findById(id);
		return "success";
	}
	// 修改菜品
	public String updateMeal() throws IOException {
		if (docFileName != null) {
			// 获取文件的绝对路径
			String path = ServletActionContext.getServletContext().getRealPath("/mealimages");
			// 修改文件名
			String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
			int random = new Random().nextInt(10000);
			int position = docFileName.lastIndexOf(".");
			String extension = docFileName.substring(position);
			docFileName = formatDate + random + extension;
			// 创建目标文件
			File target = new File(path, docFileName);
			// 将文件信息复制到目标文件
			FileUtil.copyFile(doc, target);
			meal.setMealImage(docFileName);
			mealDao.updateMeal(meal);
		}
		return "success";
	}
	

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public File getDoc() {
		return doc;
	}

	public void setDoc(File doc) {
		this.doc = doc;
	}

	public String getDocFileName() {
		return docFileName;
	}

	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}

	public String getDocContentType() {
		return docContentType;
	}

	public void setDocContentType(String docContentType) {
		this.docContentType = docContentType;
	}

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	
}
