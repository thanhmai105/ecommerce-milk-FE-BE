/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerServlet;

import DAO.GioHangDAO;
import DAO.SanPhamDAO;
import DAO.UserDAO;
import Model.GioHangModel;
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
@WebServlet(urlPatterns = {"/loadgiohang","/themvaogiohang","/xoagh","/tangsl","/giamsl"})
public class Giohang extends HttpServlet {
private static final long serialVersionUID = 1L;
    private GioHangDAO ghdao;
    private UserDAO userdao;
    private SanPhamDAO spdao;
    
     public void init() {
        ghdao = new GioHangDAO("jdbc:mysql://localhost:3306/webdb?useSSL=false","root", "1234");
        userdao= new UserDAO("jdbc:mysql://localhost:3306/webdb?useSSL=false","root", "1234");
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
                          case "/tangsl":
                                TangSP(request, response);
                                break; 
                          case "/giamsl":
                                GiamSP(request, response);
                                break; 
                          case "/xoagh":
                             XoaGH(request, response);
                             break;  
                         case "/themvaogiohang":
                             ThemvaoGH(request, response);
                             break;
                        default:
                            Giohang(request, response);
                            break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
    }
    private void Giohang(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
                int iduser=Integer.parseInt(request.getParameter("iduser"));
		List<GioHangModel> listgiohang= ghdao.getGioHang(iduser);
                request.setAttribute("listgiohang", listgiohang);
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
                float tonggia=0;
                for(GioHangModel ghm:listgiohang){
                    tonggia=tonggia+ghm.getGia1();
                }
                request.setAttribute("tonggia", tonggia);
		RequestDispatcher rd= request.getRequestDispatcher("/View/Customer/Giohang.jsp");
		rd.forward(request, response);
       
	}
    private void ThemvaoGH(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
                int iduser=Integer.parseInt(request.getParameter("iduser"));
                int idsp=Integer.parseInt(request.getParameter("id"));
                SanPhamModel sp= spdao.searchSanPhambyId(idsp);
                int soluong=1;
                GioHangModel gh=new GioHangModel(sp.getHinhanh(),sp.getTensp(),sp.getLoaisp(), sp.getGia(),soluong, iduser, idsp);
                int test=ghdao.addSPGioHang(gh);
                if(test>0){
                    response.sendRedirect("loadgiohang?iduser="+iduser);
                }
       
	}
    private void XoaGH(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
                int iduser=Integer.parseInt(request.getParameter("iduser"));
                int idsp=Integer.parseInt(request.getParameter("idsp"));
                ghdao.deleteGiohang(idsp, iduser);
                response.sendRedirect("loadgiohang?iduser="+iduser);

       
	}
    private void TangSP(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
                int iduser=Integer.parseInt(request.getParameter("iduser"));
                int idsp=Integer.parseInt(request.getParameter("idsp"));
                
                int soluong=ghdao.getSoLuong(idsp, iduser);
                int test=ghdao.Tangsl(soluong, iduser, idsp);
                if(test>0){
                    response.sendRedirect("loadgiohang?iduser="+iduser);
                }
       
	}
    private void GiamSP(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
              int iduser=Integer.parseInt(request.getParameter("iduser"));
                int idsp=Integer.parseInt(request.getParameter("idsp"));
                
                int soluong=ghdao.getSoLuong(idsp, iduser);
                int test=ghdao.Giamsl(soluong, iduser, idsp);
                if(test>0){
                    response.sendRedirect("loadgiohang?iduser="+iduser);
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
