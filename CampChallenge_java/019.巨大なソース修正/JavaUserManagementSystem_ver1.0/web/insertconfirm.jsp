<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans" %>


<%
    HttpSession hs = request.getSession();
    UserDataBeans ud = (UserDataBeans) hs.getAttribute("UserData");
    //フォームから送られてくるのは数値なので表示用に変換
    String type[] = {"エンジニア", "営業", "その他"};
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
        <style type ="text/css">
            .table{
                width: 50%;
                height: 30px;
                border-spacing: 0px;
            }
            .table td{
                height: 50px;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <h1>登録確認</h1>

        <table class="table" border="1">
            <tr><td style="width: 110px">名前</td><td><%= ud.getName()%></td></tr>
            <tr><td>生年月日</td><td><%= ud.getYear() + "年" + ud.getMonth() + "月" + ud.getDay() + "日"%></td></tr>
            <tr><td>種別</td><td><%= type[ud.getType() - 1]%></td></tr>
            <tr><td>電話番号</td><td><%= ud.getTell1()%>-<%= ud.getTell2()%>-<%= ud.getTell3()%></td></tr>
            <tr><td>自己紹介</td><td><%= ud.getComment()%></td></tr>
        </table><br>上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい"><br>
        </form>

        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>