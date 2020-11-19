package model;

import java.util.Date;

public class ThuePhong {
	private Long ID;
	private Long ID_KH;
	private Date NgayDangKi;
	private Date NgayDen;
	private Date NgayHenDi;
	private Date NgayDi;
	private Long TienCoc;

	public ThuePhong() {
	}
	
	public ThuePhong(Long iD, Long iD_KH, Date ngayDangKi, Date ngayDen, Date ngayHenDi, Date ngayDi, Long tienCoc) {
		ID = iD;
		ID_KH = iD_KH;
		NgayDangKi = ngayDangKi;
		NgayDen = ngayDen;
		NgayHenDi = ngayHenDi;
		NgayDi = ngayDi;
		TienCoc = tienCoc;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Long getID_KH() {
		return ID_KH;
	}

	public void setID_KH(Long iD_KH) {
		ID_KH = iD_KH;
	}

	public Date getNgayDangKi() {
		return NgayDangKi;
	}

	public void setNgayDangKi(Date ngayDangKi) {
		NgayDangKi = ngayDangKi;
	}

	public Date getNgayDen() {
		return NgayDen;
	}

	public void setNgayDen(Date ngayDen) {
		NgayDen = ngayDen;
	}

	public Date getNgayHenDi() {
		return NgayHenDi;
	}

	public void setNgayHenDi(Date ngayHenDi) {
		NgayHenDi = ngayHenDi;
	}

	public Date getNgayDi() {
		return NgayDi;
	}

	public void setNgayDi(Date ngayDi) {
		NgayDi = ngayDi;
	}

	public Long getTienCoc() {
		return TienCoc;
	}

	public void setTienCoc(Long tienCoc) {
		TienCoc = tienCoc;
	}
}
