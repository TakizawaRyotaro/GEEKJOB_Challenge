<%-- 
    Document   : java8-1
    Created on : 2018/03/22, 10:27:55
    Author     : takizawaryoutarou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 long result = 1;
for(long i=0;i<20;i++){
    result = result*8;
} 
out.print(result);
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
