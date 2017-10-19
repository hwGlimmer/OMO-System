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
    
	<title>管理餐品</title>
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
		<table width="95%" height="170" border="0" cellpadding="0"
			cellspacing="0" align="center">
			<tr>
				<td width="200" height="101">
					<img src="images/jb_logo.jpg" width="64" height="32" />
					<strong><span
						style="font-size: 20px;">网上订餐系统</span> </strong>
				</td>
				<td width="640" style="padding-left: 40px;">
					
				</td>
			</tr>
			<tr>
				<td height="41" colspan="2"
					style="background-image:url(images/001.gif);" align="center">
					|<a href="/OMO-SYSTEM/showMeal">网站首页</a> |
					<!-- 如果登陆的人是管理员 ，进入管理员界面-->
					<%@ include file="../element/Aheader.jsp"%>
				</td>
			</tr>
			<tr>
				<td valign="top" align="center">
					<p>
						<img src="images/1555.jpg" width="200" height="70" />
						<br>
						<img src="images/003.gif" width="200" height="8">
					<!-- 菜系循环开始 -->
					<s:iterator value="listMSS"> <br>
						<a href="ByParamMeal1?meal.mealseries.seriesId=<s:property value="seriesId"/>">
						<s:property value="seriesName"/></a>
						<br>
					</s:iterator>
					<!-- 菜系循环结束 -->
			</td>
			<!-- 模糊查询开始 -->
			<td valign="top" width="80%">
				<img src="images/001(1).jpg" width="1010" height="70" /><br/>
				<div align="left" >
			      <s:form theme="simple" method="post" action="ByParamMeal1">
	                <s:label value="输入菜名：" />
	        	    <s:textfield name="meal.mealName" />
					<s:submit value="查询" />						
				  </s:form>
				</div><br/>
			<!-- 模糊查询结束 -->
					<div style="background-image: url(images/004.gif)">
						&nbsp;
					</div>
					<br><br>
					<table width="95%" cellspacing="0" cellpadding="4" align="center"
						style="text-align:center; border:1px #cccccc solid;">
						<tr style="background-color:#FF6600;">
							<th>菜系</th>
							<th>菜名</th>
							<th>摘要</th>
							<th>价格</th>
							<th>修改</th>
							<th>删除</th>
						</tr>	
						<!-- 菜品循环开始 -->	
						<s:iterator value="ListMM" status="s">			
						<tr <s:if test="#s.even">style="background-color:#CC3399"</s:if>>					
							<td>
								<b><s:property value="mealseries.seriesName"/></b>
							</td>
							<td>
								<s:property value="mealName"/>
							</td>
							<td>
								<s:property value="mealSummarize"/>
							</td>
							<td>
								<s:property value="mealPrice"/>
							</td>	
							<td>
							    <a href="/OMO-SYSTEM/findMealById?id=<s:property value="mealId"/>">修改</a>								
							</td>	
							<td>
								<a href="/OMO-SYSTEM/delMeal?mealId=<s:property value="mealId"/>">删除</a>
							</td>				
						</tr>		
						</s:iterator>
						<!-- 分页超链接开始 -->
						<table align="right">
	  <tr>
		<td width="130"></td>
			<td width="200">
			<!-- 查询所有的分页 -->
			<s:if test="status==1">
				<A href='ManagerMeal?Page=1'>首页</A>&nbsp;&nbsp;
					<A href='ManagerMeal?Page=<s:property value="page-1"/>'>上一页</A>
					<A href='ManagerMeal?Page=<s:property value="page+1"/>'>下一页</A>&nbsp;&nbsp;
					<A href='ManagerMeal?Page=<s:property value="totalPage"/>'>尾页</A>
			</s:if>
			<!-- 根据菜系筛选的分页 -->
			<s:if test="status==2">
					<A href='ManagerMeal?Page=1'>首页</A>&nbsp;&nbsp;
					<A href='ManagerMeal?Page=<s:property value="page-1"/>'>上一页</A>
					<A href='ManagerMeal?Page=<s:property value="page+1"/>'>下一页</A>&nbsp;&nbsp;
					<A href='ManagerMeal?Page=<s:property value="totalPage"/>'>尾页</A>
			</s:if>
			</td>
			<td>
				共<s:property value="totalNum"/>记录,共<s:property value="page"/>/<s:property value="totalPage"/>页 &nbsp;&nbsp;
			</td>
	  </tr>
	</table>
						<!-- 分页超链接结束-->
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
