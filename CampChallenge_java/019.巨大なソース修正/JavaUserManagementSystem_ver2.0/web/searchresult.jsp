<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    HttpSession hs = request.getSession();
    JumsHelper jh = JumsHelper.getInstance();
    Map<String, ArrayList> rs = (Map<String, ArrayList>) hs.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <%if (((List<Integer>) rs.get("userID")).size() != 0) {%>
        <p><%=((List<Integer>) rs.get("userID")).size()%>件のデータが見つかりました</p>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>

            <%
                for (int i = 0; i < ((List<Integer>) rs.get("userID")).size(); i++) {
            %>
            <tr>
                <td><a href="ResultDetail?id=<%= ((List<Integer>) rs.get("userID")).get(i)%>"><%= ((List<String>) rs.get("name")).get(i)%></a></td>
                <td><%= new SimpleDateFormat("yyyy").format(((List<Date>) rs.get("birthday")).get(i))%>年</td>
                <td><%= jh.exTypenum(((List<Integer>) rs.get("type")).get(i))%></td>
                <td><%= ((List<Timestamp>) rs.get("newDate")).get(i)%></td>
            </tr>
            <%}%>
        </table>
        <%} else {%>
        <p>該当するデータはありません</p><br>
        <%}%><br>
        <form action="Search" method="post">
            <input type="submit" name="return" value="検索画面に戻る">
            <input type="hidden" name="return" value="true">
            </table>
            </body>
            <%=jh.home()%>
            </html>
