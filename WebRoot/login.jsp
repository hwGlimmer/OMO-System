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
    
    <title>��¼ҳ��</title>		
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
function checkUser() {//ʵ����֤�û�
		var name = document.getElementById("userName").value;
		var pwd = document.getElementById("userPwd").value;
		if(name==null || name==''){
		alert("�û�������Ϊ��");
		return false;
		}
		if(pwd==null || pwd==''){
		alert("���벻��Ϊ��");
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
						style="font-size: 20px;">���϶���ϵͳ</span> </strong>
				</td>
				<td width="640" style="padding-left: 40px;">					
				</td>
			</tr>
			<tr>
				<td height="41" colspan="2"
					style="background-image:url(images/001.gif);" align="center">
					|<a href="/OMO-SYSTEM/showMeal">��վ��ҳ</a> |
					
					<!-- �������ע���û�Ҳ���ǹ���Ա������ͨ��ҳ -->	
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
						���϶���ϵͳ�û���ֱ�ӵ�¼
					</div>
					<br><br/>
					
					<!-- �����½����ע���û�������û���¼���� -->
					<s:if test="#parameters.role[0]=='user'">
					<form action="login?type=userLogin" method="post" name="ufrm" onsubmit="return checkUser();">
					<table width="263" border="0" cellspacing="0" cellpadding="4"
					align="center">
						<tr>
							<td width="74" style="width: 103px; ">
								�û���½����
							</td>
							<td width="189">
								<input type="text" id="userName" name="loginName"  style="width:150;" />
							</td>
						</tr>
						<tr>
							<td>
								�� &nbsp;&nbsp;�룺
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
								<input type="submit" name="login" value="�� ¼" />
							</td>
						</tr>
					</table>
				</form>
					</s:if>
					<!-- �����½���ǹ���Ա��������Ա��¼���� -->
					<s:if test="#parameters.role[0]=='admin'">
					<form action="login?type=adminLogin" method="post" name="afrm" onsubmit="return checkUser();">
						<table width="263" border="0" cellspacing="0" cellpadding="4"
							align="center">
							<tr>
								<td align="center" width="80" style="width: 389px; ">
									����Ա��¼����
								</td>
								<td width="189">
									<input type="text" id="userName" name="loginName" style="width:150;" />
								</td>
							</tr>
							<tr>
								<td align="center">
									�� &nbsp; &nbsp;&nbsp;�룺
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
									<input type="submit" name="login" value="�� ¼" />
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
