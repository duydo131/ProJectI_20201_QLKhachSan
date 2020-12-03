package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class HeaderProcessController implements Initializable{
	
	@FXML
	Button book;
	
	@FXML
	Button customer;
	
	@FXML
	Button staff;
	
	@FXML
	Button room;
	
	@FXML
	Button device;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CommonProcessController ctl = CommonProcessController.getInstance();
		Pane content = ctl.getContent();
		
		book.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				try {
					clear();
					content.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/BookRoomLayout.fxml")));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		customer.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				try {
					clear();
					content.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/ListCustomerLayout.fxml")));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		staff.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				try {
					clear();
					content.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/ListStaffLayout.fxml")));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		room.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				try {
					clear();
					content.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/RoomLayout.fxml")));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		device.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				try {
					clear();
					content.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/DeviceLayout.fxml")));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	private void clear() throws IOException {
		CommonProcessController common = CommonProcessController.getInstance();
		Pane content = common.getContent();
		content.getChildren().clear();
	}

}
