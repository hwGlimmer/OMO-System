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

<title>��������</title>
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
					style="font-size: 20px;">���϶���ϵͳ</span> </strong></td>
			<td width="640" style="padding-left: 40px;"></td>
		</tr>
		<tr>
			<td height="41" colspan="2"
				style="background-image:url(images/001.gif);" align="center">|<a
				href="/OMO-SYSTEM/showMeal">��վ��ҳ</a> | <!-- �����½�����ǹ���Ա ���������Ա����--> <%@ include file="../element/Aheader.jsp"%>
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
					<s:label value="����״̬��" />
					<s:select name="orders" list="{'δ����','����'}" headerKey="-1" headerValue="ȫ��"/>
					<s:label value="�����ţ�" />
	        	    <s:textfield name="meal.mealName" />
					<s:submit value="��ѯ" />		
					</s:form>
					</div>
					
					<div style="background-image:url(images/004.gif)">
						&nbsp;
					</div>					
					<br />
					<img src="images/icon_order.gif" align="top" />
					�����б�
					<br />
					<hr />
					<table align="center" width="95%" cellspacing="0" cellpadding="3"
						style="text-align:center; border:1px #cccccc solid;">
						<tr style="background-color:#FF6600;">
							<th>�������</th>
							<th>����ʱ��</th>
							<th>����״̬</th>
							<th>�ܶ�</th>
							<th>����</th>
						</tr>
					<!-- ����ѭ����ʼ -->	
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
								<s:if test="#myOrders.orderState=='δ����'">
								 <a href="/OMO-SYSTEM/updateOrder?ordersId=<s:property value="oid"/>"><img src="images/handle.gif" width="12" height="12" /></a>
								</s:if>
							</td>
						</tr>
						</s:iterator>
						<!-- ����ѭ������ -->	
						<table align="right">
	  <tr>
		<td width="130"></td>
		<!-- ��ѯ���еķ�ҳ -->
		<!-- ��ҳ�����ӿ�ʼ -->
		<%-- <s:if test="status==2"> --%>
		<td width="200">
				<A href='findAllOrders.action?page=1'>��ҳ</A>&nbsp;&nbsp;
				<A href='findAllOrders.action?page=<s:property value="page-1"/>'>��һҳ</A>
				<A href='findAllOrders.action?page=<s:property value="page+1"/>'>��һҳ</A>&nbsp;&nbsp;
				<A href='findAllOrders.action?page=<s:property value="totalPage"/>'>βҳ</A>
		</td>
	<%-- 	</s:if> --%>
		<%-- <!-- ���ݲ�ϵɸѡ�ķ�ҳ -->
		<s:if test="status==2">
				<A href='findOrdersByParam?Page=1'>��ҳ</A>&nbsp;&nbsp;
				<A href='findOrdersByParam?Page=<s:property value="page-1"/>'>��һҳ</A>
				<A href='findOrdersByParam?Page=<s:property value="page+1"/>'>��һҳ</A>&nbsp;&nbsp;
				<A href='findOrdersByParam?Page=<s:property value="totalPage"/>'>βҳ</A>
		</s:if> --%>
		<td>
		��<s:property value="totalNum"/>��¼,��<s:property value="page"/>/<s:property value="totalPage"/>ҳ &nbsp;&nbsp;
		</td>
	  </tr>
	</table>
						
<!-- ��ҳ�����ӽ���-->
						
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
