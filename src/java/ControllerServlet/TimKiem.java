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
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/Timkiem","/timkiemdm"})
public class TimKiem extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SanPhamDAO spdao;
    private UserDAO userdao;
    
    public void init() {
        userdao = new UserDAO("jdbc:mysql://localhost:3306/webdb?useSSL=false","root", "1234");
        spdao=new SanPhamDAO("jdbc:mysql://localhost:3306/webdb?useSSL=false","root", "1234");
        
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
                         case "/timkiemdm":
                            TimkiemDM(request, response);
                          break;
                         case "/Timkiem":
                            Timkiem(request, response);
                            break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
    }
    private void Timkiem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
                String tk=request.getParameter("timkiem");
                SanPhamModel spm=new SanPhamModel(tk);
                
                if(!tk.equals("")){
                    List<SanPhamModel> dssp= spdao.searchSanPhambyTen(spm);
                    if(!dssp.isEmpty()){ 
                        request.setAttribute("dssp", dssp);
                        request.setAttribute("tk", tk);
                        RequestDispatcher rd= request.getRequestDispatcher("/View/Customer/Timkiem.jsp");
                        rd.forward(request, response);
                    }
                    else{
                        RequestDispatcher rd= request.getRequestDispatcher("/View/Customer/Timkiem1.jsp");
                        rd.forward(request, response);

                    }
                }
                
	}
     private void TimkiemDM(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
                String hang=request.getParameter("hang");
                String doituong=request.getParameter("doituong");
                SanPhamModel spm=new SanPhamModel(hang, doituong);
               
                if(doituong.equals("tat ca")) doituong="";
                if(hang.equals("tat ca")) hang="";
                    List<SanPhamModel> dssp= spdao.searchSanPham(spm);
                    if(!dssp.isEmpty()){ 
                        request.setAttribute("dssp", dssp);
                        RequestDispatcher rd= request.getRequestDispatcher("/View/Customer/Timkiem.jsp");
                        rd.forward(request, response);
                    }
                    else{
                        RequestDispatcher rd= request.getRequestDispatcher("/View/Customer/Timkiem1.jsp");
                        rd.forward(request, response);

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
