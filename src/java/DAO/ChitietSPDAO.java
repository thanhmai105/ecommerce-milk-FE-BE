/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ChitietSP;
import Model.SanPhamModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ChitietSPDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public ChitietSPDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
            jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb?useSSL=false","root", "1234");
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    public boolean addSP(ChitietSP sp) throws SQLException {
        String sql = "INSERT INTO chitietsp(idsp,congdung,hdsd,hdsd2,hinhanh1,hinhanh2,hinhanh3) VALUES(?,?,?,?,?,?,?)";
            connect();
                PreparedStatement ps =jdbcConnection.prepareStatement(sql); 
                ps.setInt(8, sp.getIdsp());
                ps.setString(1,sp.getCongdung());
                ps.setString(2, sp.getHdsd());
                ps.setString(3, sp.getHdsd2());
                ps.setString(4, sp.getHinhanh1());
                ps.setString(4, sp.getHinhanh2());
                ps.setString(6,sp.getHinhanh3());
                ps.executeUpdate();
        boolean rowInserted = ps.executeUpdate() > 0;
        ps.close();
        disconnect();
        return rowInserted;
    }
    public ChitietSP searchSanPhambyId(int idsp) throws SQLException {
        ChitietSP sp = null;
        String sql = "SELECT idsp,congdung,hdsd,hdsd2,hinhanh1,hinhanh2,hinhanh3 from chitietsp where idsp = ?";       
        connect();   
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, idsp);
         
        ResultSet rs = statement.executeQuery();
         
        if (rs.next()) {
            sp= new ChitietSP(idsp,
                    rs.getString("congdung"), 
                    rs.getString("hdsd"), 
                    rs.getString("hdsd2"), 
                    rs.getString("hinhanh1"),
                    rs.getString("hinhanh2"),
                    rs.getString("hinhanh3"));
        }
         
        rs.close();
        statement.close();
         
        return sp;
    }
}
