<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>餐品列表显示</title>
		<link rel="stylesheet" href="/OMO-SYSTEM/css/styles.css" type="text/css" />
	</head>

	<body>
	<table width="95%" height="170" border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td width="200" height="101">
				<img src="images/jb_logo.jpg" width="64" height="32" />
				<strong><span style="font-size: 20px;">网上订餐系统</span> </strong>
			</td>
			<td width="640" style="padding-left: 40px;">
				
			</td>
		</tr>
		<tr>
			<td height="41" colspan="2" style="background-image:url(images/001.gif);" align="center">
				| <a href="/OMO-SYSTEM/showMeal">网站首页</a> |
				
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
		</tr>
		<tr>
			<td valign="top" align="center">
				<p>
					<img src="images/1555.jpg" width="200" height="70" /><br>
					<img src="images/003.gif" width="200" height="8"><br>
					<!-- 菜系循环开始 -->
					<s:iterator value="listMS">
						<br>
							<a href="ByParamMeal?meal.mealseries.seriesId=<s:property value="seriesId"/>">
							<s:property value="seriesName"/></a>
						<br>
					</s:iterator>
					<!-- 菜系循环结束 -->
			</td>
			<!-- 模糊查询开始 -->
			<td valign="top" width="80%">
				<img src="images/001(1).jpg" width="1010" height="70" /><br/>
				<div align="left" >
			      <s:form theme="simple" method="post" action="ByParamMeal">
	                <s:label value="输入菜名：" />
	        	    <s:textfield name="meal.mealName" />
					<s:submit value="查询" />						
				  </s:form>
				</div><br/>
			<!-- 模糊查询结束 -->
				<div style="background-image: url(images/004.gif)">&nbsp;
				</div>
				
				<div style="background-color: #FFCC99;" align="right">
				<a href="#"><img src="images/a.png" width="97" height="30" border="0" /> </a>
				</div><br/>
				
	<table cellpadding="5" cellspacing="1" style="font-size: 12px;">
	    <!-- 餐品循环开始 -->
		<s:iterator value="ListM" status="s">
		<!-- 每行展示3个就换行 -->
		<s:if test="#s.getIndex()%3==0">
			<tr>
		</s:if>
			
		<td><a href="#">
			<img src="mealimages/<s:property value="mealImage"/>" 
			width="148" height="126" border="0" /> 
		</a></td>
		<td>
			<div>
				<s:property value="mealId"/>:
				<s:property value="mealName"/><br/>
				<span style="text-decoration: line-through; color: gray;">
				原价：人民币<s:property value="mealPrice/0.5"/></span><br/>
				现价：人民币<s:property value="mealPrice"/>元
			</div>
			<a href="/OMO-SYSTEM/details?id=<s:property value="mealId"/>"><img src="images/detail_cn.gif" border="0" width="60" height="20" /></a>
			<a href="/OMO-SYSTEM/cart?mealId=<s:property value="mealId"/>"><img src="images/buy_cn.gif" border="0" width="60" height="20" /></a>
		</td>
		<!-- 不满3个也换行 -->
		<s:if test="#s.getIndex()%3==2">
			<tr>
		</s:if>
		</s:iterator>
		<!-- 餐品循环结束 -->
		<!-- 分页超链接开始 -->
		<table align="right">
		  <tr>
			<td width="130"></td>
			<td width="250">
			<!-- 查询所有的分页 -->
			<s:if test="status==1">
				<A href='showMeal.action?page=1'>首页</A>&nbsp;&nbsp;
				<A href='showMeal.action?page=<s:property value="page-1"/>'>上一页</A>
				<A href='showMeal.action?page=<s:property value="page+1"/>'>下一页</A>&nbsp;&nbsp;
				<A href='showMeal.action?page=<s:property value="totalPage"/>'>尾页</A>
			</s:if>
			<!-- 根据菜系筛选的分页 -->
			<s:if test="status==2">
					<A href='ByParamMeal?Page=1'>首页</A>&nbsp;&nbsp;
					<A href='ByParamMeal?Page=<s:property value="page-1"/>'>上一页</A>
					<A href='ByParamMeal?Page=<s:property value="page+1"/>'>下一页</A>&nbsp;&nbsp;
					<A href='ByParamMeal?Page=<s:property value="totalPage"/>'>尾页</A>
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
