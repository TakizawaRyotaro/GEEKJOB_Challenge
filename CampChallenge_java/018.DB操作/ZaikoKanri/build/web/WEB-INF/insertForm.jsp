<%-- 
    Document   : insertForm
    Created on : 2018/05/11, 13:57:30
    Author     : takizawaryoutarou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品登録ページ</title>
    </head>
    <body>
        <h1>商品登録ページ</h1>
        <form action="./Main2" method="post">
            <h3>商品の情報を入力してください</h3>
            商品ID:<input type="text" name="productID"><br>
            商品名:<input type="text" name="productName" placeholder="商品名を入力してください"><br>
            商品(種類):<input type="text" name="productType" placeholder="商品の種類を入力してください"><br>
            商品の価格:<input type="text" name="productPrice" placeholder="商品の価格を入力してください"><br>
            商品の在庫:<input type="text" name="productStock" placeholder="商品の在庫数を入力してください"><br>
            <input type="submit" value="登録">
            <input type="reset" value="リセット">
        </form>
    </body>
</html>
