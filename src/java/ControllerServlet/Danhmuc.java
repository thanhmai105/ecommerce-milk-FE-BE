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
@WebServlet(urlPatterns = {"/Danhmuc","/DM_Vinamilk","/DM_Abbott",
    "/DM_Nutifood","/DM_Milo","/DM_Anlene","/DM_Physiolac","/DM_BenhThan",
    "/DM_UngThu","/DM_DaDay","/DM_CaoTuoi","/DM_TieuDuong","/DM_NguoiGay",
    "/DM_ColosBaby","/DM_Coloscare","/DM_Goodheald","/DM_Ildong","/DM_Nestle"})

public class Danhmuc extends HttpServlet {
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
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getServletPath();
        
		try {
                    switch(action) {
			case "/DM_Vinamilk":
                            DM_Vinamilk(request, response);
                            break;
			case "/DM_Abbott":
                            DM_Abbott(request, response);
                            break;
			case "/DM_Nutifood":
			    DM_Nutifood(request, response);
                            break;
                        case "/DM_Milo":
                            DM_Milo(request, response);
                            break;
                        case "/DM_Nestle":
                            DM_Nestle(request, response);
                            break;
                        case "/DM_Anlene":
                            DM_Anlene(request, response);
                            break;
                        case "/DM_Physiolac":
                            DM_Physiolac(request, response);
                            break;
                        case "/DM_BenhThan":
                            DM_BenhThan(request, response);
                            break;
                         case "/DM_DaDay":
                             DM_DaDay(request, response);
                            break;
                        case "/DM_CaoTuoi":
                            DM_CaoTuoi(request, response);
                            break;
                        case "/DM_UngThu":
                            DM_UngThu(request, response);
                            break;
                        case "/DM_XươngKhop":
                            DM_XuongKhop(request, response);
                            break;
                        case "/DM_NguoiGay":
                            DM_NguoiGay(request, response);
                            break;  
                        case "/DM_TieuDuong":
                            DM_TieuDuong(request, response);
                            break; 
                        case "/DM_ColosBaby":
                            DM_ColosBaby(request, response);
                            break;
                        case "/DM_Coloscare":
                            DM_ColosCare(request, response);
                            break;   
                        case "/DM_Goodheald":
                            DM_Goodheald(request, response);
                            break;  
                        case "/DM_Ildong":
                            DM_Ildong(request, response);
                            break;          
//                        default:
//                            Trangchu(request, response);
//                            break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
    }

     private void DM_Vinamilk(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
                List<SanPhamModel> dssp= spdao.getSPSuaBot_Vinamilk();
                request.setAttribute("dssp", dssp);
                 int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/DanhMuc/Suabot_Vinamilk.jsp");
		rd.forward(request, response);
               
	}
     private void DM_Abbott(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
                List<SanPhamModel> dssp= spdao.getSPSuaBot_Abbott();
                request.setAttribute("dssp", dssp);
                int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/DanhMuc/Suabot_Abbott.jsp");
		rd.forward(request, response);
                
	}
     private void DM_Milo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
                List<SanPhamModel> dssp= spdao.getSPSuaBot_Milo();
                request.setAttribute("dssp", dssp);
                int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/DanhMuc/Suabot_Milo.jsp");
		rd.forward(request, response);
                
	}
     private void DM_Nestle(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
                List<SanPhamModel> dssp= spdao.getSPSuaBot_Nestle();
                request.setAttribute("dssp", dssp);
                int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/DanhMuc/Suabot_Nestle.jsp");
		rd.forward(request, response);
                
	}
     private void DM_Anlene(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
                List<SanPhamModel> dssp= spdao.getSPSuaBot_Anlene();
                request.setAttribute("dssp", dssp);
                 int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/DanhMuc/Suabot_Anlene.jsp");
		rd.forward(request, response);
               
	}
     private void DM_Nutifood(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
                List<SanPhamModel> dssp= spdao.getSPSuabot_Nutifood();
                request.setAttribute("dssp", dssp);
                int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/DanhMuc/Suabot_Nutifood.jsp");
		rd.forward(request, response);
                
	}
     private void DM_Physiolac(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
                List<SanPhamModel> dssp= spdao.getSPSuabot_Physiolac();
                request.setAttribute("dssp", dssp);
                int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/DanhMuc/Suabot_Physiolac.jsp");
		rd.forward(request, response);
                
	}
     private void DM_BenhThan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
                List<SanPhamModel> dssp= spdao.getSPSuaDacTri_BenhThan();
                request.setAttribute("dssp", dssp);
                 int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/DanhMuc/Suadactri_BenhThan.jsp");
		rd.forward(request, response);
               
	}
     private void DM_UngThu(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
                List<SanPhamModel> dssp= spdao.getSPSuaDacTri_UngThu();
                request.setAttribute("dssp", dssp);
                int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/DanhMuc/Suadactri_UngThu.jsp");
		rd.forward(request, response);
                
	}
     private void DM_DaDay(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
                List<SanPhamModel> dssp= spdao.getSPSuaDacTri_DaDay();
                request.setAttribute("dssp", dssp);
                 int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/DanhMuc/Suadactri_DaDay.jsp");
		rd.forward(request, response);
               
	}
     private void DM_CaoTuoi(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
                List<SanPhamModel> dssp= spdao.getSPSuaDacTri_CaoTuoi();
                request.setAttribute("dssp", dssp);
                int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/DanhMuc/Suadactri_Caotuoi.jsp");
		rd.forward(request, response);
                
	}
    private void DM_XuongKhop(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
                List<SanPhamModel> dssp= spdao.getSPSuaDacTri_XuongKhop();
                request.setAttribute("dssp", dssp);
                int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/DanhMuc/Suadactri_XuongKhop.jsp");
		rd.forward(request, response);
                
	}
    private void DM_NguoiGay(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
                List<SanPhamModel> dssp= spdao.getSPSuaDacTri_NguoiGay();
                request.setAttribute("dssp", dssp);
                 int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/DanhMuc/Suadactri_tangcan.jsp");
		rd.forward(request, response);
               
	}
    private void DM_TieuDuong(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
                List<SanPhamModel> dssp= spdao.getSPSuaDacTri_TieuDuong();
                request.setAttribute("dssp", dssp);
                int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/DanhMuc/Suadactri_Tieuduong.jsp");
		rd.forward(request, response);
                
    }
    private void DM_Ildong(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
                List<SanPhamModel> dssp= spdao.getSPSuanon_ILDONG();
                request.setAttribute("dssp", dssp);
                 int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/DanhMuc/Suanon_ILDONG.jsp");
		rd.forward(request, response);
               
	}
    private void DM_ColosBaby(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
                List<SanPhamModel> dssp= spdao.getSPSuaColosBaby();
                request.setAttribute("dssp", dssp);
                 int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/DanhMuc/Suanon_ColosBaby.jsp");
		rd.forward(request, response);
               
	}
    private void DM_ColosCare(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
                List<SanPhamModel> dssp= spdao.getSPSuaColossCare();
                request.setAttribute("dssp", dssp);
                 int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/DanhMuc/Suanon_ColossCare.jsp");
		rd.forward(request, response);
               
	}
    private void DM_Goodheald(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
                List<SanPhamModel> dssp= spdao.getSPSuaGoodhealth();
                request.setAttribute("dssp", dssp);
                int iduser=Integer.parseInt(request.getParameter("id"));
                User user=userdao.searchUserbyId(iduser);
                request.setAttribute("user", user);
		RequestDispatcher rd= request.getRequestDispatcher("/View/DanhMuc/Suanon_Goodhealth.jsp");
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
