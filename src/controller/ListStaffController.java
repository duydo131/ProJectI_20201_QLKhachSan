package controller;

import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import dao.NhanVienDAO;
import daoimpl.NhanVienDAOimpl;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.NhanVien;

public class ListStaffController implements Initializable{
	@FXML
	TableView<Staff> table;
	
	@FXML 
	TableColumn<Staff, Number> stt;
	
	@FXML 
	TableColumn<Staff, Number> id;
	
	@FXML 
	TableColumn<Staff, String> ten;
	
	@FXML 
	TableColumn<Staff, String> cmnd;
	
	@FXML 
	TableColumn<Staff, String> gioiTinh;
	
	@FXML 
	TableColumn<Staff, String> chuyenMon;
	
	@FXML 
	TableColumn<Staff, String> dienThoai;

	@FXML 
	TableColumn<Staff, String> ngaySinh;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		stt.setCellValueFactory(column -> new ReadOnlyObjectWrapper<Number>(table.getItems().indexOf(column.getValue()) + 1));
		id.setCellValueFactory(new PropertyValueFactory<>("ID"));
		ten.setCellValueFactory(new PropertyValueFactory<>("Ten"));
		cmnd.setCellValueFactory(new PropertyValueFactory<>("CMND"));
		gioiTinh.setCellValueFactory(new PropertyValueFactory<>("GioiTinh"));
		chuyenMon.setCellValueFactory(new PropertyValueFactory<>("ChuyenMon"));
		dienThoai.setCellValueFactory(new PropertyValueFactory<>("DienThoai"));
		ngaySinh.setCellValueFactory(new PropertyValueFactory<>("NgaySinh"));
		
		NhanVienDAO service = new NhanVienDAOimpl();
		List<NhanVien> listTT = new ArrayList<>();
		try {
			listTT.addAll(service.findAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<Staff> list = listTT.stream().map(tt -> new Staff(tt)).collect(Collectors.toCollection(ArrayList::new));
		if(!list.isEmpty()) {
			table.setItems(FXCollections.observableArrayList(list));
		}
		
	}
	
	public class Staff{
		private Long ID;
		private String Ten;
		private String GioiTinh;
		private String NgaySinh;
		private String ChuyenMon;
		private String CMND;
		private String DienThoai;
		
		private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		public Staff(NhanVien nv) {
			ID = nv.getID();
			Ten = nv.getTen();
			GioiTinh = nv.getGioiTinh() ? "Nam" : "Nữ";
			NgaySinh = format.format(nv.getNgaySinh());
			ChuyenMon = nv.getChuyenMon();
			CMND = nv.getCMND();
			DienThoai = nv.getDienThoai();
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

		public String getGioiTinh() {
			return GioiTinh;
		}

		public void setGioiTinh(String gioiTinh) {
			GioiTinh = gioiTinh;
		}

		public String getNgaySinh() {
			return NgaySinh;
		}

		public void setNgaySinh(String ngaySinh) {
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
}
