package model;

public class Phong {
	private Long ID;
    private String LoaiPhong;
    private Long GiaPhong;
    private String TinhTrang = "";
    
	public Phong() {
	}

	public Phong(Long iD, String loaiPhong, Long giaPhong, String tinhTrang) {
		ID = iD;
		LoaiPhong = loaiPhong;
		GiaPhong = giaPhong;
		TinhTrang = tinhTrang;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getLoaiPhong() {
		return LoaiPhong;
	}

	public void setLoaiPhong(String loaiPhong) {
		LoaiPhong = loaiPhong;
	}

	public Long getGiaPhong() {
		return GiaPhong;
	}

	public void setGiaPhong(Long giaPhong) {
		GiaPhong = giaPhong;
	}

	public String getTinhTrang() {
		return TinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		TinhTrang = tinhTrang;
	}
}
