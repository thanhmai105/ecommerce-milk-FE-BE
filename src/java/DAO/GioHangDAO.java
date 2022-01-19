/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.GioHangModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GioHangDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public GioHangDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb?useSSL=false", "root", "1234");
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    
    public int addSPGioHang(GioHangModel gh) throws SQLException {
        String sql = "INSERT INTO giohang(hinhanh,tensp,loaiSP,gia,soluong,idUser,idSP) VALUES(?,?,?,?,?,?,?)";
        connect();
        int rowadd=0;
        PreparedStatement ps = jdbcConnection.prepareStatement(sql);
        ps.setString(1, gh.getHinhanh());
        ps.setString(2, gh.getTensp());
        ps.setString(3, gh.getLoaisp());
        ps.setFloat(4, gh.getGia());
        ps.setInt(5, gh.getSoluong());
        ps.setInt(6, gh.getIdUser());
         ps.setInt(7, gh.getIdsp());
        
        rowadd = ps.executeUpdate();
        ps.close();
        disconnect();
        return rowadd;
    }
    
    public List<GioHangModel> getGioHang(int iduser) throws SQLException {
        connect();
        List<GioHangModel> dsspGH = new ArrayList<>();
        String sql = "SELECT hinhanh,tensp,loaiSP,gia,soluong,idUser,idSP FROM giohang where idUser=?";

        PreparedStatement ps = jdbcConnection.prepareStatement(sql);
        ps.setInt(1, iduser);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            GioHangModel giohang ;
                  String hinhanh=  rs.getString(1);
                    String tensp=rs.getString(2);
                    String loaisp =rs.getString(3);
                    Float gia = rs.getFloat(4);
                    int soluong =rs.getInt(5);
                   int idUser= rs.getInt(6);
                    int idsp=rs.getInt(7);
                   float gia1=gia*(float)soluong;
             giohang=new GioHangModel(hinhanh, tensp, loaisp, gia, soluong, idUser, idsp, gia1);
            dsspGH.add(giohang);   
        }
         rs.close();
        ps.close();
        disconnect();
        return dsspGH;
    }
    public int getSoLuong(int idsp,int idUser) throws SQLException {
        connect();
        List<GioHangModel> dsspGH = new ArrayList<>();
        String sql = "SELECT soluong FROM giohang where idUser = ? and idsp=?";

        PreparedStatement ps = jdbcConnection.prepareStatement(sql);
        ps.setInt(1, idUser);
        ps.setInt(2, idsp);
        ResultSet rs = ps.executeQuery();
        int soluong=rs.getInt("soluong");
         rs.close();
        ps.close();
        disconnect();
        return soluong;
    }
    public boolean deleteGiohang(int idsp,int idUser) throws SQLException
        {
            String sql = "DELETE FROM giohang where idUser = ? and idsp=?";
            connect();  
            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setInt(1, idUser);
            statement.setInt(2, idsp);
            boolean rowDeleted = statement.executeUpdate() > 0;
            statement.close();
            disconnect();
            return rowDeleted;   
         
        }
    public int Tangsl(int sl,int idUser,int idsp) throws SQLException {
        String sql = "UPDATE giohang SET soluong = ? WHERE idUser = ? and idSP=?";
        connect();
         int rowUpdated=0;
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, sl+1);
        statement.setInt(2, idUser);
        statement.setInt(3, idsp);
         
        rowUpdated = statement.executeUpdate();
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    public int Giamsl(int sl,int idUser,int idsp) throws SQLException {
        String sql = "UPDATE giohang SET soluong = ? WHERE idUser = ? and idSP=?";
        connect();
         int rowUpdated=0;
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, sl-1);
        statement.setInt(2, idUser);
        statement.setInt(3, idsp);
         
        rowUpdated = statement.executeUpdate();
        statement.close();
        disconnect();
        return rowUpdated;     
    }

    

//    public List<GioHangModel> showCart() {
//        
//    }
}
