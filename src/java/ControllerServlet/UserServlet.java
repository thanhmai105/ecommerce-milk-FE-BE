
package ControllerServlet;

import DAO.UserDAO;

import Model.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/TrangQLKH","/listKH","/newKH", "/insertKH" ,"/editKH" ,"/updateKH" ,"/deleteKH"})
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    @Override
    
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);

    }

    public UserServlet() {
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/TrangQLKH":
                    TrangQLKhachHang(request, response);
                    break;
                case "/newKH":
                    showNewForm(request, response);
                    break;
                case "/insertKH":
                    insertUser(request, response);
                    break;
                case "/deleteKH":
                    deleteUser(request, response);
                    break;
                case "/editKH":
                    showEditForm(request, response);
                    break;
                case "/updateKH":
                    updateUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void TrangQLKhachHang(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        RequestDispatcher rd= request.getRequestDispatcher("/View/Admin/quanlyKH.jsp");
        rd.forward(request, response); 
    }
    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> dsuser = userDAO.getDsUser();
        request.setAttribute("dsuser", dsuser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Admin/quanlyKH.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Admin/form_updateKH.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.searchUserbyId(id);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Admin/form_updateKH.jsp");
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String hoten = request.getParameter("hoten");
        String email = request.getParameter("email");
        String sdt = request.getParameter("sdt");
        String taikhoan = request.getParameter("username");
        String matkhau = request.getParameter("password");
        String chucvu = request.getParameter("chucvu");
        
        User user = new User(hoten, email, sdt, taikhoan, matkhau, chucvu);
        userDAO.addUser(user);
        response.sendRedirect("listKH");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String hoten = request.getParameter("hoten");
        String email = request.getParameter("email");
        String sdt = request.getParameter("sdt");
        String taikhoan = request.getParameter("username");
        String matkhau = request.getParameter("password");
        String chucvu = request.getParameter("chucvu");
        
        User user = new User(hoten, email, sdt, taikhoan, matkhau, chucvu);
        userDAO.updateUser(user);
        response.sendRedirect("listKH");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = new User(id);
        userDAO.deleteUser(user);
        response.sendRedirect("listKH");

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
