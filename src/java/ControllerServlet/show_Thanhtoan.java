/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerServlet;

import DAO.ThanhtoanDAO;
import DAO.UserDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import Model.DonHangModel;
import DAO.DonHangDAO;

@WebServlet(name = "thanhtoan", urlPatterns = {"/thanhtoan"})
public class show_Thanhtoan extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private DonHangDAO dhdao;

    public void init() {
        dhdao = new DonHangDAO("jdbc:mysql://localhost:3306/webdb?useSSL=false", "root", "1234");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getServletPath();

        try {
            switch (action) {
                default:
                    insertThanhtoan(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

//    private void showThanhtoan(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        
//        int id=Integer.parseInt(request.getParameter("id"));
//        User user = userdao.searchUserbyId(id);
//        request.setAttribute("user", user);
//        RequestDispatcher rd= request.getRequestDispatcher("/View/Customer/trangcanhan.jsp");
//        rd.forward(request, response);
//}
    private void Trangthanhtoan(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        RequestDispatcher rd= request.getRequestDispatcher("/View/Customer/Thanhtoan.jsp");
        rd.forward(request, response); 
    }
    private void insertThanhtoan(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String sdt = request.getParameter("sdt");
        String diachi = request.getParameter("dcnh");
        String phuongthucvanchuyen = request.getParameter("ptvc");
        String hinhthucthanhtoan = request.getParameter("httt");
        String thongtinsp=request.getParameter("ttsp");
        int idUser=0;
        DonHangModel donhang=new DonHangModel(name,sdt,diachi,phuongthucvanchuyen,hinhthucthanhtoan,thongtinsp,idUser);
       int a=dhdao.saveDH(donhang);
       if(a>0){
                RequestDispatcher rd= request.getRequestDispatcher("/View/trangchu1.jsp");
		rd.forward(request, response);
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
    }// </editor-fold>

}
