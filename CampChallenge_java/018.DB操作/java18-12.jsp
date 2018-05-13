<%-- 
    Document   : java18-12
    Created on : 2018/05/07, 15:47:08
    Author     : takizawaryoutarou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>
<%
    request.setCharacterEncoding("UTF-8");

//値を受け取っていない状態の時の為に空の変数を指定しておく
    String name = null;
    String age = null;
    String birthday = null;

//値が渡された場合渡された値を受け取る    
    if (request.getParameter("name") != null) {
        name = request.getParameter("name");
    }

    if (request.getParameter("age") != null) {
        age = request.getParameter("age");
    }

    if ((request.getParameter("birthday1") != null && request.getParameter("birthday2") != null) && request.getParameter("birthday3") != null) {
        birthday = request.getParameter("birthday1") + "-" + request.getParameter("birthday2") + "-" + request.getParameter("birthday3");
    }

    Connection db_con = null;
    ResultSet db_data = null;
    PreparedStatement db_st = null;

    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "GEEKJOB", "password");

        if (birthday != null || age != null || name != null) {
            db_st = db_con.prepareStatement("select * from profiles where name = ? or age = ? or birthday = ?");
            db_st.setString(1, name);
            db_st.setString(2, age);
            db_st.setString(3, birthday);

            db_data = db_st.executeQuery();
            while (db_data.next()) {
                out.print("ID" + db_data.getInt("profilesID") + "名前" + db_data.getString("name") + "電話番号" + db_data.getString("tel") + "年齢" + db_data.getInt("age") + "生年月日" + db_data.getDate("birthday") + "<br>");
            }

            db_data.close();
            db_st.close();

        }
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
        <title>複合検索を行う</title>
    </head>
    <body>
        <form action="./java18-12.jsp" method="post">
            名前<input type="text" name="name" ><br><br>
            生年月日:
            西暦<input type="number" name="birthday1" min="1900" max="9999">年 <input type="number" name="birthday2" min="1" max="12">月　<input type="number" name="birthday3" min="1" max="31">日<br><br>
            年齢<input type="number" name="age" min="0" max="120"><br><br>
            <input type="submit">
        </form>
    </body>
</html>
