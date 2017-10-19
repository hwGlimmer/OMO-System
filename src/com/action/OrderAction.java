package com.action;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.dao.OrderdtsDao;
import com.dao.OrdersDao;
import com.entity.CartInfo;
import com.entity.Orderdts;
import com.entity.Orders;
import com.entity.Users;
@Controller
public class OrderAction implements SessionAware,RequestAware{
	Map<String, Object> session;
	Map<String, Object> request;
	private int ordersId;
	private int oid;
	
	private int totalPage;
	private int page;
	private int pageSize;
	private int totalNum;
	
	private int status = 0;
	private Orders orders;
	
	List<Orders> ListAllOd;
	
	// 注入OrderdtsDao
	@Resource
	private OrderdtsDao orderdtsDao;
	@Resource
	private OrdersDao ordersDao;
	// 获取session
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
		
	}

	// 添加订单及详情信息
	public String addOrders(){
		Orders orders = new Orders();
		orders.setOrderState("未处理");
		orders.setOrderTime(new Date());
		orders.setUsers((Users)session.get("user"));
		orders.setOrderPrice((Double)session.get("sumPrice"));
		Map<String,CartInfo> cart = (Map<String,CartInfo>)session.get("cart");
		Iterator it = cart.keySet().iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			CartInfo ci = cart.get(key);
			Orderdts orderdts = new Orderdts();
			orderdts.setMeal(ci.getMeal());
			orderdts.setMealPrice(ci.getMeal().getMealPrice());
			orderdts.setOrders(orders);
			orderdts.setMealCount(ci.getQuantity());
			orderdtsDao.addOrderdts(orderdts);
		}
		session.remove("cart");
		return "success";
	}
	//根据userid查询出订单信息
	public String findOrdersByUserId(){
		Users u = (Users)session.get("user");
		List<Orders> listo = ordersDao.findOrdersByUserID(u.getId());
		request.put("ordersList", listo);
		
		System.out.println("OrderAction里的listo:"+listo);
		
		return "success";
	}
	// 根据oid删除订单信息(用户后悔时，可删除未处理的订单)
	public String deleteOrders(){
		Orders orders = ordersDao.findOrdersByID(ordersId);
		ordersDao.delOrdersById(orders);
		return "success";
	}
	// 修改订单（主要是管理员处理订单，更改状态）
	public String updateOrder(){
		Orders orders = ordersDao.findOrdersByID(ordersId);
		orders.setOrderState("已处理");
		ordersDao.updateOrder(orders);
		return "success";
	}
	// 根据oid查看订单明细
	public String MyOrdersDetails(){
		List<Orderdts> listodt = orderdtsDao.findByOid(oid);
		request.put("orderdtsList", listodt);
		return "success";
	}
	// 分页查询出所有订单
	public String findAllOrders(){
		status = 1;
		orders = null;
		totalNum = ordersDao.findSumOrders();
		if(totalNum%pageSize==0){
			totalPage = totalNum/pageSize;
		}else{
			totalPage = totalNum/pageSize+1;
		}
		if(page<1){
			page=1;
		}else if(page>totalPage){
			page = totalPage;
		}
		ListAllOd = ordersDao.findAllOrders(page, pageSize);
		
		for(Orders i:ListAllOd){
			System.out.println("OrderAction"+i.toString());
		}
		
		return "success";
	}
	
	// 根据条件查询订单信息(状态和搜索的订单号)
	public String findOrdersByParam(){
		status = 2;
		totalNum = ordersDao.findSumOrders();
		if(totalNum%pageSize==0){
			totalPage = totalNum/pageSize;
		}else{
			totalPage = totalNum/pageSize+1;
		}
		if(page<1){
			page=1;
		}else if(page>totalPage){
			page = totalPage;
		}
		ListAllOd = ordersDao.findOrdersByParam(page, pageSize, orders);
		System.out.println("OrderAction"+ListAllOd.get(0).getOid());
		return "success";
	}
	
	
	public int getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public List<Orders> getListAllOd() {
		return ListAllOd;
	}
	public void setListAllOd(List<Orders> listAllOd) {
		ListAllOd = listAllOd;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}

}
