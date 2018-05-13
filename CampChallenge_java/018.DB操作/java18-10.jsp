<%-- 
    Document   : java18-10
    Created on : 2018/05/07, 10:26:04
    Author     : takizawaryoutarou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>
<%
    request.setCharacterEncoding("UTF-8");
//HTMLから値を受け取っていない状態(初期実行時)の時のために空の変数を指定しておく    
    String s_profilesID = null;
    int i_profilesID = 0;
//渡された値がある時のみ指定しておいた変数に値を代入する    
    if (request.getParameter("profilesID") != null) {
        s_profilesID = request.getParameter("profilesID");
        i_profilesID = Integer.parseInt(request.getParameter("profilesID"));
    }

    Connection db_con = null;
    ResultSet db_data = null;
    PreparedStatement db_st0 = null;
    PreparedStatement db_st1 = null;

    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "GEEKJOB", "password");

//渡された値がある時のみ指定されたレコードを削除する処理を行う        
        if (s_profilesID != null) {
            db_st0 = db_con.prepareStatement("delete from profiles where profilesID = ?");
            db_st0.setInt(1, i_profilesID);
            db_st0.executeUpdate();
            db_st0.close();

        }

        db_st1 = db_con.prepareStatement("select * from profiles");
        db_data = db_st1.executeQuery();
        while (db_data.next()) {
            out.print("ID" + db_data.getString("profilesID") + "名前" + db_data.getString("name") + "電話番号" + db_data.getString("tel") + "年齢" + db_data.getString("age") + "生年月日" + db_data.getString("birthday") + "<br>");
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
        <title>選択したプロフィールIDのレコードを削除</title>
    </head>
    <body>
        <form action="./java18-10.jsp" method="post">
            <p>プロフィールID:<br>
                <input type="number" name="profilesID">
                <input type="submit">


        </form>
    </body>
</html>
