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
 * ���ܣ���Ʒ��ع��ܵ�Action
 * 
 * @author ��ΰ ʱ�䣺2017/8/25
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
	private File doc;// �ϴ�ͼƬ����
	private String docFileName;// �ϴ�ͼƬ����
	private String docContentType;// �ϴ�ͼƬ����
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;

	}

	// �����б��ȡ��ϵ��Ϣ
	public String doAddMeal() {
		List<Mealseries> list = mealseriesDao.findAllMS();
		request.put("MealseriesList", list);//��Ӳ�Ʒʱ����ȡ�����б�
		return "success";
	}

	// ��Ӳ�ƷͼƬ�����ص�show.jsp����
	public String addMeal() throws IOException {
		if (docFileName != null) {
			// ��ȡ�ļ��ľ���·��
			String path = ServletActionContext.getServletContext().getRealPath("/mealimages");
			// �޸��ļ���
			String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
			int random = new Random().nextInt(10000);
			int position = docFileName.lastIndexOf(".");
			String extension = docFileName.substring(position);
			docFileName = formatDate + random + extension;
			// ����Ŀ���ļ�
			File target = new File(path, docFileName);
			// ���ļ���Ϣ���Ƶ�Ŀ���ļ�
			FileUtil.copyFile(doc, target);
			meal.setMealImage(docFileName);
			mealDao.addMeal(meal);
		}
		return "success";
	}

	// ����mealIdɾ����Ʒ
	public String delMeal() {
		meal = mealDao.findById(mealId);
		mealDao.delMeal(meal);
		return "success";
	}

	
	// �޸�֮ǰ����id��ѯ(��Ʒ)
	public String findById() {
		/*List<Mealseries> list1 = mealseriesDao.findAllMS();*/
		
		//session.put("seriesInfo", list1);//�޸Ĳ�Ʒ����ȡ�����б�
		doAddMeal();
		meal = mealDao.findById(id);
		return "success";
	}
	// �޸Ĳ�Ʒ
	public String updateMeal() throws IOException {
		if (docFileName != null) {
			// ��ȡ�ļ��ľ���·��
			String path = ServletActionContext.getServletContext().getRealPath("/mealimages");
			// �޸��ļ���
			String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
			int random = new Random().nextInt(10000);
			int position = docFileName.lastIndexOf(".");
			String extension = docFileName.substring(position);
			docFileName = formatDate + random + extension;
			// ����Ŀ���ļ�
			File target = new File(path, docFileName);
			// ���ļ���Ϣ���Ƶ�Ŀ���ļ�
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
