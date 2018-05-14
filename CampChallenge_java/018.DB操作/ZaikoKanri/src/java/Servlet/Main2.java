/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author takizawaryoutarou
 */
public class Main2 extends HttpServlet {

    Connection db_con = null;
    PreparedStatement db_st = null;
    ResultSet db_data = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zaiko", "GEEKJOB", "password");

            db_st = db_con.prepareStatement("INSERT INTO product(productID,name,type,price,stock) VALUES(?,?,?,?,?)");

            request.setCharacterEncoding("UTF-8");

            String idReceived = request.getParameter("productID");
            String nameReceived = request.getParameter("productName");
            String typeReceived = request.getParameter("productType");
            String priceReceived = request.getParameter("productPrice");
            String stockReceived = request.getParameter("productStock");

            int idConverted = Integer.parseInt(idReceived);
            int priceConverted = Integer.parseInt(priceReceived);
            int stockConverted = Integer.parseInt(stockReceived);

            db_st.setInt(1, idConverted);
            db_st.setString(2, nameReceived);
            db_st.setString(3, typeReceived);
            db_st.setInt(4, priceConverted);
            db_st.setInt(5, stockConverted);

            db_st.executeUpdate();

            RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/insertResult.jsp");
            rd.forward(request, response);

            db_data.close();
            db_st.close();
            db_con.close();

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
            /**
             * Handles the HTTP <code>GET</code> method.
             *
             * @param request servlet request
             * @param response servlet response
             * @throws ServletException if a servlet-specific error occurs
             * @throws IOException if an I/O error occurs
             */
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
