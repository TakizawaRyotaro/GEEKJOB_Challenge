<%-- 
    Document   : java18-11
    Created on : 2018/05/07, 14:18:32
    Author     : takizawaryoutarou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>
<%
    request.setCharacterEncoding("UTF-8");
//HTMLから値を受け取ってない時の為に空の変数を指定しておく    
    int i_profilesID = 0;
    String s_profilesID = null;
    String name = null;
    String tel = null;
    int age = 0;
    String birthday = null;
//値を渡された場合はそれぞれの変数に渡された値を代入
    if (request.getParameter("profilesID") != null) {
        s_profilesID = request.getParameter("profilesID");
        i_profilesID = Integer.parseInt(request.getParameter("profilesID"));
        name = request.getParameter("name");
        tel = request.getParameter("tel1") + "-" + request.getParameter("tel2") + "-" + request.getParameter("tel3");
        age = Integer.parseInt(request.getParameter("age"));
        birthday = request.getParameter("birthday1") + "-" + request.getParameter("birthday2") + "-" + request.getParameter("birthday3");
    }
    
    Connection db_con = null;
    ResultSet db_data = null;
    PreparedStatement db_st0 = null;
    PreparedStatement db_st1 = null;

    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "GEEKJOB", "password");

        if (s_profilesID != null) {
            db_st0 = db_con.prepareStatement("update profiles set name='" + name + "',tel='" + tel + "',age=" + age + ",birthday='" + birthday + "' where profilesID = ?");
            db_st0.setInt(1, i_profilesID);
            db_st0.executeUpdate();
            db_st0.close();
        }

        db_st1 = db_con.prepareStatement("select * from profiles");
        db_data = db_st1.executeQuery();
        while (db_data.next()) {
            out.print("ID" + db_data.getString("profilesID") + "名前" + db_data.getString("name") + "電話番号" + db_data.getString("tel") + "年齢" + db_data.getInt("age") + "生年月日" + db_data.getString("birthday") + "<br>");
        }

        db_data.close();
        db_st1.close();
        db_con.close();

    } catch (SQLException e_sql) {
        out.println("接続時にエラーが発生しました" + e_sql.toString());
    } catch (Exception e) {
        out.println("接続時にエラーが発生しました" + e.toString());

    } finally {
        if (db_con != null) {
            try {
                db_con.close();
            } catch (Exception e_con) {
                System.out.print(e_con.getMessage());
            }
        }
    }

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>指定したプロフィールIDの内容を更新</title>
    </head>
    <body>
        <form action="./java18-11.jsp" method="post">
            プロフィールID<input type="number" name="profilesID" min="1"><br><br>
            名前<input type="text" name="name" ><br><br>
            電話番号<input type="number" name="tel1" max="999" min="0">
            - <input type="number" name="tel2" max="9999" min="0">
            - <input type="number" name="tel3" max="9999" min="0"><br><br>
            生年月日:
            西暦<input type="number" name="birthday1" min="1900" max="9999">年 <input type="number" name="birthday2" min="1" max="12">月　<input type="number" name="birthday3" min="1" max="31">日<br><br>
            年齢<input type="number" name="age" min="0" max="120"><br><br>
            <input type="submit">
        </form>
    </body>
</html>
