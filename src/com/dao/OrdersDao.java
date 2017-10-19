package com.dao;

import java.util.List;

import com.entity.Meal;
import com.entity.Orders;

/**
 * ���ܣ�������ص�dao��ӿ�
 * 
 * @author ��ΰ ʱ�䣺2017/8/20
 *
 */
public interface OrdersDao {
	// �����û�id��ѯ����
	public List<Orders> findOrdersByUserID(int userId);

	// ��ѯ��������
	public int findSumOrders();

	// ��ҳ��ѯ���ݿ������ж���
	public List<Orders> findAllOrders(int page, int pageSize);
	
	// ����������ѯ������Ϣ(״̬�������Ķ�����)
	public List<Orders> findOrdersByParam(int page, int pageSize, Orders orders);

	// ����oid��ѯ������Ϣ
	public Orders findOrdersByID(int ordersId);

	// �����û�oidɾ������
	public boolean delOrdersById(Orders orders);

	// �޸Ķ�������Ҫ�ǹ���Ա������������״̬��
	public boolean updateOrder(Orders orders);
}
