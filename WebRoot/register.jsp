<%@ page language="java" contentType="text/html; charset=GBK" import="java.util.*" pageEncoding="GBK"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册页面</title>	
    <link rel="stylesheet" href="/OMO-SYSTEM/css/styles.css" type="text/css" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- 信息验证 -->
  <script type="text/javascript">
  function checkInfo(){
  		var tname = document.getElementById("trueName").value;
  		var tel = document.getElementById("tel").value;
  		var address = document.getElementById("address").value;
  		if (tname == "" || tname == null) {
  			alert("真实姓名不能为空");
  			return false;
  		}
  		if (tel == "" || tel == null) {
  			alert("电话不能为空");
  			return false;
  		}
  		if (address == "" || address == null) {
  			alert("地址不能为空");
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
				<strong><span style="font-size: 20px;">网上订餐系统</span> </strong>
				</td>
				
				<td width="640" style="padding-left: 40px;">
				</td>
			</tr>
			<tr>
				<td height="41" colspan="2"
					style="background-image:url(images/001.gif);" align="center">
					|<a href="/OMO-SYSTEM/showMeal">网站首页</a> |
					<!-- 如果不是注册用户也不是管理员进入普通首页 -->
					<%@ include file="../element/Vheader.jsp"%>
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
					<img src="images/001(1).jpg" width="980" height="70" /><br />
					
					<div style="background-image:url(images/004.gif)">&nbsp;
					</div>				    
                    
         <form action="register" method="post" name="frm" onsubmit="return checkInfo();">
				
				<table width="100%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #cccccc solid;">
				
				<tr style="background-color:#CCCCFF;">
					<td colspan="2">填写注册信息</td>
				</tr>
				<s:property value="session.message"/>
				<tr>
					<td align="right" style="width: 390px;" >登录名称：</td>
					
					<td align="left">
					<input type="text" name="users.loginName" style="width:220px;" />									
					</td>
				</tr>
				<tr>
					<td align="right" style="width:320px;">
						登录密码：
					</td>
					
					<td align="left">
						<input type="password" name="users.loginPwd" style="width:220px;" />									
					</td>
				</tr>							
				<tr>
					<td align="right" style="width:320px;">
						*真实姓名：
					</td>
					<td align="left">
						<input type="text" id="trueName" name="users.trueName" style="width:220px;" />									
					</td>
				</tr>						
				<tr>
					<td align="right" style="width:320px;">
						*电话号码：
					</td>
					
					<td align="left">
						<input type="text" id="tel" name="users.phone" style="width:220px;" />									
					</td>
				</tr>
				<tr>
					<td align="right" style="width:320px;">
						电子邮件：
					</td>
					<td align="left">
						<input type="text" name="users.email" style="width:220px;" />									
					</td>
				</tr>
				<tr>
					<td align="right" style="width:320px;">
						*默认地址：
					</td>
					<td align="left">
						<input type="text" id="address" name="users.address" style="width:220px;" />									
					</td>
				</tr>
				<tr><td colspan="2" align="center" style="color:red;">注：带*号为必填项,注册后即可享受购买商品送货上门服务！</td></tr>
				<tr style="background-color:#CCCCFF;">
					<td colspan="2">
						<input name="register" type="submit" id="register" value="注册" />
					</td>
				</tr>
				</table>
		</form>
				
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
