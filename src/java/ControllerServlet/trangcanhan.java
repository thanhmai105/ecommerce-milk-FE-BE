/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerServlet;

import DAO.SanPhamDAO;
import DAO.UserDAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "trangcanhan", urlPatterns = {"/trangcanhan"})
public class trangcanhan extends HttpServlet {
private static final long serialVersionUID = 1L;
    private UserDAO userdao;
    
     public void init() {
        userdao = new UserDAO("jdbc:mysql://localhost:3306/webdb?useSSL=false","root", "1234");
 
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
                        default:
                            Trangcanhan(request, response);
                            break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
    }
    private void Trangcanhan(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id=Integer.parseInt(request.getParameter("id"));
        User user=userdao.searchUserbyId(id);
        request.setAttribute("user", user);
        RequestDispatcher rd= request.getRequestDispatcher("/View/Customer/trangcanhan.jsp");
        rd.forward(request, response);
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
