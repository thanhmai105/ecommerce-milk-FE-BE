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
public class User {
    private int id;
    private String hoten;
    private String email;
    private String sdt;
    private String username;
    private String password;
    private String chucvu;

    public User(int id, String hoten, String email, String sdt, String username, String password, String chucvu) {
        this.id = id;
        this.hoten = hoten;
        this.email = email;
        this.sdt = sdt;
        this.username = username;
        this.password = password;
        this.chucvu = chucvu;
    }

    public User(String hoten, String email, String sdt, String username, String password, String chucvu) {
        this.hoten = hoten;
        this.email = email;
        this.sdt = sdt;
        this.username = username;
        this.password = password;
        this.chucvu = chucvu;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id) {
        this.id = id;
    }
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

   
}
