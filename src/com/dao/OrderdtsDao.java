package com.dao;

import java.util.List;

import com.entity.Orderdts;
/**
 * ���ܣ�������ϸ��ص�dao��ӿ�
 * @author ��ΰ
 * ʱ�䣺2017/8/20
 *
 */
public interface OrderdtsDao {
	// ��Ӷ�������
	public void addOrderdts(Orderdts orderdts);
	
	// ���ݶ���id��ѯ������Ϣ
	public List<Orderdts> findByOid(int oid);
}
