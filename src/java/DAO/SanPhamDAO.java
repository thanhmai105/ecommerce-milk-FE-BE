/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.SanPhamModel;
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
public class SanPhamDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public SanPhamDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
     
    public boolean addSP(SanPhamModel sp) throws SQLException {
        String sql = "INSERT INTO sanpham(tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban) VALUES(?,?,?,?,?,?,?,?,?)";
            connect();
                PreparedStatement ps =jdbcConnection.prepareStatement(sql); 
                ps.setString(1,sp.getTensp());
                ps.setFloat(2, sp.getGia());
                ps.setString(3, sp.getLoaisp());
                ps.setString(4, sp.getHangsp());
                ps.setString(4, sp.getDoituongsp());
                ps.setString(6,sp.getHinhanh());
                ps.setString(7, sp.getGioithieusp());
                ps.setInt(8, sp.getSoluong());
                ps.setInt(9, sp.getDaban()); 
        boolean rowInserted = ps.executeUpdate() > 0;
        ps.close();
        disconnect();
        return rowInserted;
    }
    public List<SanPhamModel> getDsSanPham() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham";
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }
   
    public boolean deleteSP(SanPhamModel sp) throws SQLException {
        String sql = "DELETE FROM sanpham where id = ?";
         
        connect();  
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, sp.getId());
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateSP(SanPhamModel sp) throws SQLException {
        String sql = "UPDATE sanpham SET tensp = ?, gia = ?, loaisp = ?, hangsp=?, doituongsp=?, hinhanh=?,gioithieusp=?,soluong=? WHERE id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, sp.getTensp());
        statement.setFloat(2, sp.getGia());
        statement.setString(3,sp.getLoaisp());
        statement.setString(4,sp.getHangsp());
        statement.setString(5,sp.getDoituongsp());
        statement.setString(6,sp.getHinhanh());
        statement.setString(7, sp.getGioithieusp());
        statement.setInt(8, sp.getSoluong());
         statement.setInt(9, sp.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public SanPhamModel searchSanPhambyId(int id) throws SQLException {
        SanPhamModel sp = null;
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban from sanpham where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet rs = statement.executeQuery();
         
        if (rs.next()) {
            sp= new SanPhamModel(id,
                    rs.getString("tensp"), 
                    rs.getFloat("gia"), 
                    rs.getString("loaisp"), 
                    rs.getString("hangsp"), 
                    rs.getString("doituongsp"),
                    rs.getString("hinhanh"),
                    rs.getString("gioithieusp"),
                    rs.getInt("soluong"),
                    rs.getInt("daban"));
        }
         
        rs.close();
        statement.close();
         disconnect();
        return sp;
    }
    
    private String []listten={"Dielac","Grow","Sure","Optimum","Gold","Úc","Pedia","Nepro","Colos","men","tre",
    "Vinamilk","Nutifood","Abbott","Anlene","Milo","Nestle","Physiolac","Vitadairy","Nutricare","Goodhealth","ILDONG",
    "cao tuoi","than","da day","gay","tieu duong"};
    public List<SanPhamModel> searchSanPhambyTen(SanPhamModel spm) throws SQLException {
        List<SanPhamModel> list=new ArrayList<>();
        String ten=spm.getTensp();
        ten.toLowerCase();
        String tens="";
            for(String wString:listten){
                String w=wString.toLowerCase();
                if(ten.contains(w)){
                    tens=tens+"( tensp like '%"+ wString +"%' ) "+"or ";
                } 
            }
            tens=tens.substring(0, tens.length()-3);

            String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban from sanpham "
                    + "where tensp like"+tens;
            connect();

            Statement ps =jdbcConnection.createStatement();               
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()){
                SanPhamModel sp= new SanPhamModel(rs.getInt(1),
                    rs.getString(2), 
                    rs.getFloat(3), 
                    rs.getString(4), 
                    rs.getString(5), 
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getInt(9),
                    rs.getInt(10));
                list.add(sp);
            } 
            rs.close();
            ps.close();
            disconnect();
        return list;
    }
    
    public List<SanPhamModel> searchSanPham(SanPhamModel spm) throws SQLException {
        List<SanPhamModel> list=new ArrayList<>();
        String hang=spm.getHangsp();
        String doituong=spm.getDoituongsp();
        String ten="";
            if(!hang.isEmpty()){
                ten=ten+"( tensp = '"+ hang +"' ) "+"or ";
            }
            if(!doituong.isEmpty()){
                ten=ten+"( doituongsp = '"+doituong +"' ) "+"or ";
            }
            if(!doituong.isEmpty() || !hang.isEmpty()) ten=ten.substring(0,ten.length()-3);
            String sql;
            if(doituong.isEmpty() && hang.isEmpty()){
                sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban from sanpham ";
            }
            else{
                sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban from sanpham "
                    + "where "+ten;
            }
            
            connect();

            Statement ps =jdbcConnection.createStatement();               
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()){
                SanPhamModel sp= new SanPhamModel(rs.getInt(1),
                    rs.getString(2), 
                    rs.getFloat(3), 
                    rs.getString(4), 
                    rs.getString(5), 
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getInt(9),
                    rs.getInt(10));
                list.add(sp);
            } 
            rs.close();
            ps.close();
            disconnect();
        return list;
    }
    public List<SanPhamModel> getSPBanChay() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ORDER BY daban DESC";
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }
    public List<SanPhamModel> getSPMoiNhat() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ORDER BY id DESC";
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }
    public List<SanPhamModel> getSPSuaBot() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham WHERE loaisp='Sua bot'";
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }
    public List<SanPhamModel> getSPSuaNon() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham WHERE loaisp='Sua non'";
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }
    public List<SanPhamModel> getSPSuaDacTri() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
        sql=sql+"WHERE doituongsp='cao tuoi' OR doituongsp='da day' OR doituongsp='benh than' OR doituongsp='tang can'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }
     public List<SanPhamModel> getSPSuaBot_Vinamilk() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
        sql=sql+"WHERE loaisp='Sua bot' AND hangsp='Vinamilk'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }
    public List<SanPhamModel> getSPSuaBot_Abbott() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
        sql=sql+"WHERE loaisp='Sua bot' AND hangsp='Abbott'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }
    public List<SanPhamModel> getSPSuaBot_Anlene() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
       sql=sql+"WHERE loaisp='Sua bot' AND hangsp='Anlene'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }
    public List<SanPhamModel> getSPSuaBot_Milo() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
       sql=sql+"WHERE loaisp='Sua bot' AND hangsp='Milo'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }
    public List<SanPhamModel> getSPSuaBot_Nestle() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
       sql=sql+"WHERE loaisp='Sua bot' AND hangsp='Nestle'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }
    
    public List<SanPhamModel> getSPSuabot_Nutifood() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
       sql=sql+"WHERE loaisp='Sua bot' AND hangsp='Nutifood'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }
