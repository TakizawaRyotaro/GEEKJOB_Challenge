/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MP;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author takizawaryoutarou
 */
@WebServlet(name = "java11h", urlPatterns = {"/java11h"})
public class java11h extends HttpServlet {

    String[] RT(String dataxID) {
        String[] data0 = {"0", "平成6年6月24日", "神奈川県相模原市"};
        String[] data1 = {"1", "平成6年10月27日", "神奈川県相模原市"};
        String[] data2 = {"2", "平成6年12月11日", null};
        if (data0[0].equals(dataxID)) {
            return data0;
        } else if (data1[0].equals(dataxID)) {
            return data1;
        } else if (data2[0].equals(dataxID)) {
            return data2;
        } else {
            String[] defaultArray = {};
            return defaultArray;
        }
    }

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet java11h</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet java11h at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            int limit = 2;
            for (int i = 0; i <= 2; i++) {
                if (i >= limit) {
                    break;
                }
                String[] Datai = RT(String.valueOf(i));
                for (int m = 0; m <= 2; m++) {
                    if (m == 0) {
                        continue;
                    }
                    if (Datai[m].equals(null)) {
                        continue;
                    }
                    out.println(Datai[m]);

                }
            }

        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
