<%@ page language="java" contentType="text/html; charset=GBK" import="java.util.*" pageEncoding="GBK"%>
	<a href="modifyMyInfo.jsp">修改个人信息</a> |
	<a href="/OMO-SYSTEM/shopCart.jsp">我的购物车</a> |
	<a href="/OMO-SYSTEM/findOrdersByUserId">我的订单</a> |
	<a href="/OMO-SYSTEM/loginout?type=userlogout">注销</a> &nbsp;&nbsp; &nbsp;&nbsp;
	<font style="color: red">欢迎您：${sessionScope.user.loginName}</font>