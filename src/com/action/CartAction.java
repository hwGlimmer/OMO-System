package com.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.dao.MealDao;
import com.entity.CartInfo;
import com.entity.Meal;

@Controller
public class CartAction implements SessionAware {
	Map<String, Object> session;
	private int mealId;
	private int quantity;

	@Resource
	private MealDao mealDao;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	// ��ӹ��ﳵ��Ϣ
	public String addCart() {
		// session�в�ѯ���ﳵ
		Map<String, CartInfo> cart = (Map<String, CartInfo>) session.get("cart");
		// ���ݲ�Ʒid��ѯ��Ʒ��Ϣ
		Meal meal = mealDao.findById(mealId);
		// session�Л]�й��ﳵʱ����ӹ��ﳵ
		if (cart == null) {
			cart = new HashMap<String, CartInfo>();
			session.put("cart", cart);
		}
		// ���ݲ�Ʒid��ȡ���ﳵ��Ĳ�Ʒ��Ϣ
		CartInfo m = cart.get(mealId + "");
		// ������ﳵ��û�д˲�Ʒ����Ӳ�Ʒ
		if (m == null) {
			m = new CartInfo(1, meal);
			cart.put(mealId + "", m);
		} else {
			m.setQuantity(m.getQuantity() + 1);
			cart.put(mealId + "", m);
		}
		return "success";
	}

	// ɾ�����ﳵָ����Ʒ
	public String delCartById() {

		Map<String, CartInfo> cart = (Map<String, CartInfo>) session.get("cart");
		cart.remove(mealId + "");

		return "success";
	}

	// ����ﳵ
	public String clearCart() {

		session.clear();

		return "success";
	}

	// �޸Ĺ��ﳵ��Ʒ��������ʵʱ��������
	public String updateSelectedQuantity() {
		// ��ȡ���ﳵ��ѯ
		Map<String, CartInfo> cart = (Map<String, CartInfo>) session.get("cart");
		CartInfo m = cart.get(mealId + "");
		m.setQuantity(quantity);
		return "success";
	}

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
