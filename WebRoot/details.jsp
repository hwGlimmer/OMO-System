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
    
    <title>餐品详细页面</title> 
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
				<tr>
				<td width="200" height="101">
					<img src="images/jb_logo.jpg" width="64" height="32" />
					<strong><span
						style="font-size: 20px;">网上订餐系统</span> </strong>
				</td>
				<td width="640" style="padding-left: 40px;">
					
				</td>
			</tr>
			</tr>
			<tr>
				<td height="41" colspan="2"
					style="background-image:url(images/001.gif);" align="center">
					|<a href="/OMO-SYSTEM/showMeal">网站首页</a> |
				<!-- 如果不是注册用户也不是管理员进入普通首页 -->	
				<s:if test="(#session.user==null)&&(#session.admin==null)">			
				<%@ include file="../element/Vheader.jsp"%>
				</s:if>	
				
				<!-- 如果登陆的人是注册用户 ，进入注册用户界面-->
				<s:if test="#session.user!=null">	
				<%@ include file="../element/Uheader.jsp"%>
				</s:if>	
				
				<!-- 如果登陆的人是管理员 ，进入管理员界面-->
				<s:if test="#session.admin!=null">	
				<%@ include file="../element/Aheader.jsp"%>
				</s:if>	
				</td>
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
					<div style="background-image:url(images/004.gif)">
						&nbsp;
					</div>
					<div style="background-color:#FFCC99;" align="center">
						<b>餐品详情</b>
					</div>
					<br>
					<br />				
					
					<table width="616" border="1px" cellspacing="5" cellpadding="12" align="center" >
						<tr>
							<td width="148" align="center">
								<img alt="菜品" src="mealimages/<s:property value="meal.mealImage"/>" width="148" height="126" />
							</td>
							<td width="468" valign="top" style="margin:20px">
								<b>名称:</b><s:property value="meal.mealName"/>
								<br/><br/>
								<span style="text-decoration:line-through;color:gray;">
								<b>原价：人民币</b><s:property value="meal.mealPrice/0.5"/><b>元</b></span>
								<br/><br/>
								<b>现价：人民币</b><s:property value="meal.mealPrice"/><b>元</b>
								<br/><br/>
								<b>菜品描述:</b><s:property value="meal.mealDescription"/>
							</td>
							
						</tr>
						<tr>
							<td>
								编号：<s:property value="meal.mealId"/>
							</td>
							<td>
								<a href="/OMO-SYSTEM/cart?mealId=<s:property value="id"/>"><img src="images/buy_cn.gif" border="0" width="60" height="20" /></a>
							</td>
							
						</tr>
						<tr>
							
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<br>
					<hr width=100%>					
				</td>
			</tr>
		</table>
  </body>
</html>
