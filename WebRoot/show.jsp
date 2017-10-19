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
		<title>��Ʒ�б���ʾ</title>
		<link rel="stylesheet" href="/OMO-SYSTEM/css/styles.css" type="text/css" />
	</head>

	<body>
	<table width="95%" height="170" border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td width="200" height="101">
				<img src="images/jb_logo.jpg" width="64" height="32" />
				<strong><span style="font-size: 20px;">���϶���ϵͳ</span> </strong>
			</td>
			<td width="640" style="padding-left: 40px;">
				
			</td>
		</tr>
		<tr>
			<td height="41" colspan="2" style="background-image:url(images/001.gif);" align="center">
				| <a href="/OMO-SYSTEM/showMeal">��վ��ҳ</a> |
				
				<!-- �������ע���û�Ҳ���ǹ���Ա������ͨ��ҳ -->	
				<s:if test="(#session.user==null)&&(#session.admin==null)">			
				<%@ include file="../element/Vheader.jsp"%>
				</s:if>	
				
				<!-- �����½������ע���û� ������ע���û�����-->
				<s:if test="#session.user!=null">	
				<%@ include file="../element/Uheader.jsp"%>
				</s:if>	
				
				<!-- �����½�����ǹ���Ա ���������Ա����-->
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
					<!-- ��ϵѭ����ʼ -->
					<s:iterator value="listMS">
						<br>
							<a href="ByParamMeal?meal.mealseries.seriesId=<s:property value="seriesId"/>">
							<s:property value="seriesName"/></a>
						<br>
					</s:iterator>
					<!-- ��ϵѭ������ -->
			</td>
			<!-- ģ����ѯ��ʼ -->
			<td valign="top" width="80%">
				<img src="images/001(1).jpg" width="1010" height="70" /><br/>
				<div align="left" >
			      <s:form theme="simple" method="post" action="ByParamMeal">
	                <s:label value="���������" />
	        	    <s:textfield name="meal.mealName" />
					<s:submit value="��ѯ" />						
				  </s:form>
				</div><br/>
			<!-- ģ����ѯ���� -->
				<div style="background-image: url(images/004.gif)">&nbsp;
				</div>
				
				<div style="background-color: #FFCC99;" align="right">
				<a href="#"><img src="images/a.png" width="97" height="30" border="0" /> </a>
				</div><br/>
				
	<table cellpadding="5" cellspacing="1" style="font-size: 12px;">
	    <!-- ��Ʒѭ����ʼ -->
		<s:iterator value="ListM" status="s">
		<!-- ÿ��չʾ3���ͻ��� -->
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
				ԭ�ۣ������<s:property value="mealPrice/0.5"/></span><br/>
				�ּۣ������<s:property value="mealPrice"/>Ԫ
			</div>
			<a href="/OMO-SYSTEM/details?id=<s:property value="mealId"/>"><img src="images/detail_cn.gif" border="0" width="60" height="20" /></a>
			<a href="/OMO-SYSTEM/cart?mealId=<s:property value="mealId"/>"><img src="images/buy_cn.gif" border="0" width="60" height="20" /></a>
		</td>
		<!-- ����3��Ҳ���� -->
		<s:if test="#s.getIndex()%3==2">
			<tr>
		</s:if>
		</s:iterator>
		<!-- ��Ʒѭ������ -->
		<!-- ��ҳ�����ӿ�ʼ -->
		<table align="right">
		  <tr>
			<td width="130"></td>
			<td width="250">
			<!-- ��ѯ���еķ�ҳ -->
			<s:if test="status==1">
				<A href='showMeal.action?page=1'>��ҳ</A>&nbsp;&nbsp;
				<A href='showMeal.action?page=<s:property value="page-1"/>'>��һҳ</A>
				<A href='showMeal.action?page=<s:property value="page+1"/>'>��һҳ</A>&nbsp;&nbsp;
				<A href='showMeal.action?page=<s:property value="totalPage"/>'>βҳ</A>
			</s:if>
			<!-- ���ݲ�ϵɸѡ�ķ�ҳ -->
			<s:if test="status==2">
					<A href='ByParamMeal?Page=1'>��ҳ</A>&nbsp;&nbsp;
					<A href='ByParamMeal?Page=<s:property value="page-1"/>'>��һҳ</A>
					<A href='ByParamMeal?Page=<s:property value="page+1"/>'>��һҳ</A>&nbsp;&nbsp;
					<A href='ByParamMeal?Page=<s:property value="totalPage"/>'>βҳ</A>
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
