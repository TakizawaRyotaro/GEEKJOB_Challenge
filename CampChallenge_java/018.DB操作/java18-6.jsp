<%-- 
    Document   : java18-6
    Created on : 2018/05/02, 16:55:45
    Author     : takizawaryoutarou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>
<%
    Connection db_con = null;
    ResultSet db_data = null;
    PreparedStatement db_st0 = null;
    PreparedStatement db_st1 = null;

    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "GEEKJOB", "password");
        db_st1 = db_con.prepareStatement("delete from profiles where profilesID = ?");
        db_st1.setInt(1, 6);
        db_st0 = db_con.prepareStatement("select * from profiles");

        db_st1.executeUpdate();
        db_data = db_st0.executeQuery();
        while (db_data.next()) {
            out.print("ID" + db_data.getString("profilesID") + "名前" + db_data.getString("name") + "電話番号" + db_data.getString("tel") + "年齢" + db_data.getString("age") + "生年月日" + db_data.getString("birthday") + "<br>");
        }
        db_data.close();
        db_st0.close();
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
