<%@ page language="java" contentType="text/html; charset=GBK" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>���ﳵҳ��</title>
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
				<td width="200" height="101">
					<img src="images/jb_logo.jpg" width="64" height="32" />
					<strong><span
						style="font-size: 20px;">���϶���ϵͳ</span> </strong>
				</td>
				<td width="640" style="padding-left: 40px;">
					
				</td>
			</tr>
			<tr>
				<td height="41" colspan="2"
					style="background-image:url(images/001.gif);" align="center">
					|
					<a href="/OMO-SYSTEM/showMeal">��վ��ҳ</a> |
					<!-- �����½������ע���û� ������ע���û�����-->
					<%@ include file="../element/Uheader.jsp"%>
				</td>
			</tr>
			<tr>
				<td valign="top" align="center" >
					<p>
						<img src="images/1555.jpg" width="200" height="70" />
						<br>
						<img src="images/003.gif" width="191" height="8">
				</td>
				<td valign="top" width="80%">
					<img src="images/001(1).jpg" width="980" height="70" />
					<br />					
					<div style="background-image:url(images/004.gif)">
						&nbsp;
					</div>
					
					<br />
					<img src="images/zdkf.jpg" align="top" />
					���Ĺ��ﳵ����������Ʒ
					<br />
					<hr />					
					<table align="center" width="95%" cellspacing="0" cellpadding="3"
						style="text-align:center; border:1px #cccccc solid;">
						<tr style="background-color:#CCCCFF;">
							<th>���</th>
							<th>��Ʒ����</th>
							<th>����</th>
							<th>����</th>
							<th>���</th>
							<th>ɾ��</th>
						</tr>	
						<s:set var="sumPrice" value="0"></s:set>
						
						<s:iterator value="#session.cart" status="s">		
						<tr <s:if test="#s.even">style="background-color:#CC3399"</s:if>>>						  
							<td>								
								<s:property value="value.meal.mealId"/>
							</td>
							<td>
								<s:property value="value.meal.mealName"/>
							</td>
							<td>
							          ��<s:property value="value.meal.mealPrice"/>
							</td>
							<td>								
								<input type="text" value="${value.quantity}" size="10"
								onchange="window.location='updateSelectedQuantity?mealId=${value.meal.mealId}&quantity='+this.value;">
							</td>
							<td>
								��<s:property value="value.meal.mealPrice*value.quantity"/>
								
							</td>
							<td>
								<a href="delCartById?mealId=<s:property value="value.meal.mealId"/>">ɾ��</a>							
							</td>
						</tr>	
						<s:set var="sumPrice" value="#sumPrice+value.quantity*value.meal.mealPrice"></s:set>
					</s:iterator>					
					<tr style="background-color:#CCCCFF;">
							<td>�ϼ�:</td>
							<td>-</td>
							<td>-</td>
							<td>-</td>
							<td>
								����<s:property value="#sumPrice"/>
								<s:set var="sumPrice" value="#sumPrice" scope="session"/>
							</td>
							<td>-</td>
						</tr>					
					</table>
					
					<br />
					<table width="300" cellspacing="0" cellpadding="4" align="center"
						style="text-align:center; border:1px #cccccc solid;">
						<tr style="background-color:#CCCCFF;">
							<td>
								<a href="clearCart">��չ��ﳵ</a>
							</td>
							<td>
								<a href="/OMO-SYSTEM/showMeal">��������</a>
							</td>
							<td>
								<a href="/OMO-SYSTEM/addOrders">���ɶ���</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<br>
					<hr width=100%>					
					<br>
				</td>
			</tr>
		</table>
	</body>
</html>
