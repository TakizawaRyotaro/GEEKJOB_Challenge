<%-- 
    Document   : java18-2
    Created on : 2018/05/01, 17:22:29
    Author     : takizawaryoutarou
--%>
<%@page import = "java.sql.*"%>
<%
    Connection db_con = null;
    PreparedStatement db_st = null;
    ResultSet db_data = null;
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "GEEKJOB", "password");
//新しいレコードを記述する処理        
        db_st = db_con.prepareStatement("INSERT INTO profiles(profilesID,name,tel,age,birthday) VALUES(6,'滝澤遼太郎','000-0000-0000',23,'1994-06-24')");
        db_st.executeUpdate();
//新しく挿入したレコード(profilesIDが6のデータ)を取得        
        db_st = db_con.prepareStatement("SELECT * FROM profiles WHERE profilesID = ?");
        db_st.setInt(1, 6);
        db_data = db_st.executeQuery();
        while (db_data.next()) {
            out.print("ID" + db_data.getString("profilesID") + "名前" + db_data.getString("name") + "電話番号" + db_data.getString("tel") + "年齢" + db_data.getString("age") + "生年月日" + db_data.getString("birthday") + "<br>");

        }

        db_data.close();
        db_st.close();
        db_con.close();
        out.print("処理を行いました");

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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
