package model;

public class DanhSachThietBi {
	private Long ID_P;
    private Long ID_TB;
    private Long SoLuong = 0L;
    private Boolean active = true;

	public DanhSachThietBi() {
	}

	public DanhSachThietBi(Long iD_P, Long iD_TB, Long soLuong) {
		ID_P = iD_P;
		ID_TB = iD_TB;
		SoLuong = soLuong;
	}

	public DanhSachThietBi(Long iD_P, Long iD_TB, Long soLuong, Boolean active) {
		ID_P = iD_P;
		ID_TB = iD_TB;
		SoLuong = soLuong;
		this.active = active;
	}

	public Long getID_P() {
		return ID_P;
	}

	public void setID_P(Long iD_P) {
		ID_P = iD_P;
	}

	public Long getID_TB() {
		return ID_TB;
	}

	public void setID_TB(Long iD_TB) {
		ID_TB = iD_TB;
	}

	public Long getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(Long soLuong) {
		SoLuong = soLuong;
	}
    
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
