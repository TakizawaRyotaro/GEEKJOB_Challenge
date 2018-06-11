<%@page import="jums.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession hs = request.getSession();
    UserDataBeans ud = (UserDataBeans) hs.getAttribute("UserData");
    
    //insertconfirmから戻った際のチェックボックスの初期設定
    //typeを配列にしてfor文を利用することで当てはまった値のボタン(選択されたボタン)にchecked属性を付ける    
    String type[] = {"" , "" , ""};
    for(int i=1 ; i <=3 ; i++){
        if(i == ud.getType()){
            type[i - 1] ="checked";
        }else if(ud.getType() == 0){
             type[0] ="checked";
        }
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
        
    <form action="insertconfirm" method="POST">
<%--各記入項目にrequired属性を与えることで未入力を防ぐ(未入力がある場合その項目を教えてくれる)--%>        
<%--名前、電話番号、自己紹介文はvalue属性の値(初期値)を入力された値になるように設定する--%>        
        名前:
        <input type="text" name="name" value="<%=ud.getName()%>" required>※必須
        <br><br>

<%--iの値がyear,month,dayの値と同じだった場合selected属性を与えて初期状態で選択された状態にする--%>        
        生年月日:　
        <select name="year" required>
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){ 
            if(i == Integer.parseInt(ud.getYear())){%>
            <option value="<%=i%>" selected> <%=i%> </option>
            <%}else{%>
            <option value="<%=i%>"> <%=i%> </option>
            
            <% }} %>
        </select>年
        <select name="month" required>
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ 
            if(i == Integer.parseInt(ud.getMonth())){%>
            <option value="<%=i%>" selected><%=i%></option>
            <%}else%>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
            
        </select>月
        <select name="day" required>
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ 
            if(i == Integer.parseInt(ud.getDay())){%>
            <option value="<%=i%>" selected><%=i%></option>
            <%}else%>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日　※必須
        <br><br>

        種別:※必須
        <br>
        <input type="radio" name="type" value="1" <%= type[0]%>>エンジニア<br>
        <input type="radio" name="type" value="2" <%= type[1]%>>営業<br>
        <input type="radio" name="type" value="3" <%= type[2]%>>その他<br>
        <br>

        電話番号:
        <input type="text" name="tell1" value="<%=ud.getTell1()%>" style="width: 40px" pattern="[0-9]{2,4}" required="" >
        - <input type="text" name="tell2" value="<%=ud.getTell2()%>" style="width: 60px" pattern="[0-9]{1,4}" required="" >
        - <input type="text" name="tell3" value="<%=ud.getTell3()%>" style="width: 60px" pattern="[0-9]{1,4}" required="" >※必須
        <br><br>

        自己紹介文※必須
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none"  wrap="hard" required><%= ud.getComment()%></textarea><br><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
