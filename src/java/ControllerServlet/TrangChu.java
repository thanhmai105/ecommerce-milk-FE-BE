/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerServlet;

import DAO.SanPhamDAO;
import DAO.UserDAO;
import Model.SanPhamModel;
import Model.User;
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
@WebServlet(urlPatterns = {"/trangchulogin","/trangchu"})
public class TrangChu extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SanPhamDAO spdao;
    private UserDAO userdao;
    
     public void init() {
        spdao = new SanPhamDAO("jdbc:mysql://localhost:3306/webdb?useSSL=false","root", "1234");
        userdao= new UserDAO("jdbc:mysql://localhost:3306/webdb?useSSL=false","root", "1234");
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
        String action = request.getServletPath();
        
		try {
			switch(action) {
                            case "/trangchu":
                                Trangchu(request, response);
                                break;
                        default:
                            Trangchu1(request, response);
                            break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
    }
    private void Trangchu1(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<SanPhamModel> dssp1= spdao.getSPBanChay();
                request.setAttribute("dssp1", dssp1);
                List<SanPhamModel> dssp2= spdao.getSPMoiNhat();
                request.setAttribute("dssp2", dssp2);
                List<SanPhamModel> dssp3= spdao.getSPSuaBot();
                request.setAttribute("dssp3", dssp3);
                List<SanPhamModel> dssp4= spdao.getSPSuaNon();
                request.setAttribute("dssp4", dssp4);
                List<SanPhamModel> dssp5= spdao.getSPSuaDacTri();
                request.setAttribute("dssp5", dssp5);
		RequestDispatcher rd= request.getRequestDispatcher("/View/trangchu1.jsp");
		rd.forward(request, response);
	}
    private void Trangchu(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<SanPhamModel> dssp1= spdao.getSPBanChay();
                request.setAttribute("dssp1", dssp1);
                List<SanPhamModel> dssp2= spdao.getSPMoiNhat();
                request.setAttribute("dssp2", dssp2);
                List<SanPhamModel> dssp3= spdao.getSPSuaBot();
                request.setAttribute("dssp3", dssp3);
                List<SanPhamModel> dssp4= spdao.getSPSuaNon();
                request.setAttribute("dssp4", dssp4);
                List<SanPhamModel> dssp5= spdao.getSPSuaDacTri();
                request.setAttribute("dssp5", dssp5);
                int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/Customer/trangchu.jsp");
		rd.forward(request, response);
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
