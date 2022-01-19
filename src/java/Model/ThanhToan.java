package Model;

public class ThanhToan {

    protected int id;
    protected String name;
    protected String email;
    protected String sdt;
    protected String diachi;
    protected String phuongthucvanchuyen;
    protected String hinhthucthanhtoan;

    public ThanhToan() {
        super();
    }

    public ThanhToan(String name, String email, String sdt, String diachi, String phuongthucvanchuyen,
            String hinhthucthanhtoan) {
        super();
        this.name = name;
        this.email = email;
        this.sdt = sdt;
        this.diachi = diachi;
        this.phuongthucvanchuyen = phuongthucvanchuyen;
        this.hinhthucthanhtoan = hinhthucthanhtoan;
    }

    public ThanhToan(int id, String name, String email, String sdt, String diachi, String phuongthucvanchuyen,
            String hinhthucthanhtoan) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.sdt = sdt;
        this.diachi = diachi;
        this.phuongthucvanchuyen = phuongthucvanchuyen;
        this.hinhthucthanhtoan = hinhthucthanhtoan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
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

}
