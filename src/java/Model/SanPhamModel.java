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
public class SanPhamModel {
    private int id;
    private String tensp;
    private float gia;
    private String loaisp;// sua non/ sua dac tri
    private String hangsp;// vinamilk, nuti..
    private String doituongsp;//nguoi gia/ nguoi truong thanh/ tre em
    private String hinhanh;
    private String gioithieusp;
    private int soluong;
    private int daban;

    public SanPhamModel(int id, String tensp, float gia, String loaisp, String hangsp, String doituongsp, String hinhanh, String gioithieusp, int soluong, int daban) {
        this.id = id;
        this.tensp = tensp;
        this.gia = gia;
        this.loaisp = loaisp;
        this.hangsp = hangsp;
        this.doituongsp = doituongsp;
        this.hinhanh = hinhanh;
        this.gioithieusp = gioithieusp;
        this.soluong = soluong;
        this.daban = daban;
    }

    public SanPhamModel(String hangsp, String doituongsp) {
        this.hangsp = hangsp;
        this.doituongsp = doituongsp;
    }

    public SanPhamModel(String tensp) {
        this.tensp = tensp;
    }

    public SanPhamModel(int id) {
        this.id = id;
    }

    public SanPhamModel(int id, String tensp, float gia, String loaisp, String hinhanh, int daban) {
        this.id = id;
        this.tensp = tensp;
        this.gia = gia;
        this.loaisp = loaisp;
        this.hinhanh = hinhanh;
        this.daban = daban;
    }

    public SanPhamModel(String tensp, float gia, String loaisp, String hangsp, String doituongsp, String hinhanh, String gioithieusp, int soluong, int daban) {
        this.tensp = tensp;
        this.gia = gia;
        this.loaisp = loaisp;
        this.hangsp = hangsp;
        this.doituongsp = doituongsp;
        this.hinhanh = hinhanh;
        this.gioithieusp = gioithieusp;
        this.soluong = soluong;
        this.daban = daban;
    }

    public SanPhamModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    public String getHangsp() {
        return hangsp;
    }

    public void setHangsp(String hangsp) {
        this.hangsp = hangsp;
    }

    public String getDoituongsp() {
        return doituongsp;
    }

    public void setDoituongsp(String doituongsp) {
        this.doituongsp = doituongsp;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getGioithieusp() {
        return gioithieusp;
    }

    public void setGioithieusp(String gioithieusp) {
        this.gioithieusp = gioithieusp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDaban() {
        return daban;
    }

    public void setDaban(int daban) {
        this.daban = daban;
    }

   
}
