<%-- 
    Document   : java7-1
    Created on : 2018/03/20, 16:51:15
    Author     : takizawaryoutarou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.util.HashMap" %>
<%
HashMap<String,String>x = new HashMap<String,String>();
x.put("1","AAA");
x.put("hello","world");
x.put("soeda","33");
x.put("20","20");
%>    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
