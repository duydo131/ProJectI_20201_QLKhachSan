package model;

public class ChiTietThuePhong {
	private Long ID;
    private Long ID_P;
	private Boolean active = true;
    
	public ChiTietThuePhong() {
	}

	public ChiTietThuePhong(Long iD, Long iD_P) {
		this.ID = iD;
		this.ID_P = iD_P;
	}

	public ChiTietThuePhong(Long iD, Long iD_P, Boolean active) {
		this.ID = iD;
		this.ID_P = iD_P;
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

    public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
