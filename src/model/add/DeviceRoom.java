package model.add;

public class DeviceRoom{
	private String tenTB;
	private Long soLuong;
	
	public DeviceRoom() {
	}


	public DeviceRoom(String tenTB, Long soLuong) {
		this.tenTB = tenTB;
		this.soLuong = soLuong;
	}


	public String getTenTB() {
		return tenTB;
	}


	public void setTenTB(String tenTB) {
		this.tenTB = tenTB;
	}


	public Long getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(Long soLuong) {
		this.soLuong = soLuong;
	}
}
