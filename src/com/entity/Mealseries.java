package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * ���ܣ���ϵ��Ϣʵ���� 
 * @author ��ΰ
 * ʱ�䣺2017/8/20
 */
public class Mealseries implements java.io.Serializable {

	// Fields

	private Integer seriesId;//��ϵID
	private String seriesName;//��ϵ����
	private Set<Meal> meals = new HashSet<Meal>();//һ�Զ�

	// Constructors

	/** default constructor */
	public Mealseries() {
	}

	/** full constructor */
	public Mealseries(String seriesName, Set meals) {
		this.seriesName = seriesName;
		this.meals = meals;
	}

	// Property accessors

	public Integer getSeriesId() {
		return this.seriesId;
	}

	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}

	public String getSeriesName() {
		return this.seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public Set getMeals() {
		return this.meals;
	}

	public void setMeals(Set meals) {
		this.meals = meals;
	}

}