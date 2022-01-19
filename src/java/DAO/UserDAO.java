/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.SanPhamModel;
import Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UserDAO{
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
   
    
    
    public boolean checkLogin(User user) throws SQLException{
        connect();
        boolean result=false;
        String sql="SELECT * FROM user WHERE username=? AND password=?";

            PreparedStatement ps=jdbcConnection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs=ps.executeQuery();
            result=rs.next();
            disconnect();
        return result;
    }
    public int addUser(User user) throws SQLException {
        String sql = "INSERT INTO user(hoten,email,sdt,username,password,chucvu) VALUES(?,?,?,?,?,?)";
            connect();
                int result=0;
                PreparedStatement ps =jdbcConnection.prepareStatement(sql); 
                ps.setString(1,user.getHoten());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getSdt());
                ps.setString(4, user.getUsername());
                ps.setString(5, user.getPassword());
                ps.setString(6,user.getChucvu());
               
        result = ps.executeUpdate();
        disconnect();
        return result;
    }
    
    public List<User> getDsUser() throws SQLException
    {
        connect();
        List<User> listUser = new ArrayList<>();
        String sql = "SELECT id,hoten,email,sdt,username,password,chucvu FROM user";
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    User user = new User(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)     
                    );
                    listUser.add(user);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return listUser;
    }
   
    public boolean deleteUser(User user) throws SQLException {
        String sql = "DELETE FROM user where id = ?";
         
        connect();  
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, user.getId());
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateUser(User user) throws SQLException {
        String sql = "UPDATE user SET hoten = ?, email = ?, sdt = ?, username=?, password=?, chucvu=? WHERE id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, user.getHoten());
        statement.setString(2, user.getEmail());
        statement.setString(3,user.getSdt());
        statement.setString(4,user.getUsername());
        statement.setString(5,user.getPassword());
        statement.setString(6,user.getChucvu());
       
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    public User searchUserbyId(int id) throws SQLException {
        User user = null;
        String sql = "SELECT *from user where id = ?";
         
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet rs = statement.executeQuery();
         
        if (rs.next()) {
            user= new User(id,
                    rs.getString("hoten"), 
                    rs.getString("email"), 
                    rs.getString("sdt"), 
                    rs.getString("username"), 
                    rs.getString("password"),
                    rs.getString("chucvu"));
        }
         
        rs.close();
        statement.close();
        disconnect();
        return user;
    }
     public User searchUserId(String username,String password) throws SQLException {
        User user = null;
        String sql="SELECT id,hoten,email,sdt,username,password,chucvu FROM user WHERE username=? AND password=?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, username);
         statement.setString(2, password);
        ResultSet rs = statement.executeQuery();
         
        if (rs.next()) {
            user= new User(rs.getInt("id"),
                    rs.getString("hoten"), 
                    rs.getString("email"), 
                    rs.getString("sdt"), 
                    rs.getString("username"), 
                    rs.getString("password"),
                    rs.getString("chucvu"));
        }
         
        rs.close();
        statement.close();
        disconnect();
        return user;
    }
     public static void main(String[] args) throws SQLException {
        UserDAO userdao=new UserDAO("jdbc:mysql://localhost:3306/webdb?useSSL=false","root", "Quynh1102*");
        User dssp=userdao.searchUserbyId(1);
        System.out.println(dssp);
    }

}
