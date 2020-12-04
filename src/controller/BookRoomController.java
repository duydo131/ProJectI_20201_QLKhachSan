package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import dao.PhongDAO;
import dao.ThietBiDAO;
import daoimpl.PhongDAOimpl;
import daoimpl.ThietBiDAOimpl;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import model.Phong;
import model.add.DeviceRoom;

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
	Button remove;
	
	@FXML
	Button add;
	
	@FXML
	Button book;
	
	private List<Form> listData;
	private Form form = null;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listData = new ArrayList<>();
		
		gioiTinhKH.getItems().addAll("Nam", "Nữ");
		gioiTinhKH.getSelectionModel().select(0);
		
		phanloaiKH.getItems().addAll("Cá nhân", "Tổ chức");
		phanloaiKH.getSelectionModel().select(0);
		
		setRoom();
		
		setTable();
	}
	
	private void setRoom() {
		PhongDAO roomDAO = new PhongDAOimpl();
		ThietBiDAO tbDAO = new ThietBiDAOimpl();
		List<Phong> listRoom = new ArrayList<>();
		try {
			listRoom.addAll(roomDAO.findAllEmptyRoom());
		} catch (SQLException e) {
		}
		List<String> list = listRoom.stream().map(r -> r.getTenPhong()).collect(Collectors.toCollection(ArrayList::new));
		phong.getItems().addAll(list);
		
		phong.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String name = phong.getValue();
				Phong room = listRoom.stream().filter(r -> r.getTenPhong().equals(name)).findFirst().get();
				
				List<DeviceRoom> listDevice = new ArrayList<>();
				try {
					listDevice.addAll(tbDAO.getDeviceByIdRoom(room.getID()));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				StringBuilder moTaPhong = new StringBuilder();
				for(DeviceRoom tb : listDevice) {
					moTaPhong.append(tb.getTenTB() + " : " + tb.getSoLuong() + "\n");
				}
				
				moTa.setText(moTaPhong.toString());
				
				form = new Form();
				form.setMoTaPhong(moTaPhong.toString());
				form.setTenPhong(name);
			}
		});
		
		add.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				listData.add(form);
				table.setItems(FXCollections.observableArrayList(listData));
				moTa.clear();
			}
		});
	}
	
	private void setTable() {
		table.setEditable(true);
		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
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
		
		table.setItems(FXCollections.observableArrayList(listData));
		
		remove.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ObservableList<Form> selectedRows = table.getSelectionModel().getSelectedItems();
				List<Form> rows = new ArrayList<>(selectedRows);
				rows.forEach(row -> table.getItems().remove(row));
			}
		});
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
