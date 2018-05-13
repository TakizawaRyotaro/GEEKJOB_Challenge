<%-- 
    Document   : java18-5
    Created on : 2018/05/02, 16:20:58
    Author     : takizawaryoutarou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>
<%
    Connection db_con = null;
    PreparedStatement db_st = null;
    ResultSet db_data = null;
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "GEEKJOB", "password");
//部分一致の検索を行うため[=]ではなく[like]を使う        
        db_st = db_con.prepareStatement("select * from profiles where name like ?");
//部分一致の値を取得するため値を[%]で囲む        
        db_st.setString(1, "%茂%");
        db_data = db_st.executeQuery();
        while (db_data.next()) {
            out.print("ID" + db_data.getString("profilesID") + "名前" + db_data.getString("name") + "電話番号" + db_data.getString("tel") + "年齢" + db_data.getString("age") + "生年月日" + db_data.getString("birthday") + "<br>");
        }
        db_data.close();
        db_con.close();
        db_st.close();

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
