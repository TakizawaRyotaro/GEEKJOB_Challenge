<%-- 
    Document   : java5-3
    Created on : 2018/03/16, 13:30:20
    Author     : takizawaryoutarou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 char word = 'あ';
 switch (word){
         case'A':
             out.print("英語");
             break;
         case'あ':
             out.print("日本語");
             break;
         default:
             break;
 }
            
           
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
