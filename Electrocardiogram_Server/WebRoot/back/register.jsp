<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<script language="javascript">
		function check(form){
			if (form.name.value==""){
				alert("请输入管理员名称!");form.name.focus();return false;
			}
			if (form.password.value==""){
				alert("请输入管理员密码!");form.pwd.focus();return false;
			}	
		}
		</script>
		<link href="css/StyleSheet.css" rel="stylesheet" type="text/css" />
		
  </head>
  
  <body>
    <br />
		<br />
		<br />
		<br />
		<form id="form" name="form" method="post"
			action="operatorUtil.do?method=operatorLogin">
			<table align="center" width="600" border="0" cellpadding="8"
				cellspacing="0" class="logintable">
				<tr class="loginheader">
					<td width="80"></td>
					<td width="100"></td>
					<td colspan="2"></td>
					<td width="120"></td>
					<td width="80"></td>
				</tr>
				<tr style="height: 40px">
					<td>
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
					<td colspan="4" class="line1">
						<span class="STYLE1" >用户注册页面</span>
					</td>
					<td>
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td class="line2">
						&nbsp;
					</td>
					<td colspan="2" class="line2">
						&nbsp;
					</td>
					<td class="line2">
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td colspan="2">
						
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td align="right">
						用户名:
					</td>
					<td colspan="2">
						<input type="text" name="name" />
					</td>
					<td></td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td style="height: 32px">
						&nbsp;
					</td>
					<td align="right" style="height: 32px">
						密 码:
					</td>
					<td colspan="2" style="height: 32px">
						<input type="password" name="password" />
					</td>
					<td style="height: 32px">
						&nbsp;
					</td>
					<td style="height: 32px">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td style="height: 29px">
						&nbsp;
					</td>
					<td align="right" class="line1" style="height: 29px">
						&nbsp;
					</td>
					<td class="line1" style="width: 71px; height: 29px;">
					</td>
					<td class="line1" style="height: 29px">
					</td>
					<td class="line1" style="height: 29px; font-size: 12px"></td>
					<td style="height: 29px">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td class="line2">
						&nbsp;
					</td>
					<td colspan="2" class="line2">
						<div align="center">
							&nbsp;
							<input type="submit" width="20" name="Submit" value="注册"
								onClick="return check(form)" />
							&nbsp;
							<input type="reset" name="Submit2" value="重置" />
						</div>
					</td>
					<td class="line2">
					
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
					<td colspan="2">
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
  </body>
</html>
