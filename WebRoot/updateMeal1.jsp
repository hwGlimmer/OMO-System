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
    
   <title>�޸Ĳ�Ʒ</title>
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
		<table width="90%" height="170" border="0" cellpadding="0"
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
					<!-- �����½�����ǹ���Ա ���������Ա����-->
					<%@ include file="../element/Aheader.jsp"%>
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
					<div style="background-image: url(images/004.gif)">
						&nbsp;
					</div>
					<div style="background-color: #FFCC99;" align="center">
						�޸Ĳ�Ʒ
					</div>
					<br />
					<form action="/OMO-SYSTEM/updateMeal" method="post" enctype="multipart/form-data">
						<table align="center">
						<s:textfield name="meal.mealName" label="����"/>
						<s:select name="meal.mealseries.seriesId" label="��ϵ"
						list="#request.MealseriesList" listKey="seriesId"
						listValue="seriesName"/>
						<s:textarea name="meal.mealSummarize" label="���"/>
						<s:textarea name="meal.mealDescription" label="˵��"/>
						<s:textfield name="meal.mealPrice" label="�۸�"/>
						<s:file name="doc" label="ͼƬ"/><br>
						<s:submit value="ȷ��" align="center"/>
						</table>
					</form>
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
