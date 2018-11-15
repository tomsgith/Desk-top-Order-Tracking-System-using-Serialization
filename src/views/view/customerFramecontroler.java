package views.view;

import java.io.IOException;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class customerFramecontroler extends MainFrameworkControler {
@FXML
 
BorderPane b;
public void loadPurchaseframe() throws IOException {
	FXMLLoader loader=new FXMLLoader();
	loader.setLocation(customerFramecontroler.class.getResource("PURCHASE.fxml"));
	AnchorPane p=loader.load();
	b.setCenter(p);
}
public void LoadViewproducts() throws IOException {
	FXMLLoader loader=new FXMLLoader();
	loader.setLocation(customerFramecontroler.class.getResource("viewPurchased.fxml"));
	AnchorPane p=loader.load();
	b.setCenter(p);
}
public void LoadtrackOrder() throws IOException {
	FXMLLoader loader=new FXMLLoader();
	loader.setLocation(customerFramecontroler.class.getResource("cuTracking.fxml"));
	AnchorPane p=loader.load();
	b.setCenter(p);
}
}
