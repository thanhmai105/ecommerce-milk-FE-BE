package DAO;

import Model.DonHangModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DonHangDAO {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public DonHangDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

    public int saveDH(DonHangModel dh) throws SQLException {
        String sql = "INSERT INTO donhang(tenkh,phuongthucvanchuyen,hinhthucthanhtoan,diachinguoinhan,sdtKH,thongtinsanpham,idUser) VALUE(?,?,?,?,?,?,?)";
            connect();
            int  rowInserted=0;
                PreparedStatement ps =jdbcConnection.prepareStatement(sql); 
                ps.setString(1, dh.getTenkh());
                ps.setString(2, dh.getPhuongthucvanchuyen());
                ps.setString(3, dh.getHinhthucthanhtoan());
                ps.setString(4,dh.getDiachinguoinhan());
                ps.setString(5,dh.getSdtKH());
                ps.setInt(6,dh.getIdUser());
                ps.setString(7, dh.getThongtinsanpham()); 
        rowInserted = ps.executeUpdate() ;
        ps.close();
        disconnect();
        return rowInserted;
    }
}
