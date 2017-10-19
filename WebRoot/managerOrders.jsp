<%@ page language="java" contentType="text/html; charset=GBK"
	import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>订单处理</title>
<link rel="stylesheet" href="/OMO-SYSTEM/css/styles.css" type="text/css" />

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<table width="90%" height="629" border="0" cellpadding="0"
		cellspacing="0" align="center">
		<tr>
			<td width="200" height="101"><img src="images/jb_logo.jpg"
				width="64" height="32" /> <strong><span
					style="font-size: 20px;">网上订餐系统</span> </strong></td>
			<td width="640" style="padding-left: 40px;"></td>
		</tr>
		<tr>
			<td height="41" colspan="2"
				style="background-image:url(images/001.gif);" align="center">|<a
				href="/OMO-SYSTEM/showMeal">网站首页</a> | <!-- 如果登陆的人是管理员 ，进入管理员界面--> <%@ include file="../element/Aheader.jsp"%>
				</td>
			</tr>
			<tr>
				<td valign="top" align="center">
					<p>
						<img src="images/1555.jpg" width="200" height="70" />
						<br>
						<img src="images/003.gif" width="191" height="8">
				</td>
				<td valign="top" width="80%">
					<img src="images/001(1).jpg" width="980" height="70" />
					<br />
					<div align="left">
					<s:form theme="simple" method="post" action="findOrdersByParam">
					<s:label value="订单状态：" />
					<s:select name="orders" list="{'未处理','处理'}" headerKey="-1" headerValue="全部"/>
					<s:label value="订单号：" />
	        	    <s:textfield name="meal.mealName" />
					<s:submit value="查询" />		
					</s:form>
					</div>
					
					<div style="background-image:url(images/004.gif)">
						&nbsp;
					</div>					
					<br />
					<img src="images/icon_order.gif" align="top" />
					订单列表
					<br />
					<hr />
					<table align="center" width="95%" cellspacing="0" cellpadding="3"
						style="text-align:center; border:1px #cccccc solid;">
						<tr style="background-color:#FF6600;">
							<th>订单编号</th>
							<th>订单时间</th>
							<th>订单状态</th>
							<th>总额</th>
							<th>处理</th>
						</tr>
					<!-- 订单循环开始 -->	
					<s:iterator  id="myOrders" value="ListAllOd" status="s">		
						<tr <s:if test="#s.even">style="background-color:#CC3399"</s:if>>						  
							<td>								
								<s:property value="oid"/>
							</td>
							<td>								
								<s:date name="orderTime" format="yyyy-MM-dd HH:mm:ss"/>
							</td>
							<td>
								<s:property value="orderState"/>
							</td>
							<td>
								<s:property value="orderPrice"/>
							</td>							
							<td>
								<s:if test="#myOrders.orderState=='未处理'">
								 <a href="/OMO-SYSTEM/updateOrder?ordersId=<s:property value="oid"/>"><img src="images/handle.gif" width="12" height="12" /></a>
								</s:if>
							</td>
						</tr>
						</s:iterator>
						<!-- 订单循环结束 -->	
						<table align="right">
	  <tr>
		<td width="130"></td>
		<!-- 查询所有的分页 -->
		<!-- 分页超链接开始 -->
		<%-- <s:if test="status==2"> --%>
		<td width="200">
				<A href='findAllOrders.action?page=1'>首页</A>&nbsp;&nbsp;
				<A href='findAllOrders.action?page=<s:property value="page-1"/>'>上一页</A>
				<A href='findAllOrders.action?page=<s:property value="page+1"/>'>下一页</A>&nbsp;&nbsp;
				<A href='findAllOrders.action?page=<s:property value="totalPage"/>'>尾页</A>
		</td>
	<%-- 	</s:if> --%>
		<%-- <!-- 根据菜系筛选的分页 -->
		<s:if test="status==2">
				<A href='findOrdersByParam?Page=1'>首页</A>&nbsp;&nbsp;
				<A href='findOrdersByParam?Page=<s:property value="page-1"/>'>上一页</A>
				<A href='findOrdersByParam?Page=<s:property value="page+1"/>'>下一页</A>&nbsp;&nbsp;
				<A href='findOrdersByParam?Page=<s:property value="totalPage"/>'>尾页</A>
		</s:if> --%>
		<td>
		共<s:property value="totalNum"/>记录,共<s:property value="page"/>/<s:property value="totalPage"/>页 &nbsp;&nbsp;
		</td>
	  </tr>
	</table>
						
<!-- 分页超链接结束-->
						
					</table>
					<br />
					
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<br>
					<hr width=100%>
					<br>	
					<br>
				</td>
			</tr>
		</table>
</body>
</html>
