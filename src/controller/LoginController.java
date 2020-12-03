package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.DangNhapDao;
import daoimpl.DangNhapDaoImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.DangNhap;

public class LoginController implements Initializable{
	
	@FXML
	TextField user;
	
	@FXML
	TextField password;
	
	@FXML
	Label inUser;
	
	@FXML
	Label inMK;
	
	@FXML
	Button login;
	
	private DangNhapDao loginDAO = new DangNhapDaoImpl();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		login.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String username_login = (String)user.getText();
				String password_login = (String)password.getText();
				
				inUser.setText("");
				inMK.setText("");
				
				boolean flag = true;
				
				if(username_login.equals("")) {
					inUser.setText("Invalid");
					flag = false;
				}
				if(password_login.equals("")) {
					inMK.setText("Invalid");
					flag = false;
				}
				if(flag) {
					try {
						DangNhap dn = loginDAO.contains(username_login);
						if(dn != null) {
							if(dn.getPassword().equals(password_login)) {
								//redirect
								System.out.println("Redirect");
							}else {
								inMK.setText("Mật khẩu không chính xác");
							}
						}else {
							inUser.setText("Tài khoản chưa tồn tại");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

}
