package com.dao;

import java.util.List;

import com.entity.Orderdts;
/**
 * 功能：订单明细相关的dao层接口
 * @author 胡伟
 * 时间：2017/8/20
 *
 */
public interface OrderdtsDao {
	// 添加订单详情
	public void addOrderdts(Orderdts orderdts);
	
	// 根据订单id查询订单信息
	public List<Orderdts> findByOid(int oid);
}
