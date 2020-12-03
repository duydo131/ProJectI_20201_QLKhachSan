package model;

import java.util.Date;

public class ChiTietThuePhong {
	private Long ID;
    private Long ID_P;
    private Date NgayTraPhong;
	private String TrangThai;
	private Long TienPhat;
	private String GhiChu;
	private Boolean active = true;
    
	public ChiTietThuePhong() {
	}

	public ChiTietThuePhong(Long iD, Long iD_P, Date ngayTraPhong, String trangThai, Long tienPhat, String ghiChu) {
		ID = iD;
		ID_P = iD_P;
		NgayTraPhong = ngayTraPhong;
		TrangThai = trangThai;
		TienPhat = tienPhat;
		GhiChu = ghiChu;
	}

	public ChiTietThuePhong(Long iD, Long iD_P, Date ngayTraPhong, String trangThai, Long tienPhat, String ghiChu,
			Boolean active) {
		ID = iD;
		ID_P = iD_P;
		NgayTraPhong = ngayTraPhong;
		TrangThai = trangThai;
		TienPhat = tienPhat;
		GhiChu = ghiChu;
		this.active = active;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Long getID_P() {
		return ID_P;
	}

	public void setID_P(Long iD_P) {
		ID_P = iD_P;
	}

    public Date getNgayTraPhong() {
		return NgayTraPhong;
	}

	public void setNgayTraPhong(Date ngayTraPhong) {
		NgayTraPhong = ngayTraPhong;
	}

	public String getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}

	public Long getTienPhat() {
		return TienPhat;
	}

	public void setTienPhat(Long tienPhat) {
		TienPhat = tienPhat;
	}

	public String getGhiChu() {
		return GhiChu;
	}

	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
