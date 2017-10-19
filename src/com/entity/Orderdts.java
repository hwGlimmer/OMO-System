package com.entity;

/**
 * 功能：订单明细实体类 
 * @author 胡伟
 * 时间：2017/8/20
 */

public class Orderdts implements java.io.Serializable {

	// Fields

	private Integer odid;
	private Meal meal;//多对一 菜品
	private Orders orders;//多对一  订单
	private Double mealPrice;//菜品价格
	private Integer mealCount;//菜品总数

	// Constructors

	/** default constructor */
	public Orderdts() {
	}

	/** full constructor */
	public Orderdts(Meal meal, Orders orders, Double mealPrice,
			Integer mealCount) {
		this.meal = meal;
		this.orders = orders;
		this.mealPrice = mealPrice;
		this.mealCount = mealCount;
	}

	// Property accessors

	public Integer getOdid() {
		return this.odid;
	}

	public void setOdid(Integer odid) {
		this.odid = odid;
	}

	public Meal getMeal() {
		return this.meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Double getMealPrice() {
		return this.mealPrice;
	}

	public void setMealPrice(Double mealPrice) {
		this.mealPrice = mealPrice;
	}

	public Integer getMealCount() {
		return this.mealCount;
	}

	public void setMealCount(Integer mealCount) {
		this.mealCount = mealCount;
	}

}