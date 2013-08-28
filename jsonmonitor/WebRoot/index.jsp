<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<link rel="stylesheet" type="text/css" href="ext4/resources/css/ext-all.css" />
    <script type="text/javascript" src="ext4/bootstrap.js"></script>
    <script type="text/javascript" src="ext4/ext-all.js"></script>
	<script type="text/javascript" src="script/ajax.js"></script>
  </head>
  
    <body id="docbody">
	    <h1>Line Chart Example</h1>
	    <div style="margin: 10px;">
	       <p>
	        Display 2 sets of random data in a line series. Reload data will randomly generate a new set of data in the store. Click on the legend items to remove them from the chart. <a href="Line.js">View Source</a>
	        </p>
            <input type="button" id="fu" width="50"  value="asdfasdf" />
	    </div>
    </body>
</html>
