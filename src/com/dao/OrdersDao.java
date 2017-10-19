package com.dao;

import java.util.List;

import com.entity.Meal;
import com.entity.Orders;

/**
 * 功能：订单相关的dao层接口
 * 
 * @author 胡伟 时间：2017/8/20
 *
 */
public interface OrdersDao {
	// 根据用户id查询订单
	public List<Orders> findOrdersByUserID(int userId);

	// 查询订单总数
	public int findSumOrders();

	// 分页查询数据库中所有订单
	public List<Orders> findAllOrders(int page, int pageSize);
	
	// 根据条件查询订单信息(状态和搜索的订单号)
	public List<Orders> findOrdersByParam(int page, int pageSize, Orders orders);

	// 根据oid查询订单信息
	public Orders findOrdersByID(int ordersId);

	// 根据用户oid删除订单
	public boolean delOrdersById(Orders orders);

	// 修改订单（主要是管理员处理订单，更改状态）
	public boolean updateOrder(Orders orders);
}
