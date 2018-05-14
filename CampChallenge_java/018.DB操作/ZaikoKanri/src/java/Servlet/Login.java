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
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

import zaiko.LoginLogic;
import zaiko.User;

/**
 *
 * @author takizawaryoutarou
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

//リクエストパラメータの取得      
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("name");
            String pass = request.getParameter("pass");

//Userインスタンス(ユーザー情報)の生成
            User user = new User(name, pass);

//ログイン処理      
            LoginLogic loginLogic = new LoginLogic();
            boolean isLogin = loginLogic.execute(user);

//ログイン成功時の処理  
            if (isLogin) {
//ユーザー情報をセッションスコープに保存  
                HttpSession session = request.getSession();
                session.setAttribute("loginUser", user);
            }
//ログイン結果画面にフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/loginResult.jsp");
            dispatcher.forward(request, response);

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
        return "Short description";
    }
}
