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
import org.apache.commons.codec.digest.DigestUtils;
/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/dangnhap","/trangdangnhap","/trangdangky","/dangky"})
public class Dangnhap extends HttpServlet {
private static final long serialVersionUID = 1L;
    UserDAO userdao;
    SanPhamDAO spdao;
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
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getServletPath();
        
		try {
			switch(action) {
                            case "/trangdangnhap":
                                Trangdangnhap(request, response);
                                break;
                            case "/trangdangky":    
                                Trangdangky(request, response);
                                break;
                            case "/dangky":    
                                Dangky(request, response);
                                break;
                            default:
                                Login(request, response);
                                break;
                            
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
        

       
    }
    private void Trangdangnhap(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        RequestDispatcher rd= request.getRequestDispatcher("/View/Dangnhap.jsp");
        rd.forward(request, response); 
    }
    private void Trangdangky(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        RequestDispatcher rd= request.getRequestDispatcher("/View/Dangky.jsp");
        rd.forward(request, response); 
    }
    private void Login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String username = request.getParameter("username");
        String mk = request.getParameter("password");
        String password = DigestUtils.md5Hex(mk);
        User user1 = new User(username,password);
        boolean a=userdao.checkLogin(user1);
        if(a){
           User user=userdao.searchUserId(username, password);
            request.setAttribute("user", user);
            if(user.getChucvu().equals("nhanvien")){
                RequestDispatcher rd= request.getRequestDispatcher("/View/Admin/quanlyKH.jsp");
                rd.forward(request, response); 
            }
            else{
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
               RequestDispatcher rd= request.getRequestDispatcher("/View/Customer/trangchu.jsp");
                rd.forward(request, response); 
            }
            
        }
        else{
            RequestDispatcher rd= request.getRequestDispatcher("/View/Dangnhap.jsp");
            rd.forward(request, response);
        }
    }
    private void Dangky(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String hoten = request.getParameter("hoten");
        String email = request.getParameter("email");
        String sdt = request.getParameter("sdt");
        String username = request.getParameter("username");
        String mk = request.getParameter("password");
        String chucvu = "khach";
        String password = DigestUtils.md5Hex(mk);
        User user = new User( hoten, email, sdt, username, password, chucvu);
        boolean a=userdao.checkLogin(user);
        if(!a){
            int b=userdao.addUser(user);
            if(b>0){
            response.sendRedirect("trangdangnhap");
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
