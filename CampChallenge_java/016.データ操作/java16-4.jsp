<%-- 
    Document   : java16-4
    Created on : 2018/04/19, 17:36:59
    Author     : takizawaryoutarou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
//HTMLから受け取った値を代入する    
    String goods = request.getParameter("goods");
//HTMLから受け取ったString型の値をdouble型にする    
    Double total = Double.parseDouble(request.getParameter("total"));
    Double count = Double.parseDouble(request.getParameter("count"));
//単価を表示できるようにする記述    
    double price = total / count;
//総額3000未満で0、3000以上5000未満で総額の4%、5000以上で総額の5%ポイントがつくようにする    
    double point = 0;
    if (total < 3000) {
        point = 0;
    } else if (total >= 3000 && total < 5000) {
        point = total * 0.04;
    } else {
        point = total * 0.05;
    }
//品目と単価と付いたポイントを表示
    out.print(goods + "<br>");
    out.print("単価は" + price + "円<br>");
    out.print("付加ポイントは" + point + "ポイント<br>");
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