public List<SanPhamModel> getSPSuabot_Physiolac() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
       sql=sql+"WHERE loaisp='Sua bot' AND hangsp='Physiolac'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }

public List<SanPhamModel> getSPSuaDacTri_BenhThan() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
        sql=sql+"WHERE doituongsp='benh than'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }

public List<SanPhamModel> getSPSuaDacTri_CaoTuoi() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
        sql=sql+"WHERE doituongsp='cao tuoi'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }

public List<SanPhamModel> getSPSuaDacTri_DaDay() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
        sql=sql+"WHERE doituongsp='da day'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }
public List<SanPhamModel> getSPSuaDacTri_TieuDuong() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
        sql=sql+"WHERE doituongsp='tieu duong'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }

public List<SanPhamModel> getSPSuaDacTri_UngThu() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
        sql=sql+"WHERE doituongsp='ung thu'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }
public List<SanPhamModel> getSPSuaDacTri_XuongKhop() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
        sql=sql+"WHERE doituongsp='xuong khop'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }
public List<SanPhamModel> getSPSuaDacTri_NguoiGay() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
        sql=sql+"WHERE doituongsp='tang can'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }

public List<SanPhamModel> getSPSuanon_ILDONG() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
        sql=sql+"WHERE hangsp='ILDONG FOODIS Korea'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }

public List<SanPhamModel> getSPSuaColosBaby() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
        sql=sql+"WHERE hangsp='Vitadairy'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }
public List<SanPhamModel> getSPSuaColossCare() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
        sql=sql+"WHERE hangsp='Nutricare'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }
public List<SanPhamModel> getSPSuaGoodhealth() throws SQLException
    {
        connect();
        List<SanPhamModel> dssp = new ArrayList<>();
        String sql = "SELECT id,tensp,gia,loaisp,hangsp,doituongsp,hinhanh,gioithieusp,soluong,daban FROM sanpham ";
        sql=sql+"WHERE hangsp='Goodhealth – NewZealand'" ;
           
                Statement ps =jdbcConnection.createStatement();               
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    SanPhamModel sp = new SanPhamModel(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)    
                    );
                    dssp.add(sp);
                }
                
                rs.close();
                ps.close();
                disconnect();
        return dssp;
    }
    
}
