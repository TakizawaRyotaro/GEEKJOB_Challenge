/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author takizawaryoutarou
 */
@WebServlet(name = "java16f", urlPatterns = {"/java16f"})
public class java16f extends HttpServlet {

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
            //現在時刻を記録 
            Date date = new Date();
            String todayString = date.toString();
//[todayString]のインスタンスをCookieに格納し、インスタンスに"Today"と名付ける           
            Cookie c = new Cookie("Today", todayString);
//クッキーの登録、登録した値をつかえるのは2回目以降のアクセス時            
            response.addCookie(c);

//クッキー情報の取得(配列で取得)
            Cookie[] cs = request.getCookies();
//nullチェックを行って値が格納されているか確認            
            if (cs != null) {
//配列に格納された全てのクッキーを順番に見ていく                
                for (int i = 0; i < cs.length; i++) {
//getNameメソッドでクッキーの名前情報を取り出す                    
                    String cookieName = cs[i].getName();
//個々のクッキーの名前情報が"Today"と一致しているかを判定(文字列情報の為[.equals]メソッドを利用)                    
                    if (cookieName.equals("Today")) {
//getValueメソッドで値を取り出す                        
                        String cookieValue = cs[i].getValue();
                        out.print(cookieValue);
                        break;
                    }
                }

            }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet java16f</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet java16f at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
