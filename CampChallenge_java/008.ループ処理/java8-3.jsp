<%-- 
    Document   : java8-3
    Created on : 2018/03/22, 13:25:12
    Author     : takizawaryoutarou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
int x = 0;
for(int i=0;i<=100;i++){
x = x + i;
}
out.print(x) ;
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
