
<%@page contentType="image/jpeg" pageEncoding="gbk"%> 

<jsp:useBean id="image" scope="page" class="com.other.makeCertPic" /> 

<% 
    String str = image.getCertPic(0,0,response.getOutputStream()); 

    // ����֤�뱣�浽Session �� 
    session.setAttribute("certCode", str);  
%> 