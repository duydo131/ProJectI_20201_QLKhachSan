package model;

public class DangNhap {
    private String username;
    private String password;
    private String maNV;
    private int id;

    public DangNhap() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DangNhap(String username, String password, String maNV, int id) {
        this.username = username;
        this.password = password;
        this.maNV = maNV;
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
