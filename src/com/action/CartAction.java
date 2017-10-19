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

	// 添加购物车信息
	public String addCart() {
		// session中查询购物车
		Map<String, CartInfo> cart = (Map<String, CartInfo>) session.get("cart");
		// 根据菜品id查询菜品信息
		Meal meal = mealDao.findById(mealId);
		// session中沒有购物车时，添加购物车
		if (cart == null) {
			cart = new HashMap<String, CartInfo>();
			session.put("cart", cart);
		}
		// 根据菜品id获取购物车里的菜品信息
		CartInfo m = cart.get(mealId + "");
		// 如果购物车里没有此菜品，添加菜品
		if (m == null) {
			m = new CartInfo(1, meal);
			cart.put(mealId + "", m);
		} else {
			m.setQuantity(m.getQuantity() + 1);
			cart.put(mealId + "", m);
		}
		return "success";
	}

	// 删除购物车指定菜品
	public String delCartById() {

		Map<String, CartInfo> cart = (Map<String, CartInfo>) session.get("cart");
		cart.remove(mealId + "");

		return "success";
	}

	// 清空物车
	public String clearCart() {

		session.clear();

		return "success";
	}

	// 修改购物车餐品中数量，实时更新数量
	public String updateSelectedQuantity() {
		// 获取购物车查询
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
