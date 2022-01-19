package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.ThanhToan;

public class ThanhtoanDAO {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public ThanhtoanDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

    public int insertdonhang(ThanhToan thanhtoan) throws SQLException {
        
//            PreparedStatement preparedStatement = jdbcConnection.prepareStatement(sql);
//            preparedStatement.setString(1, thanhtoan.getName());
//            preparedStatement.setString(2, thanhtoan.getEmail());
//            preparedStatement.setString(3, thanhtoan.getSdt());
//            preparedStatement.setString(4, thanhtoan.getDiachi());
//            preparedStatement.setString(5, thanhtoan.getPhuongthucvanchuyen());
//            preparedStatement.setString(6, thanhtoan.getHinhthucthanhtoan());
//            
//        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
//        preparedStatement.close();
//        disconnect();
//        return rowUpdated;  
//        
        
        String sql = "INSERT INTO thanhtoan (name, email, sdt, diachi, phuongthucvanchuyen, hinhthucthanhtoan) VALUES(?,?,?,?,?,?)";
            connect();
                int result=0;
                PreparedStatement ps =jdbcConnection.prepareStatement(sql); 
                ps.setString(1,thanhtoan.getName());
                ps.setString(2, thanhtoan.getEmail());
                ps.setString(3, thanhtoan.getSdt());
                ps.setString(4, thanhtoan.getDiachi());
                ps.setString(5, thanhtoan.getPhuongthucvanchuyen());
                ps.setString(6,thanhtoan.getHinhthucthanhtoan());
               
        result = ps.executeUpdate();
        disconnect();
        return result;
    }
//     public ThanhToan searchDonhangbyId(int id) throws SQLException {
//        ThanhToan thanhtoan = null;
//        String sql = "SELECT *from thanhtoan where id = ?";
//         
//        connect();
//         
//        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setInt(1, id);
//         
//        ResultSet rs = statement.executeQuery();
//         
//        if (rs.next()) {
//            thanhtoan=  new ThanhToan(id,
//                    rs.getString("hoten"), 
//                    rs.getString("email"), 
//                    rs.getString("sdt"), 
//                    rs.getString("username"), 
//                    rs.getString("password"),
//                    rs.getString("chucvu")
//            );
//        }
//         
//        rs.close();
//        statement.close();
//        return thanhtoan;
//    }
}
