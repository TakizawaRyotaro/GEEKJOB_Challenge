package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class ResultDetail extends HttpServlet {

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
        try {
            HttpSession session = request.getSession();
            Map<String, ArrayList> rs = (HashMap<String, ArrayList>) session.getAttribute("resultData");
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更

            int id = Integer.parseInt(request.getParameter("id"));
            int num = ((List<Integer>) rs.get("userID")).indexOf(id);

            //userIDがはいっている列番号から各データを取り出す
            UserDataDTO udd = new UserDataDTO();
            udd.setUserID(((List<Integer>) rs.get("userID")).get(num));
            udd.setName(((List<String>) rs.get("name")).get(num));
            udd.setBirthday(((List<Date>) rs.get("birthday")).get(num));
            udd.setTell(((List<String>) rs.get("tell")).get(num));
            udd.setType(((List<Integer>) rs.get("type")).get(num));
            udd.setComment(((List<String>) rs.get("comment")).get(num));
            udd.setNewDate(((List<Timestamp>) rs.get("newDate")).get(num));

            //表示用にidとtypeをセッションに格納
            session.setAttribute("data", udd);
            session.setAttribute("id", id);
            session.setAttribute("type", JumsHelper.getInstance().exTypenum(udd.getType()));
            request.setAttribute("adc", session.getAttribute("adc"));
            request.getRequestDispatcher("/resultdetail.jsp").forward(request, response);

//            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
//            UserDataDTO searchData = new UserDataDTO();
//            searchData.setUserID(2);
//
//            UserDataDTO resultData = UserDataDAO .getInstance().searchByID(searchData);
//            request.setAttribute("resultData", resultData);
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
