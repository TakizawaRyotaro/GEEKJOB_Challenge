<%-- 
    Document   : index
    Created on : 2018/05/09, 14:19:30
    Author     : takizawaryoutarou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫管理システム</title>
    </head>
    <body>
        <h1>在庫管理システムへようこそ</h1>
        <h3>在庫情報を管理しています。新しい商品の登録、在庫情報の確認をしたい場合はユーザー名とパスワードを入力してください。</h3>
        <form action="./Login" method="post">
            <br>
            ユーザー名:<input type="text" name="name"><br>
            パスワード:<input type="password" name="pass"><br>
            <br>
            <input type="submit" value="ログイン">
            <input type="reset" value="リセット">
        </form>
    </body>
</html>
