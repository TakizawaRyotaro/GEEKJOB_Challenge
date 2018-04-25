<%-- 
    Document   : java16-2
    Created on : 2018/04/18, 16:05:45
    Author     : takizawaryoutarou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            out.print(request.getParameter("name") + "<br>");
            out.print(request.getParameter("sex") + "<br>");
            out.print(request.getParameter("hobby") + "<br>");
            out.print(request.getParameter("btnSubmit") + "<br>");
        %>
    </body>
</html>
