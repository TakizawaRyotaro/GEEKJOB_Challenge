<%-- 
    Document   : java18-8
    Created on : 2018/05/03, 15:57:10
    Author     : takizawaryoutarou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>
<%
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    Connection db_con = null;
    ResultSet db_data = null;
    PreparedStatement db_st = null;
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "GEEKJOB", "password");
        db_st = db_con.prepareStatement("select * from profiles where name like ?");
        db_st.setString(1,"%" + name + "%");
        db_data = db_st.executeQuery();
        while (db_data.next()) {
            out.print("ID" + db_data.getString("profilesID") + "名前" + db_data.getString("name") + "電話番号" + db_data.getString("tel") + "年齢" + db_data.getInt("age") + "生年月日" + db_data.getString("birthday") + "<br>");
        }
        db_data.close();
        db_st.close();
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
        <title>入力した文字を含む名前を検索</title>
    </head>
    <body>
        <form action="./java18-8.jsp" method="post">
            <p>名前<input type="text" name="name" ></p>
            <p><input type="submit"></p>

        </form>
    </body>
</html>
