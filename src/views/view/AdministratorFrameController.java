package views.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class AdministratorFrameController extends MainFrameworkControler {
	@FXML
	BorderPane b;
	public void loadCustomerForm() throws IOException {
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(AdministratorFrameController.class.getResource("CuatomerAddSaveForm.fxml"));
		AnchorPane p=loader.load();
		b.setRight(p);
	}
	public void loadCProductForm() throws IOException {
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(AdministratorFrameController.class.getResource("productAddEdit.fxml"));
		BorderPane p=loader.load();
		b.setRight(p);
	}
	public void loadBilltForm() throws IOException {
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(AdministratorFrameController.class.getResource("billingforCust.fxml"));
		BorderPane p=loader.load();
		b.setRight(p);
	}
	public void loadshippingForm() throws IOException {
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(AdministratorFrameController.class.getResource("viewShipping1.fxml"));
		AnchorPane p=loader.load();
		b.setRight(p);
	}
}
