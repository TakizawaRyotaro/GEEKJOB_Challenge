<%-- 
    Document   : java6-1
    Created on : 2018/03/19, 16:22:32
    Author     : takizawaryoutarou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%
ArrayList <String> data = new ArrayList<String>();   
data.add("10");
data.add("100");
data.add("soeda");
data.add("hayashi");
data.add("-20");
data.add("118");
data.add("END");
out.print(data);

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
