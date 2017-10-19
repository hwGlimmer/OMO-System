package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * ���ܣ���Ʒ��Ϣʵ���� 
 * @author ��ΰ
 * ʱ�䣺2017/8/20
 */
public class Meal implements java.io.Serializable {

	// Fields

	private Integer mealId;
	private Mealseries mealseries;//���һ ��Ʒϵ��
	private String mealName;//��Ʒ����
	private String mealSummarize;//��Ʒ���
	private String mealDescription;//��Ʒ˵��
	private Double mealPrice;//��Ʒ�۸�
	private String mealImage;//��ƷͼƬ
	private Set<Orderdts> orderdtses = new HashSet<Orderdts>();//һ�Զ�

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