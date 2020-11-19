package model;

import java.util.Date;

public class NhanVien {
	private Long ID;
	private String Ten;
	private Boolean GioiTinh;
	private Date NgaySinh;
	private String ChuyenMon;
	private String CMND;
	private String DienThoai;
	
	public NhanVien() {
	}

	public NhanVien(Long iD, String ten, Boolean gioiTinh, Date ngaySinh, String chuyenMon, String cMND,
			String dienThoai) {
		ID = iD;
		Ten = ten;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
		ChuyenMon = chuyenMon;
		CMND = cMND;
		DienThoai = dienThoai;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getTen() {
		return Ten;
	}

	public void setTen(String ten) {
		Ten = ten;
	}

	public Boolean getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public String getChuyenMon() {
		return ChuyenMon;
	}

	public void setChuyenMon(String chuyenMon) {
		ChuyenMon = chuyenMon;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public String getDienThoai() {
		return DienThoai;
	}

	public void setDienThoai(String dienThoai) {
		DienThoai = dienThoai;
	}
}
