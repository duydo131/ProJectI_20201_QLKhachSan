package controller;

import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import dao.KhachHangDao;
import daoimpl.KhachHangDaoImpl;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.KhachHang;

public class ListCustomerController implements Initializable{
	
	@FXML
	TableView<Customer> table;
	
	@FXML 
	TableColumn<Customer, Number> stt;
	
	@FXML 
	TableColumn<Customer, Number> id;
	
	@FXML 
	TableColumn<Customer, String> ten;
	
	@FXML 
	TableColumn<Customer, String> cmnd;
	
	@FXML 
	TableColumn<Customer, String> gioiTinh;
	
	@FXML 
	TableColumn<Customer, String> diaChi;
	
	@FXML 
	TableColumn<Customer, String> dienThoai;
	
	@FXML 
	TableColumn<Customer, String> quocTich;
	
	@FXML 
	TableColumn<Customer, String> ngaySinh;
	
	@FXML 
	TableColumn<Customer, String> nghe;
	
	@FXML 
	TableColumn<Customer, String> phanLoai;
	
	@FXML 
	TableColumn<Customer, String> toChuc;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		stt.setCellValueFactory(column -> new ReadOnlyObjectWrapper<Number>(table.getItems().indexOf(column.getValue()) + 1));
		id.setCellValueFactory(new PropertyValueFactory<>("maKH"));
		ten.setCellValueFactory(new PropertyValueFactory<>("tenKH"));
		cmnd.setCellValueFactory(new PropertyValueFactory<>("cmnd"));
		gioiTinh.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
		diaChi.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
		dienThoai.setCellValueFactory(new PropertyValueFactory<>("dienThoai"));
		quocTich.setCellValueFactory(new PropertyValueFactory<>("quocTich"));
		ngaySinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
		nghe.setCellValueFactory(new PropertyValueFactory<>("ngheNghiep"));
		phanLoai.setCellValueFactory(new PropertyValueFactory<>("phanLoaiKH"));
		toChuc.setCellValueFactory(new PropertyValueFactory<>("tenToChuc"));
		
		KhachHangDao service = new KhachHangDaoImpl();
		List<KhachHang> listTT = new ArrayList<>();
		try {
			listTT.addAll(service.findAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<Customer> list = listTT.stream().map(tt -> new Customer(tt)).collect(Collectors.toCollection(ArrayList::new));
		if(!list.isEmpty()) {
			table.setItems(FXCollections.observableArrayList(list));
		}
		
	}
	
	public class Customer{
		private Long maKH;
	    private String tenKH;
	    private String cmnd;
	    private String gioiTinh;
	    private String diaChi;
	    private String dienThoai;
	    private String quocTich;
	    private String ngaySinh;
	    private String ngheNghiep;
	    private String phanLoaiKH;
	    private String tenToChuc;

	    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    
	    public Customer(KhachHang kh) {
	        this.maKH = kh.getMaKH();
	        this.tenKH = kh.getTenKH();
	        this.cmnd = kh.getCmnd();
	        this.gioiTinh = kh.isGioiTinh() ? "Nam" : "Nữ";
	        this.diaChi = kh.getDiaChi();
	        this.dienThoai = kh.getDiaChi();
	        this.quocTich = kh.getQuocTich();
	        this.ngaySinh = format.format(kh.getNgaySinh());
	        this.ngheNghiep = kh.getNgheNghiep();
	        this.phanLoaiKH = kh.getPhanLoaiKH();
	        this.tenToChuc = kh.getTenToChuc();
	    }

		public Long getMaKH() {
	        return maKH;
	    }

	    public void setMaKH(Long maKH) {
	        this.maKH = maKH;
	    }

	    public String getTenKH() {
	        return tenKH;
	    }

	    public void setTenKH(String tenKH) {
	        this.tenKH = tenKH;
	    }

	    public String getCmnd() {
	        return cmnd;
	    }

	    public void setCmnd(String cmnd) {
	        this.cmnd = cmnd;
	    }

	    public String isGioiTinh() {
	        return gioiTinh;
	    }

	    public void setGioiTinh(String gioiTinh) {
	        this.gioiTinh = gioiTinh;
	    }

	    public String getDiaChi() {
	        return diaChi;
	    }

	    public void setDiaChi(String diaChi) {
	        this.diaChi = diaChi;
	    }

	    public String getQuocTich() {
	        return quocTich;
	    }

	    public void setQuocTich(String quocTich) {
	        this.quocTich = quocTich;
	    }

	    public String getNgaySinh() {
	        return ngaySinh;
	    }

	    public void setNgaySinh(String ngaySinh) {
	        this.ngaySinh = ngaySinh;
	    }

	    public String getNgheNghiep() {
	        return ngheNghiep;
	    }

	    public void setNgheNghiep(String ngheNghiep) {
	        this.ngheNghiep = ngheNghiep;
	    }

	    public String getPhanLoaiKH() {
	        return phanLoaiKH;
	    }

	    public void setPhanLoaiKH(String phanLoaiKH) {
	        this.phanLoaiKH = phanLoaiKH;
	    }

	    public String getTenToChuc() {
	        return tenToChuc;
	    }

	    public void setTenToChuc(String tenToChuc) {
	        this.tenToChuc = tenToChuc;
	    }

	    public String getDienThoai() {
	        return dienThoai;
	    }

	    public void setDienThoai(String dienThoai) {
	        this.dienThoai = dienThoai;
	    }
	}

}
