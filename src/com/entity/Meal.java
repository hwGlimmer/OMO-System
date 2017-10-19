package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 功能：菜品信息实体类 
 * @author 胡伟
 * 时间：2017/8/20
 */
public class Meal implements java.io.Serializable {

	// Fields

	private Integer mealId;
	private Mealseries mealseries;//多对一 菜品系列
	private String mealName;//菜品名称
	private String mealSummarize;//菜品简介
	private String mealDescription;//菜品说明
	private Double mealPrice;//菜品价格
	private String mealImage;//菜品图片
	private Set<Orderdts> orderdtses = new HashSet<Orderdts>();//一对多

	// Constructors

	/** default constructor */
	public Meal() {
	}

	/** full constructor */
	public Meal(Mealseries mealseries, String mealName, String mealSummarize,
			String mealDescription, Double mealPrice, String mealImage,
			Set orderdtses) {
		this.mealseries = mealseries;
		this.mealName = mealName;
		this.mealSummarize = mealSummarize;
		this.mealDescription = mealDescription;
		this.mealPrice = mealPrice;
		this.mealImage = mealImage;
		this.orderdtses = orderdtses;
	}

	// Property accessors

	public Integer getMealId() {
		return this.mealId;
	}

	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}

	public Mealseries getMealseries() {
		return this.mealseries;
	}

	public void setMealseries(Mealseries mealseries) {
		this.mealseries = mealseries;
	}

	public String getMealName() {
		return this.mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public String getMealSummarize() {
		return this.mealSummarize;
	}

	public void setMealSummarize(String mealSummarize) {
		this.mealSummarize = mealSummarize;
	}

	public String getMealDescription() {
		return this.mealDescription;
	}

	public void setMealDescription(String mealDescription) {
		this.mealDescription = mealDescription;
	}

	public Double getMealPrice() {
		return this.mealPrice;
	}

	public void setMealPrice(Double mealPrice) {
		this.mealPrice = mealPrice;
	}

	public String getMealImage() {
		return this.mealImage;
	}

	public void setMealImage(String mealImage) {
		this.mealImage = mealImage;
	}

	public Set getOrderdtses() {
		return this.orderdtses;
	}

	public void setOrderdtses(Set orderdtses) {
		this.orderdtses = orderdtses;
	}

}