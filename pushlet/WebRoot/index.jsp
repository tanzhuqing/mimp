<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
 <head> 

      <script type="text/javascript" src="ajax-pushlet-client.js"></script> 

       <script type="text/javascript"> 

           PL._init(); 

           PL.joinListen('/zhaoyang/hi'); 
            function onData(event) { 

               alert(event.get("hw")); 

          } 

       </script> 

   </head> 

   

   <body> 

  <h1>my first pushlet</h1> 
  </body> 


</html>
