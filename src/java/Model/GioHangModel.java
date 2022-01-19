/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class GioHangModel {
    private String hinhanh;
    private String tensp;
     private String loaisp;
    private float gia;
    private int soluong;
    private int idUser;
    private int idsp;
    private float gia1;

    public GioHangModel(String hinhanh, String tensp, String loaisp, float gia, int soluong, int idUser, int idsp) {
        this.hinhanh = hinhanh;
        this.tensp = tensp;
        this.loaisp = loaisp;
        this.gia = gia;
        this.soluong = soluong;
        this.idUser = idUser;
        this.idsp = idsp;
    }

    public float getGia1() {
        return gia1;
    }

    public void setGia1(float gia1) {
        this.gia1 = gia1;
    }

    public GioHangModel(String hinhanh, String tensp, String loaisp, float gia, int soluong, int idUser, int idsp, float gia1) {
        this.hinhanh = hinhanh;
        this.tensp = tensp;
        this.loaisp = loaisp;
        this.gia = gia;
        this.soluong = soluong;
        this.idUser = idUser;
        this.idsp = idsp;
        this.gia1 = gia1;
    }

    public GioHangModel(int idUser, int idsp) {
        this.idUser = idUser;
        this.idsp = idsp;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }

   
    
}
