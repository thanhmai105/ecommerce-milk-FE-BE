/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class DonHangModel {
    private int id;
    private String tenkh;
    private String trangthai;
    private String phuongthucvanchuyen;
    private String hinhthucthanhtoan;
    private String diachinguoinhan;
    private String sdtKH;
    private String thongtinsanpham;
    private int idUser;

    public DonHangModel(int id, String trangthai, String phuongthucvanchuyen, String hinhthucthanhtoan, String diachinguoinhan, String sdtKH, String thongtinsanpham, int idUser) {
        this.id = id;
        this.trangthai = trangthai;
        this.phuongthucvanchuyen = phuongthucvanchuyen;
        this.hinhthucthanhtoan = hinhthucthanhtoan;
        this.diachinguoinhan = diachinguoinhan;
        this.sdtKH = sdtKH;
        this.thongtinsanpham = thongtinsanpham;
        this.idUser = idUser;
    }

    public DonHangModel(String phuongthucvanchuyen, String hinhthucthanhtoan, String diachinguoinhan, String thongtinsanpham, int idUser) {
        this.phuongthucvanchuyen = phuongthucvanchuyen;
        this.hinhthucthanhtoan = hinhthucthanhtoan;
        this.diachinguoinhan = diachinguoinhan;
        this.thongtinsanpham = thongtinsanpham;
        this.idUser = idUser;
    }

    public DonHangModel(String tenkh, String phuongthucvanchuyen, String hinhthucthanhtoan, String diachinguoinhan, String sdtKH, String thongtinsanpham, int idUser) {
        this.tenkh = tenkh;
        this.phuongthucvanchuyen = phuongthucvanchuyen;
        this.hinhthucthanhtoan = hinhthucthanhtoan;
        this.diachinguoinhan = diachinguoinhan;
        this.sdtKH = sdtKH;
        this.thongtinsanpham = thongtinsanpham;
        this.idUser = idUser;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public DonHangModel(String tenkh) {
        this.tenkh = tenkh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getPhuongthucvanchuyen() {
        return phuongthucvanchuyen;
    }

    public void setPhuongthucvanchuyen(String phuongthucvanchuyen) {
        this.phuongthucvanchuyen = phuongthucvanchuyen;
    }

    public String getHinhthucthanhtoan() {
        return hinhthucthanhtoan;
    }

    public void setHinhthucthanhtoan(String hinhthucthanhtoan) {
        this.hinhthucthanhtoan = hinhthucthanhtoan;
    }

    public String getDiachinguoinhan() {
        return diachinguoinhan;
    }

    public void setDiachinguoinhan(String diachinguoinhan) {
        this.diachinguoinhan = diachinguoinhan;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }

    public String getThongtinsanpham() {
        return thongtinsanpham;
    }

    public void setThongtinsanpham(String thongtinsanpham) {
        this.thongtinsanpham = thongtinsanpham;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    
}
