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
public class ChitietSP {
    private int idsp;
    private String congdung;
    private String hdsd;
    private String hdsd2;
    private String hinhanh1;
    private String hinhanh2;
    private String hinhanh3;

    public ChitietSP(int idsp) {
        this.idsp = idsp;
    }

    public ChitietSP(int idsp, String congdung, String hdsd, String hdsd2, String hinhanh1, String hinhanh2, String hinhanh3) {
        this.idsp = idsp;
        this.congdung = congdung;
        this.hdsd = hdsd;
        this.hdsd2 = hdsd2;
        this.hinhanh1 = hinhanh1;
        this.hinhanh2 = hinhanh2;
        this.hinhanh3 = hinhanh3;
    }

    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }

    public String getCongdung() {
        return congdung;
    }

    public void setCongdung(String congdung) {
        this.congdung = congdung;
    }

    public String getHdsd() {
        return hdsd;
    }

    public void setHdsd(String hdsd) {
        this.hdsd = hdsd;
    }

    public String getHdsd2() {
        return hdsd2;
    }

    public void setHdsd2(String hdsd2) {
        this.hdsd2 = hdsd2;
    }

    public String getHinhanh1() {
        return hinhanh1;
    }

    public void setHinhanh1(String hinhanh1) {
        this.hinhanh1 = hinhanh1;
    }

    public String getHinhanh2() {
        return hinhanh2;
    }

    public void setHinhanh2(String hinhanh2) {
        this.hinhanh2 = hinhanh2;
    }

    public String getHinhanh3() {
        return hinhanh3;
    }

    public void setHinhanh3(String hinhanh3) {
        this.hinhanh3 = hinhanh3;
    }

   
}
