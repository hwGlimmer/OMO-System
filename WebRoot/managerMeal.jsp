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
    
	<title>�����Ʒ</title>
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
						style="font-size: 20px;">���϶���ϵͳ</span> </strong>
				</td>
				<td width="640" style="padding-left: 40px;">
					
				</td>
			</tr>
			<tr>
				<td height="41" colspan="2"
					style="background-image:url(images/001.gif);" align="center">
					|<a href="/OMO-SYSTEM/showMeal">��վ��ҳ</a> |
					<!-- �����½�����ǹ���Ա ���������Ա����-->
					<%@ include file="../element/Aheader.jsp"%>
				</td>
			</tr>
			<tr>
				<td valign="top" align="center">
					<p>
						<img src="images/1555.jpg" width="200" height="70" />
						<br>
						<img src="images/003.gif" width="200" height="8">
					<!-- ��ϵѭ����ʼ -->
					<s:iterator value="listMSS"> <br>
						<a href="ByParamMeal1?meal.mealseries.seriesId=<s:property value="seriesId"/>">
						<s:property value="seriesName"/></a>
						<br>
					</s:iterator>
					<!-- ��ϵѭ������ -->
			</td>
			<!-- ģ����ѯ��ʼ -->
			<td valign="top" width="80%">
				<img src="images/001(1).jpg" width="1010" height="70" /><br/>
				<div align="left" >
			      <s:form theme="simple" method="post" action="ByParamMeal1">
	                <s:label value="���������" />
	        	    <s:textfield name="meal.mealName" />
					<s:submit value="��ѯ" />						
				  </s:form>
				</div><br/>
			<!-- ģ����ѯ���� -->
					<div style="background-image: url(images/004.gif)">
						&nbsp;
					</div>
					<br><br>
					<table width="95%" cellspacing="0" cellpadding="4" align="center"
						style="text-align:center; border:1px #cccccc solid;">
						<tr style="background-color:#FF6600;">
							<th>��ϵ</th>
							<th>����</th>
							<th>ժҪ</th>
							<th>�۸�</th>
							<th>�޸�</th>
							<th>ɾ��</th>
						</tr>	
						<!-- ��Ʒѭ����ʼ -->	
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
							    <a href="/OMO-SYSTEM/findMealById?id=<s:property value="mealId"/>">�޸�</a>								
							</td>	
							<td>
								<a href="/OMO-SYSTEM/delMeal?mealId=<s:property value="mealId"/>">ɾ��</a>
							</td>				
						</tr>		
						</s:iterator>
						<!-- ��ҳ�����ӿ�ʼ -->
						<table align="right">
	  <tr>
		<td width="130"></td>
			<td width="200">
			<!-- ��ѯ���еķ�ҳ -->
			<s:if test="status==1">
				<A href='ManagerMeal?Page=1'>��ҳ</A>&nbsp;&nbsp;
					<A href='ManagerMeal?Page=<s:property value="page-1"/>'>��һҳ</A>
					<A href='ManagerMeal?Page=<s:property value="page+1"/>'>��һҳ</A>&nbsp;&nbsp;
					<A href='ManagerMeal?Page=<s:property value="totalPage"/>'>βҳ</A>
			</s:if>
			<!-- ���ݲ�ϵɸѡ�ķ�ҳ -->
			<s:if test="status==2">
					<A href='ManagerMeal?Page=1'>��ҳ</A>&nbsp;&nbsp;
					<A href='ManagerMeal?Page=<s:property value="page-1"/>'>��һҳ</A>
					<A href='ManagerMeal?Page=<s:property value="page+1"/>'>��һҳ</A>&nbsp;&nbsp;
					<A href='ManagerMeal?Page=<s:property value="totalPage"/>'>βҳ</A>
			</s:if>
			</td>
			<td>
				��<s:property value="totalNum"/>��¼,��<s:property value="page"/>/<s:property value="totalPage"/>ҳ &nbsp;&nbsp;
			</td>
	  </tr>
	</table>
						<!-- ��ҳ�����ӽ���-->
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
