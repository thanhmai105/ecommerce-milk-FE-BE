/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerServlet;

import DAO.SanPhamDAO;
import Model.SanPhamModel;
import java.io.IOException;

import java.sql.SQLException;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/TrangQLSP","/newSP", "/listSP", "/insert", "/delete", "/update", "/edit"})
public class SanphamAdmin extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private SanPhamDAO spdao;

    @Override
    
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        spdao = new SanPhamDAO(jdbcURL, jdbcUsername, jdbcPassword);

    }

    public SanphamAdmin() {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/TrangQLSP":
                    TrangQLSP(request, response);
                    break;
                case "/newSP":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertSP(request, response);
                    break;
                case "/delete":
                    deleteSP(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateSP(request, response);
                    break;
                default:
                    listSP(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void TrangQLSP(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        RequestDispatcher rd= request.getRequestDispatcher("/View/Admin/quanlySP.jsp");
        rd.forward(request, response); 
    }
    private void listSP(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<SanPhamModel> dssp = spdao.getDsSanPham();
        request.setAttribute("dssp", dssp);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Admin/quanlySP.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Admin/form_update.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SanPhamModel sp = spdao.searchSanPhambyId(id);
        request.setAttribute("sanpham", sp);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Admin/form_update.jsp");
        dispatcher.forward(request, response);

    }

    private void insertSP(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, NullPointerException{
        
        String hinhAnh = request.getParameter("hinhanh");
        String tensp = request.getParameter("tensp");
        String loaiSP = request.getParameter("loaisp");
        String hangSP = request.getParameter("hangsp");
        String doituongSP = request.getParameter("doituongsp");
        float gia = Float.parseFloat(request.getParameter("gia"));
        String gioithieusp = request.getParameter("gioithieusp");
        int soluong = Integer.parseInt(request.getParameter("soluong"));
        int daban = 0;
        SanPhamModel newsp = new SanPhamModel(tensp, gia, loaiSP, hangSP, doituongSP, hinhAnh, gioithieusp, soluong, daban);
        spdao.addSP(newsp);
        response.sendRedirect("listSP");
    }

    private void updateSP(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, NullPointerException{
        int id = Integer.parseInt(request.getParameter("id"));
        String hinhAnh = request.getParameter("hinhanh");
        String tensp = request.getParameter("tensp");
        String loaiSP = request.getParameter("loaisp");
        String hangSP = request.getParameter("hangsp");
        String doituongSP = request.getParameter("doituongsp");
        float gia = Float.parseFloat(request.getParameter("gia"));
        String gioithieusp = request.getParameter("gioithieusp");
        int soluong = Integer.parseInt(request.getParameter("soluong"));
        int daban = 0;
        SanPhamModel sp = new SanPhamModel(id, tensp, gia, loaiSP, hangSP, doituongSP, hinhAnh, gioithieusp, soluong, daban);
        spdao.updateSP(sp);
        response.sendRedirect("listSP");
    }

    private void deleteSP(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SanPhamModel sp = new SanPhamModel(id);
        spdao.deleteSP(sp);
        response.sendRedirect("listSP");

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        doGet(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
