package sample;

import java.io.IOException;

import controller.CommonController;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class testLayout extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		Parent root = null;
		Scene scene = null;
		CommonController ctl = CommonController.getInstance();
		ctl.setStage(arg0);
		try {
			root = FXMLLoader.load(this.getClass().getResource("/view/RegisterLayout.fxml"));
			arg0.setTitle("Quản Lý Khách Sạn");
			scene = new Scene(root);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		arg0.setScene(scene);
		arg0.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
