package com.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ���ܣ�������Ϣʵ���� 
 * @author ��ΰ
 * ʱ�䣺2017/8/20
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer oid;
	private Users users;//���һ
	private Date orderTime;//����ʱ��
	private String orderState;//�������
	private Double orderPrice;//�����۸�	

	private Set<Orderdts> orderdtses = new HashSet<Orderdts>();//һ�Զ�

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