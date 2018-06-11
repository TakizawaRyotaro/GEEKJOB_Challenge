<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans" %>

<%
    HttpSession hs = request.getSession();
    UserDataBeans ud = (UserDataBeans) hs.getAttribute("UserData");

    //フォームから送られてくるtypeの値は数値なので表示用に変換
    String type = "";
    switch (ud.getType()) {
        case 1:
            type = "エンジニア";
            break;
        case 2:
            type = "営業";
            break;
        case 3:
            type = "その他";
            break;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        名前:<%= ud.getName()%><br>
        生年月日:<%= ud.getYear() + "年" + ud.getMonth() + "月" + ud.getDay() + "日"%><br>
        種別:<%= type%><br>
        電話番号:<%= ud.getTell1()%>-<%= ud.getTell2()%>-<%= ud.getTell3()%><br>
        自己紹介:<%= ud.getComment()%><br>
        以上の内容で登録しました。<br><br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
<%--セッションをここで終了--%>
<%--removeAttributeメソッド利用してinsert.jspで受け取ったセッション("ac")を削除する--%>

<%session.removeAttribute("UserData");
    session.removeAttribute("ac");
%>