package com.entity;

import java.io.Serializable;

public class CartInfo implements Serializable {
	private Integer quantity;//ĳ��Ʒ���빺�ﳵ����
	private Meal meal;
	
	public CartInfo() {
		super();
	}
	public CartInfo(Integer quantity, Meal meal) {
		super();
		this.quantity = quantity;
		this.meal = meal;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Meal getMeal() {
		return meal;
	}
	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	
}
