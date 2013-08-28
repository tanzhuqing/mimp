<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
        <p  align="center"><a href="login.jsp">用户登录</a>|用户注册</p> 
        <s:form action="registerAction" theme="simple"> 
            <table  align="center"> 
                <tr> 
                    <td style="text-align:right"> 
                        请输入账号 
                    </td> 
                    <td> 
                        <s:textfield name="user.name" label="账号" /> 
 
                    </td> 
                </tr> 
                <tr> 
                    <td style="text-align:right"> 
                        请输入密码 
                    </td> 
                    <td> 
                        <s:password name="user.pwd" label="密码" /> 
                    </td> 
                </tr> 
                <tr> 
                    <td style="text-align:right"> 
                        请再次输入密码 
                    </td> 
                    <td> 
                        <s:password name="repwd" label="重复密码" /> 
                    </td> 
                </tr> 
                <tr> 
                    <!--td style="text-align:right"> 
                        请输入验证码 
                    </td> 
                    <td> 
                        <s:textfield name="inputCertCode" label=" 验 证 码 " cssStyle="width:100px"/> 
                        <img src="other/makeCertPic.jsp"> 
                     </td> 
                 </tr> 
                         <tr--> 
                    <td style="text-align:right" > 
                        <s:submit value="注册"  /> 
                    </td> 
                    <td style="text-align:left"> 
                        <s:reset value="取消"/> 
                    </td> 
                </tr> 
            </table> 
        </s:form> 
        <s:fielderror cssStyle="color:red"/> 
    </body> 
                 
  </body>
</html>
