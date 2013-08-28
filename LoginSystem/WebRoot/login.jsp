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
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="styles.css">
	 <link rel="stylesheet" type="text/css" href="../css/ext-all.css" />

    <script type="text/javascript" src="../javascript/ext-base.js"></script>

    <script type="text/javascript" src="../javascript/ext-all-debug.js"></script>

    <!-- script type="text/javascript" src="../javascript/ext-lang-zh_CN.js"></script-->

    <script type="text/javascript" src="javascript/CheckCode.js"></script>

    <script type="text/javascript" src="javascript/fullScreen.js"></script>

    <script type="text/javascript" src="javascript/Login.js"></script>
	
	

  </head>
   
   
      
        <p  align="center"><a href="register.jsp">用户注册</a>|用户登录</p> 
                <s:form action="loginAction" theme="simple"> 
            <table  align="center"> 
                <tr> 
                    <td style="text-align:right"> 
                        账号 
                    </td> 
                    <td> 
                        <s:textfield name="name" label="账号" /> 
 
                    </td> 
                                    </tr> 
                <tr> 
                    <td style="text-align:right"> 
                        密码 
                    </td> 
                    <td> 
                        <s:password name="pwd" label="密码" /> 
                    </td> 
                </tr> 
                <tr> 
                    <!-- td style="text-align:right"> 
                        验证码 
                    </td> 
                    <td> 
                        <s:textfield name="inputCertCode" label=" 验 证 码" cssStyle="width:100px"/> 
                       <!--img src="other/makeCertPic.jsp"--> 
                     
                   <!--/td--> 
                </tr> 
                <tr> 
                    <td style="text-align:right"> 
                        <s:submit align="center"  value="登录" /> 
                    </td> 
                    <td align="center" style="text-align:left"> 
                        <s:reset value="取消"/> 
                    </td> 
                </tr> 
            </table> 
        </s:form> 
        <s:fielderror cssStyle="color:red"/> 
  
     <body>              
    
 
       
  </body>
</html>
