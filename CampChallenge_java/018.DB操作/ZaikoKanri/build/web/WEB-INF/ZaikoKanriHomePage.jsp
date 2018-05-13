<%-- 
    Document   : ZaikoKanriHomePage
    Created on : 2018/05/11, 13:05:35
    Author     : takizawaryoutarou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="zaiko.User" %>

<%
//セッションスコープに保存されたユーザー情報を取得    
User loginUser  = (User) session.getAttribute("loginUser");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫管理システム　ホームページ</title>
    </head>
    <body>
         <%= loginUser.getName() %>さん、ログイン中
        <h1>在庫管理システムホームページへようこそ</h1>
        
        <h3>商品情報の登録をしたい人は</h3>
        <p><a href="./InsertForm">こちらをクリックしてください。</a></p>
        
        <h3>商品情報の一覧を見たい方は</h3>
        <p><a href="./Main">こちらをクリックしてください</a></p>
        
        <h3>ログアウトしたい人は</h3>
        <p><a href="./Logout">ログアウト</a></p>
        </form>
    </body>
</html>
