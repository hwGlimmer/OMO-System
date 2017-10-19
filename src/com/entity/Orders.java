package com.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 功能：订单信息实体类 
 * @author 胡伟
 * 时间：2017/8/20
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer oid;
	private Users users;//多对一
	private Date orderTime;//订单时间
	private String orderState;//订单情况
	private Double orderPrice;//订单价格	

	private Set<Orderdts> orderdtses = new HashSet<Orderdts>();//一对多

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** full constructor */
	public Orders(Users users, Date orderTime, String orderState,
			Set orderdtses, Double orderPrice) {
		this.users = users;
		this.orderTime = orderTime;
		this.orderState = orderState;
		this.orderdtses = orderdtses;
		this.orderPrice = orderPrice;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Date getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderState() {
		return this.orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	
	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Set getOrderdtses() {
		return this.orderdtses;
	}

	public void setOrderdtses(Set orderdtses) {
		this.orderdtses = orderdtses;
	}

}