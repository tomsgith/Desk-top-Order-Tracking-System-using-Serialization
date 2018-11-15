package views;

import java.io.IOException;

import Bussiness.controlImpl;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

public class Main extends controlImpl {
	protected static String id="cus1";
private static Stage Primarystage;
private static BorderPane mainPane;
	@Override
	public void start(Stage primaryStage) throws IOException {
		Main.Primarystage=primaryStage;
		Main.Primarystage.setTitle("Order Tracking System");
		showmainView();
		showsubmainpane();
	}

	public static void showsubmainpane() throws IOException {
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/LOGIN.fxml"));
		AnchorPane pn=loader.load();
		mainPane.setCenter(pn);
	}

	public static void showmainView() throws IOException {
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/Mainframe.fxml"));
		mainPane=loader.load();
		
		Scene sne=new Scene(mainPane);
		Primarystage.setScene(sne);
		Primarystage.show();
	}

public static  void administratorFrame() throws IOException {
	FXMLLoader loader=new FXMLLoader();
	loader.setLocation(Main.class.getResource("view/AdministratorFrame.fxml"));
	BorderPane p=loader.load();
	mainPane.setCenter(p);
}
public static  void customerFrame() throws IOException {
	FXMLLoader loader=new FXMLLoader();
	loader.setLocation(Main.class.getResource("view/customerFra.fxml"));
	BorderPane p=loader.load();
	mainPane.setCenter(p);
}

	public static void main(String[] args) {
		launch(args);
	}

}
