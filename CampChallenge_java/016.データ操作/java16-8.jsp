<%-- 
    Document   : java16-8
    Created on : 2018/04/23, 16:04:17
    Author     : takizawaryoutarou
--%>
<%
    request.setCharacterEncoding("UTF-8");
    String Name = request.getParameter("name");
    String Sex = request.getParameter("sex");
    String Hobby = request.getParameter("hobby");
//セッションの取得
    HttpSession hs0 = request.getSession();
    HttpSession hs1 = request.getSession();
    HttpSession hs2 = request.getSession();
//情報と名前を登録
    hs0.setAttribute("PF0", Name);
    hs1.setAttribute("PF1", Sex);
    hs2.setAttribute("PF2", Hobby);
//セッションから情報を取得して表示
    String profile0 = (String) hs0.getAttribute("PF0");
    

    String profile1 = (String) hs1.getAttribute("PF1");
    

    String profile2 = (String) hs2.getAttribute("PF2");
  


%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>プロフィール</title>
    </head>
    <body>
        <form action="./java16-8.jsp" method="post">
 <!--value属性はセッションの情報にする-->           
            <p>名前<input type="text" name="name" value="<%out.print(profile0);%>"</p>
            <p>男<input type="radio" name="sex" value="男" <%if (profile1.equals("男"))out.print("checked");%>>
                女<input type="radio" name="sex" value="女"<%if(profile1.equals("女"))out.print("checked");%>> </p>
            <p>趣味<textarea name="hobby" placeholder="<%out.print(profile2);%>"></textarea></p>
            <p><input type="submit">        
        </form>
    </body>
</html>
