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
    
    <title>登录页面</title>		
		<link rel="stylesheet" href="/OMO-SYSTEM/css/styles.css" type="text/css" />	
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function checkUser() {//实现验证用户
		var name = document.getElementById("userName").value;
		var pwd = document.getElementById("userPwd").value;
		if(name==null || name==''){
		alert("用户名不能为空");
		return false;
		}
		if(pwd==null || pwd==''){
		alert("密码不能为空");
		return false;
		}
	}
</script>	
  </head>
  
  <body>
		<table width="90%" height="629" border="0" cellpadding="0" cellspacing="0" align="center">
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
					
					<!-- 如果不是注册用户也不是管理员进入普通首页 -->	
					<s:if test="(#session.user==null)&&(#session.admin==null)">			
						<%@ include file="../element/Vheader.jsp"%>
					</s:if>	
				</td>
			</tr>
			<tr>
				<td valign="top">
					<p>
						<img src="images/1555.jpg" width="200" height="70" />					
				</td>
				<td valign="top" width="80%">
					<img src="images/001(1).jpg" width="980" height="70" />
					<br />
					
					<div style="background-image:url(images/004.gif)">
						&nbsp;
					</div>
					<div style="background-color:#FFCC99;" align="center">
						网上订餐系统用户请直接登录
					</div>
					<br><br/>
					
					<!-- 如果登陆的是注册用户则进入用户登录界面 -->
					<s:if test="#parameters.role[0]=='user'">
					<form action="login?type=userLogin" method="post" name="ufrm" onsubmit="return checkUser();">
					<table width="263" border="0" cellspacing="0" cellpadding="4"
					align="center">
						<tr>
							<td width="74" style="width: 103px; ">
								用户登陆名：
							</td>
							<td width="189">
								<input type="text" id="userName" name="loginName"  style="width:150;" />
							</td>
						</tr>
						<tr>
							<td>
								密 &nbsp;&nbsp;码：
							</td>
							<td>
								<input type="password" id="userPwd" name="loginPwd" style="width:150;" />
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;
							</td>
							<td>
								<input type="submit" name="login" value="登 录" />
							</td>
						</tr>
					</table>
				</form>
					</s:if>
					<!-- 如果登陆的是管理员则进入管理员登录界面 -->
					<s:if test="#parameters.role[0]=='admin'">
					<form action="login?type=adminLogin" method="post" name="afrm" onsubmit="return checkUser();">
						<table width="263" border="0" cellspacing="0" cellpadding="4"
							align="center">
							<tr>
								<td align="center" width="80" style="width: 389px; ">
									管理员登录名：
								</td>
								<td width="189">
									<input type="text" id="userName" name="loginName" style="width:150;" />
								</td>
							</tr>
							<tr>
								<td align="center">
									密 &nbsp; &nbsp;&nbsp;码：
								</td>
								<td>
									<input type="password" id="userPwd" name="loginPwd" style="width:150;" />
								</td>
							</tr>
							<tr>
								<td>
									&nbsp;
								</td>
								<td>
									<input type="submit" name="login" value="登 录" />
								</td>
							</tr>
							
							<tr>
								<td colspan="2">
									
								</td>
							</tr>
							
						</table>
					</form>					
					</s:if>					
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
