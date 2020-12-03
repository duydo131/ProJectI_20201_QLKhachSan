package controller;

import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import dao.DangNhapDao;
import dao.NhanVienDAO;
import daoimpl.DangNhapDaoImpl;
import daoimpl.NhanVienDAOimpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.DangNhap;
import model.NhanVien;

public class RegisterController implements Initializable{
	
	@FXML
	TextField hoTen;
	
	@FXML
	TextField ngaySinh;
	
	@FXML
	TextField CMND;
	
	@FXML
	TextField dienThoai;
	
	@FXML
	TextField chuyenMon;
	
	@FXML
	TextField matKhau1;
	
	@FXML
	TextField matKhau2;
	
	@FXML
	TextField tenDangNhap;
	
	@FXML
	ComboBox<String> gioiTinh;
	
	@FXML
	Label inTen;
	
	@FXML
	Label inTenDangNhap;
	
	@FXML
	Label inMK1;
	
	@FXML
	Label inMK2;
	
	@FXML
	Label inNgaySinh;
	
	@FXML
	Label inCMND;
	
	@FXML
	Button regis;
	
	private NhanVienDAO nvDAO = new NhanVienDAOimpl();
	private DangNhapDao loginDAO = new DangNhapDaoImpl();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gioiTinh.getItems().addAll("Nam", "Nữ");
		gioiTinh.getSelectionModel().select(0);
		
		regis.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				inTen.setText("");
				inNgaySinh.setText("");
				inCMND.setText("");
				inMK1.setText("");
				inMK2.setText("");
				inTenDangNhap.setText("");
				
				String tenDangNhap_NV = (String)tenDangNhap.getText();
				String matKhau1_NV = (String)matKhau1.getText();
				String matKhau2_NV = (String)matKhau2.getText();
				String ten_NV = (String)hoTen.getText();
				String ngaySinh_NV = (String)ngaySinh.getText();
				String CMND_NV = (String)CMND.getText();
				String chuyenMon_NV = (String)chuyenMon.getText();
				String dienThoai_NV = (String)dienThoai.getText();
				String gioiTinh_NV = (String)gioiTinh.getValue();
				
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				boolean flag = true;
				
				
				if(matKhau1_NV.equals("")) {
					inMK1.setText("Invalid");
					flag = false;
				}
				if(matKhau2_NV.equals("")) {
					inMK2.setText("Invalid");
					flag = false;
				}
				if(tenDangNhap_NV.equals("")) {
					inTenDangNhap.setText("Invalid");
					flag = false;
				}
				if(ten_NV.equals("")) {
					inTen.setText("Invalid");
					flag = false;
				}
				if(CMND_NV.equals("")) {
					inCMND.setText("Invalid");
					flag = false;
				}
				if(ngaySinh_NV.equals("")) {
					inNgaySinh.setText("Invalid");
					flag = false;
				}else {
					try {
						date = format.parse(ngaySinh_NV);
					} catch (ParseException e) {
						inNgaySinh.setText("Invalid");
						flag = false;
					}
				}
				if(flag) {
					try {
						if(loginDAO.contains(tenDangNhap_NV) == null) {
							if(matKhau1_NV.equals(matKhau2_NV)) {
								NhanVien nv = new NhanVien();
								nv.setTen(ten_NV);
								nv.setNgaySinh(date);
								nv.setCMND(CMND_NV);
								nv.setChuyenMon(chuyenMon_NV);
								nv.setDienThoai(dienThoai_NV);
								nv.setGioiTinh(gioiTinh_NV.equals("Nam"));
								
								Long id = nvDAO.insert(nv).getID();
								
								DangNhap dn = new DangNhap();
								dn.setUsername(tenDangNhap_NV);
								dn.setPassword(matKhau1_NV);
								dn.setMaNV(id);
								
								loginDAO.insert(dn);
							}else {
								inMK2.setText("Mật khẩu không trùng nhau");
							}
						}else {
							inTenDangNhap.setText("Tên đăng nhập đã tồn tại");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

}
