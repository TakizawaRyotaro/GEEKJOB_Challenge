/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

/**
 *
 * @author takizawaryoutarou
 */
@WebServlet("/Main")
public class Main extends HttpServlet {

    Connection db_con = null;
    PreparedStatement db_st = null;
    ResultSet db_data = null;

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zaiko", "GEEKJOB", "password");

            db_st = db_con.prepareStatement("SELECT * FROM product");

            db_data = db_st.executeQuery();

            while (db_data.next()) {
                int productID = db_data.getInt("productID");
                String productName = db_data.getString("name");
                String productType = db_data.getString("type");
                int productPrice = db_data.getInt("price");
                int productStock = db_data.getInt("stock");
                out.println("商品ID:" + productID + "商品名:" + productName + "商品の種類:" + productType + "価格:" + productPrice + "在庫:" + productStock + "<br>");
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"./GoHomePage\">ホームページへ戻る。</a>");
            out.println("</body>");
            out.println("</html>");

            db_data.close();
            db_st.close();
            db_con.close();

        } catch (SQLException e) {
            out.print(e.getMessage());
        } catch (ClassNotFoundException e) {
            out.print(e.getMessage());
        } catch (Exception e) {
            out.print(e.getMessage());
        } finally {
            if (db_con != null) {
                try {
                    db_con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "short description";
    }
}
