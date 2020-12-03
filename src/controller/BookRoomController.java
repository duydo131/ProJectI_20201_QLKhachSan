package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

public class BookRoomController implements Initializable{
	
	@FXML
	AnchorPane thongtinkhachhang;
	
	@FXML
	TextField tenKH;
	
	@FXML
	TextField diaChiKH;
	
	@FXML
	TextField ngaySinhKH;
	
	@FXML
	TextField cmndKH;
	
	@FXML
	TextField quocTichKH;
	
	@FXML
	TextField tenToChuc;
	
	@FXML
	TextField ngheKH;
	
	@FXML
	TextField dienThoaiKH;
	
	@FXML
	ComboBox<String> gioiTinhKH;
	
	@FXML
	ComboBox<String> phanloaiKH;
	
	@FXML
	Label inTenKH;
	
	@FXML
	Label inQuocTich;
	
	@FXML
	Label inCMNDKH;
	
	@FXML
	Label inDiaChiKH;
	
	@FXML
	Label inDienThoaiKH;
	
	@FXML
	Label inNgaySinhKH;
	
	@FXML 
	TextField soLuongPhong;
	
	@FXML
	TextField ngayDangKi;
	
	@FXML
	TextField ngayDen;
	
	@FXML
	Label inNgayDen;
	
	@FXML
	Label inNgayDangKi;
	
	@FXML
	ComboBox<String> phong;
	
	@FXML
	TextArea moTa;
	
	@FXML
	TableView<Form> table;
	
	@FXML
	TableColumn<Form, Number> stt;
	
	@FXML
	TableColumn<Form, String> tenPhong;
	
	@FXML
	TableColumn<Form, String> ngayDi;
	
	@FXML
	TableColumn<Form, String> moTaPhong;
	
	@FXML
	Button add;
	
	@FXML
	Button book;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gioiTinhKH.getItems().addAll("Nam", "Nữ");
		gioiTinhKH.getSelectionModel().select(0);
		
		phanloaiKH.getItems().addAll("Cá nhân", "Tổ chức");
		phanloaiKH.getSelectionModel().select(0);
		
		table.setEditable(true);
		
		stt.setCellValueFactory(column -> new ReadOnlyObjectWrapper<Number>(table.getItems().indexOf(column.getValue()) + 1));
		
		tenPhong.setCellValueFactory(new PropertyValueFactory<>("tenPhong"));
		tenPhong.setCellFactory(TextFieldTableCell.forTableColumn());
		tenPhong.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Form,String>>() {
			
			@Override
			public void handle(CellEditEvent<Form, String> event) {
				((Form) event.getTableView().getItems().get(event.getTablePosition().getRow())).setTenPhong(event.getNewValue());	
			}
		});
		
		ngayDi.setCellValueFactory(new PropertyValueFactory<>("ngayDi"));
		ngayDi.setCellFactory(TextFieldTableCell.forTableColumn());
		ngayDi.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Form,String>>() {
			
			@Override
			public void handle(CellEditEvent<Form, String> event) {
				((Form) event.getTableView().getItems().get(event.getTablePosition().getRow())).setNgayDi(event.getNewValue());	
			}
		});
		
		moTaPhong.setCellValueFactory(new PropertyValueFactory<>("moTaPhong"));
		moTaPhong.setCellFactory(TextFieldTableCell.forTableColumn());
		moTaPhong.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Form,String>>() {
			
			@Override
			public void handle(CellEditEvent<Form, String> event) {
				((Form) event.getTableView().getItems().get(event.getTablePosition().getRow())).setMoTaPhong(event.getNewValue());	
			}
		});
		
		table.setItems(FXCollections.observableArrayList(new Form()));
	}
	
	public class Form{
		private String tenPhong;
		private String ngayDi;
		private String moTaPhong;
		
		public Form() {
		}

		public Form(String tenPhong, String ngayDi, String moTaPhong) {
			this.tenPhong = tenPhong;
			this.ngayDi = ngayDi;
			this.moTaPhong = moTaPhong;
		}

		public String getTenPhong() {
			return tenPhong;
		}

		public void setTenPhong(String tenPhong) {
			this.tenPhong = tenPhong;
		}

		public String getNgayDi() {
			return ngayDi;
		}

		public void setNgayDi(String ngayDi) {
			this.ngayDi = ngayDi;
		}

		public String getMoTaPhong() {
			return moTaPhong;
		}

		public void setMoTaPhong(String moTaPhong) {
			this.moTaPhong = moTaPhong;
		}
	}
}
