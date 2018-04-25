<%-- 
    Document   : java16-5
    Created on : 2018/04/20, 10:29:30
    Author     : takizawaryoutarou
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    ArrayList<Integer> piece = new ArrayList<Integer>();
    int x = Integer.parseInt(request.getParameter("x"));
//入力値をx 割る値をy 割った結果をaとしている
    for (int y = 2; y < x; y++) {
        if (x % y == 0) {
            int a = x / y;
//割った数をArrayList[piece]に加える            
            piece.add(y);
//入力値を割った結果の値に変更、yの値を再び2から開始するために1を代入            
            x = a;
            y = 1;
        }
    }
//ArrayList[piece]の中身を全て取り出して値の後ろに*を付けて表示、あまりを表示する場合のみ最後の値には「*」をつけないように表示    
    for (int i = 0; i < piece.size(); i++) {
        if ((i == piece.size() - 1) && (x > 10)) {
            out.print(piece.get(i));
        } else {
            out.print(piece.get(i) + "*");
        }
    }
//10以上の数字はあまりとして表示
    if (x < 10) {
        out.print(x);
    } else {
        out.print("あまり " + x + "(この数は素数です)");
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
