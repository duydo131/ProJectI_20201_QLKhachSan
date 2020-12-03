package sample;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import dao.DanhSachThietBiDAO;
import dao.KhachHangDao;
import dao.NhanVienDAO;
import dao.PhongDAO;
import dao.ThietBiDAO;
import daoimpl.DanhSachThietBiDAOimpl;
import daoimpl.KhachHangDaoImpl;
import daoimpl.NhanVienDAOimpl;
import daoimpl.PhongDAOimpl;
import daoimpl.ThietBiDAOimpl;
import model.DanhSachThietBi;
import model.KhachHang;
import model.NhanVien;
import model.Phong;
import model.ThietBi;
import model.add.DeviceRoom;

import sample.Room;

public class test {
	public static void main(String[] args) throws SQLException {

		Date date = new Date();
		
//		KhachHangDao khDAO = new KhachHangDaoImpl();
//		KhachHang kh1 = new KhachHang(1L, "ten1", "cmnd1", true, "diachi1", "dt1", "quoctich1", date, "nghe1", "cat1", "og1");
//		KhachHang kh2 = new KhachHang(2L, "ten2", "cmnd2", true, "diachi2", "dt2", "quoctich2", date, "nghe2", "cat2", "og2");
//		KhachHang kh3 = new KhachHang(3L, "ten3", "cmnd3", true, "diachi3", "dt3", "quoctich3", date, "nghe3", "cat3", "og3");
//		khDAO.insert(kh1);
//		khDAO.insert(kh2);
//		khDAO.insert(kh3);
//		List<KhachHang> list = khDAO.findAll();
//		for(KhachHang k : list) {
//			System.out.println(k.getCmnd());
//		}
		
//		NhanVienDAO khDAO = new NhanVienDAOimpl();
//		NhanVien kh1 = new NhanVien(1L, "ten1", true, date, "cm1", "cmnd1", "dt1");
//		NhanVien kh2 = new NhanVien(2L, "ten2", true, date, "cm2", "cmnd2", "dt2");
//		NhanVien kh3 = new NhanVien(3L, "ten3", true, date, "cm3", "cmnd3", "dt3");
//		khDAO.insert(kh1);
//		khDAO.insert(kh2);
//		khDAO.insert(kh3);
//		List<NhanVien> list = khDAO.findAll();
//		for(NhanVien k : list) {
//			System.out.println(k.getCMND());
//		}
		
//		PhongDAO pDAO = new PhongDAOimpl();
//		Phong p1 = new Phong(1L, "cat1", 1000L, 0);
//		Phong p2 = new Phong(2L, "cat1", 1000L, 0);
//		Phong p3 = new Phong(3L, "cat1", 1000L, 1);
//		Phong p4 = new Phong(4L, "cat1", 1000L, 1);
//		Phong p5 = new Phong(5L, "cat2", 2000L, 0);
//		Phong p6 = new Phong(6L, "cat2", 2000L, 0);
//		Phong p7 = new Phong(7L, "cat2", 2000L, 1);
//		Phong p8 = new Phong(8L, "cat2", 2000L, 0);
//		Phong p9 = new Phong(9L, "cat3", 3000L, 1);
//		Phong p10 = new Phong(10L, "cat3", 3000L, 0);
//		
//		pDAO.insert(p1);
//		pDAO.insert(p2);
//		pDAO.insert(p3);
//		pDAO.insert(p4);
//		pDAO.insert(p5);
//		pDAO.insert(p6);
//		pDAO.insert(p7);
//		pDAO.insert(p8);
//		pDAO.insert(p9);
//		pDAO.insert(p10);
		
//		ThietBiDAO tbDAO = new ThietBiDAOimpl();
//		ThietBi tb1 = new ThietBi(1L, "Bàn", 10L);
//		ThietBi tb2 = new ThietBi(1L, "Ghế", 5L);
//		ThietBi tb3 = new ThietBi(1L, "Tủ Lạnh", 100L);
//		
//		tbDAO.insert(tb1);
//		tbDAO.insert(tb2);
//		tbDAO.insert(tb3);

//		ThietBiDAO tbDAO = new ThietBiDAOimpl();
//		List<ThietBi> list = new ArrayList<>();
//		list.addAll(tbDAO.findAll());
//		for(ThietBi p : list) {
//			System.out.println(p.getID());
//		}
		
//		DanhSachThietBiDAO dsDAO = new DanhSachThietBiDAOimpl();
//		DanhSachThietBi ds1 = new DanhSachThietBi(1L, 1L, 1L);
//		DanhSachThietBi ds2 = new DanhSachThietBi(1L, 2L, 3L);
//		DanhSachThietBi ds3 = new DanhSachThietBi(2L, 1L, 1L);
//		DanhSachThietBi ds4 = new DanhSachThietBi(2L, 2L, 3L);
//		DanhSachThietBi ds5 = new DanhSachThietBi(3L, 1L, 1L);
//		DanhSachThietBi ds6 = new DanhSachThietBi(3L, 2L, 3L);
//		DanhSachThietBi ds7 = new DanhSachThietBi(4L, 1L, 1L);
//		DanhSachThietBi ds8 = new DanhSachThietBi(4L, 2L, 3L);
//		DanhSachThietBi ds9 = new DanhSachThietBi(5L, 1L, 1L);
//		DanhSachThietBi ds10 = new DanhSachThietBi(5L, 2L, 3L);
//		DanhSachThietBi ds11 = new DanhSachThietBi(5L, 3L, 1L);
//		DanhSachThietBi ds12 = new DanhSachThietBi(6L, 1L, 1L);
//		DanhSachThietBi ds13 = new DanhSachThietBi(6L, 2L, 3L);
//		DanhSachThietBi ds14 = new DanhSachThietBi(6L, 3L, 1L);
//		DanhSachThietBi ds15 = new DanhSachThietBi(7L, 1L, 1L);
//		DanhSachThietBi ds16 = new DanhSachThietBi(7L, 2L, 3L);
//		DanhSachThietBi ds17 = new DanhSachThietBi(7L, 3L, 1L);
//		DanhSachThietBi ds18 = new DanhSachThietBi(8L, 1L, 1L);
//		DanhSachThietBi ds19 = new DanhSachThietBi(8L, 2L, 3L);
//		DanhSachThietBi ds20 = new DanhSachThietBi(8L, 3L, 1L);
//		DanhSachThietBi ds21 = new DanhSachThietBi(9L, 1L, 2L);
//		DanhSachThietBi ds22 = new DanhSachThietBi(9L, 2L, 6L);
//		DanhSachThietBi ds23 = new DanhSachThietBi(9L, 3L, 1L);
//		DanhSachThietBi ds24 = new DanhSachThietBi(10L, 1L, 2L);
//		DanhSachThietBi ds25 = new DanhSachThietBi(10L, 2L, 6L);
//		DanhSachThietBi ds26 = new DanhSachThietBi(10L, 3L, 1L);
//		
//		dsDAO.insert(ds1);
//		dsDAO.insert(ds2);
//		dsDAO.insert(ds3);
//		dsDAO.insert(ds4);
//		dsDAO.insert(ds5);
//		dsDAO.insert(ds6);
//		dsDAO.insert(ds7);
//		dsDAO.insert(ds8);
//		dsDAO.insert(ds9);
//		dsDAO.insert(ds10);
//		dsDAO.insert(ds11);
//		dsDAO.insert(ds12);
//		dsDAO.insert(ds13);
//		dsDAO.insert(ds14);
//		dsDAO.insert(ds15);
//		dsDAO.insert(ds16);
//		dsDAO.insert(ds17);
//		dsDAO.insert(ds18);
//		dsDAO.insert(ds19);
//		dsDAO.insert(ds20);
//		dsDAO.insert(ds21);
//		dsDAO.insert(ds22);
//		dsDAO.insert(ds23);
//		dsDAO.insert(ds24);
//		dsDAO.insert(ds25);
//		dsDAO.insert(ds26);
		
		PhongDAO pDAO = new PhongDAOimpl();
		
		Function<Phong, Room> mapper = new Function<Phong, Room>() {
			
			@Override
			public Room apply(Phong t) {
				ThietBiDAO tbDAO = new ThietBiDAOimpl();
				Room r = new Room(1L, "", 1L, 1);
				Room room = new Room(t.getID(), t.getLoaiPhong(), t.getGiaPhong(), t.getTinhTrang());
				List<DeviceRoom> listDevice = new ArrayList<>();
				try {
					listDevice.addAll(tbDAO.getDeviceByIdRoom(t.getID()));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				StringBuilder moTa = new StringBuilder();
				for(DeviceRoom tb : listDevice) {
					moTa.append(tb.getTenTB() + " : " + tb.getSoLuong() + "\n");
				}
				room.setMoTa(moTa.toString());
				return room;
			}
		};
		
		List<Phong> listRoom = new ArrayList<>();
		try {
			listRoom.addAll(pDAO.findAll());
		} catch (SQLException e) {
		}
		List<Room> list = listRoom.stream().map(mapper).collect(Collectors.toCollection(ArrayList::new));
		String c = "Trống";
		if(!c.equals("Tất cả")) {
			list = list.stream().filter(new Predicate<Room>() {
				
				@Override
				public boolean test(Room t) {
					return t.getTinhTrang().equals(c);
				}
			}).collect(Collectors.toCollection(ArrayList::new));
		}
		System.out.println(list.size());
	}
	
	
}
