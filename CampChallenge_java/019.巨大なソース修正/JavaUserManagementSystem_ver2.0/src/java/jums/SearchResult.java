package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class SearchResult extends HttpServlet {

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

        request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
        HttpSession session = request.getSession();
        String accesschk = request.getParameter("ac");

        try {
            //アクセスルートチェック
            if (accesschk == null || (Integer) session.getAttribute("ac") != Integer.parseInt(accesschk)) {
                throw new Exception("不正なアクセスです");
            }

            String re = request.getParameter("return");
            //検索結果からの戻りなのか判別
            if (re == null) {
                UserDataBeans udb = (UserDataBeans) session.getAttribute("searchData");

//            UserDataBeans udb = new UserDataBeans();
//            udb.setName(request.getParameter("name"));
//            udb.setYear(request.getParameter("year"));
//            udb.setType(request.getParameter("type"));
                //フォームからの入力を取得して、JavaBeansに格納
                //名前が未入力ならnullをセット
                if (!request.getParameter("name").equals("") || request.getParameter("name") != null) {
                    udb.setName(request.getParameter("name").trim());
                } else {
                    udb.setName(null);
                }
                //生年が未選択ならnullをセット            
                if (request.getParameter("year") == null) {
                    udb.setYear(null);
                } else {
                    udb.setYear(request.getParameter("year"));
                }
                //職別が未選択ならnullをセット            
                if (request.getParameter("type") == null) {
                    udb.setType(null);
                } else {
                    udb.setType(request.getParameter("type"));
                }
                session.setAttribute("searchData", udb);
                //DTOオブジェクトにマッピング。DB専用のパラメータに変換
                UserDataDTO searchData = new UserDataDTO();
                udb.UD2DTOMapping(searchData);

                HashMap<String, ArrayList> resultData = UserDataDAO.getInstance().search(searchData);
                session.setAttribute("resultData", resultData);

            }
//            searchData.setName(udb.getName());
//            Calendar birthday = Calendar.getInstance();
//            birthday.set(udb.getYear(),udb.getMonth() - 1,udb.getDay());
//            searchData.setBirthday(birthday.getTime());
//            searchData.setType(udb.getType());

//            UserDataDTO resultData = UserDataDAO .getInstance().search(searchData);
//            request.setAttribute("resultData", resultData);
            request.getRequestDispatcher("/searchresult.jsp").forward(request, response);
        } catch (Exception e) {
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SearchResult.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SearchResult.class.getName()).log(Level.SEVERE, null, ex);
        }
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
