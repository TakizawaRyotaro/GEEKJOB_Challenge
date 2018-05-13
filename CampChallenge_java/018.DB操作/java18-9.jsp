<%-- 
    Document   : java18-9
    Created on : 2018/05/03, 17:31:04
    Author     : takizawaryoutarou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>
<%
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String tel = request.getParameter("tel1") + "-" + request.getParameter("tel2") + "-" + request.getParameter("tel3");
    int age = Integer.parseInt(request.getParameter("age"));
    String birthday = request.getParameter("birthday1") + "-" + request.getParameter("birthday2") + "-" + request.getParameter("birthday3");

    Connection db_con = null;
    ResultSet db_data = null;
    PreparedStatement db_st0 = null;
    PreparedStatement db_st1 = null;
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "GEEKJOB", "password");
//プロフィールIDは重複しないようにSELECT MAX()...FROM テーブル名で常にプロフィールIDカラムの最大値を所得できるようにする        
        db_st0 = db_con.prepareStatement("insert into profiles select MAX(profilesID)+1 , '" + name + "','" + tel + "'," + age + ",'" + birthday + "'from profiles");
        db_st1 = db_con.prepareStatement("select * from profiles");

        db_st0.executeUpdate();
        db_data = db_st1.executeQuery();
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
        <title>レコード追加成功</title>
    </head>
    <body>

    </body>
</html>
