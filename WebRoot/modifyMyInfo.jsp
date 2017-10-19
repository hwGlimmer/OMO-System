<%@ page language="java" contentType="text/html; charset=GBK" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>修改个人信息</title>		
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
						style="font-size: 20px;">网上订餐系统</span> </strong>
				</td>
				<td width="640" style="padding-left: 40px;">
					
				</td>
			</tr>
			<tr>
				<td height="41" colspan="2"
					style="background-image:url(images/001.gif);" align="center">
					|<a href="/OMO-SYSTEM/showMeal">网站首页</a> |
					<!-- 首页 -->					
					<!-- 如果登陆的人是注册用户 ，进入注册用户界面-->
					<%@ include file="../element/Uheader.jsp"%>
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
					
					<div style="background-image:url(images/004.gif)">
						&nbsp;
					</div>				    
                    <form action="updateUser" method="post" name="frm"
						onsubmit="">
						<table width="100%" cellspacing="0" cellpadding="3" align="center"
							style="text-align:center; border:1px #cccccc solid;">
							<tr style="background-color:#CCCCFF;">
								<td colspan="2">
									用户个人信息
								</td>
							</tr>
							<tr>
								<td align="right" style="width: 384px;" >
									登录名称：
								</td>
								<td align="left">		
									<input type="text" name="users.loginName" style="width:220px;" value="${sessionScope.user.loginName}" />	
									<input type="hidden" name="users.id" style="width:220px;" value="${sessionScope.user.id}" />									
								</td>
							</tr>
							<tr>
								<td align="right" style="width:320px;">
									登录密码：
								</td>
								<td align="left">
									<input type="password" name="users.loginPwd" style="width:220px;" value="${sessionScope.user.loginPwd}"  />									
								</td>
							</tr>							
							<tr>
								<td align="right" style="width:320px;">
									真实姓名：
								</td>
								<td align="left">
									<input type="text" name="users.trueName" style="background:gray;width:220px;" value="${sessionScope.user.trueName}" readonly="readonly"/>									
								</td>
							</tr>						
							<tr>
								<td align="right" style="width:320px;">
									电话号码：
								</td>
								<td align="left">
									<input type="text" name="users.phone" style="width:220px;" value="${sessionScope.user.phone}"/>									
								</td>
							</tr>
							<tr>
								<td align="right" style="width:320px;">
									电子邮件：
								</td>
								<td align="left">
									<input type="text" name="users.email" style="width:220px;" value="${sessionScope.user.email}"  />									
								</td>
							</tr>
							<tr>
								<td align="right" style="width:320px;">
									默认地址：
								</td>
								<td align="left">
									<input type="text" name="users.address" style="width:220px;" value="${sessionScope.user.address}"  />									
								</td>
							</tr>
							<tr style="background-color:#CCCCFF;">
								<td colspan="2">
									<input type="submit" value="修改" />
								</td>
							</tr>
						</table>
					</form>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<br>
					<hr width=100%>
					<br>					
					<br>
					<br>
				</td>
			</tr>
		</table>
	</body>
</html>
