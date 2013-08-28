<%@ page language="java" import="java.util.*" pageEncoding=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="ext4/resources/css/ext-all.css" />
    <script type="text/javascript" src="ext4/bootstrap.js"></script>
    <script type="text/javascript" src="ext4/ext-all.js"></script>
  </head>
  
  <body>
     <s:form Action="DataUpLoadAction" theme="simple">
        <s:submit align="center"  value="执行" /> 
     </s:form>
    
 
    <textarea id="show" name="show" cols="50" rows="8"> </textarea> 
 
  </body>
</html>
