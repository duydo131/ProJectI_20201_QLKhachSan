package model;

public class ChiTietThuePhong {
	private Long ID;
    private Long ID_P;
    
	public ChiTietThuePhong() {
	}

	public ChiTietThuePhong(Long iD, Long iD_P) {
		ID = iD;
		ID_P = iD_P;
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
}
