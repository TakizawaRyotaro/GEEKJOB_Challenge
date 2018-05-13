<%-- 
    Document   : loginResult
    Created on : 2018/05/09, 14:37:17
    Author     : takizawaryoutarou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="zaiko.User" %>
<%
//セッションスコープからユーザー情報を取得
    User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫管理システム　ログインページ</title>
    </head>
    <body>
        <h1>在庫管理システムにログイン</h1>
        
        <% if (loginUser != null) {%>        
        <p>ログインに成功しました</p> 
        <p>ようこそ<%= loginUser.getName()%>さん</p>
        <a href="./GoHomePage">在庫管理システム　ホームページへ</a>        
        <% } else { %>       
        <p>ログインに失敗しました</p>        
        <a href="./index.jsp">ログイン画面に戻る</a>      
        <% }%>        
    </body>
</html>
