package views.view;

import Bussiness.Customer;
import Bussiness.CustomerRatting;
import Bussiness.Product;
import Bussiness.ProductType;
import Bussiness.StoreLocation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class producteditcontroller extends MainFrameworkControler{

	static ObservableList<ProductType> ratelist=FXCollections
			.observableArrayList(ProductType.COMPUTER,ProductType.HEALTH,ProductType.AUDIOVIDEO,ProductType.OTHER);
	static ObservableList<StoreLocation> ratelist2=FXCollections
			.observableArrayList(StoreLocation.STORE,StoreLocation.STOKE);
	@FXML
	 TextField pid;
	@FXML
	 TextField pprice;
	@FXML
	 TextField pdesc;
	
	@FXML
	 ComboBox<ProductType> rate;
	@FXML
	 ComboBox<StoreLocation> rate2;
	@FXML
	 Label error;
	public void initialize()
	{
		initialize1();
		initialize2();
	}
	public void initialize1() {
		rate.setValue(ProductType.COMPUTER);
		rate.setItems(ratelist);
	}
	public void initialize2() {
		rate2.setValue(StoreLocation.STORE);
		rate2.setItems(ratelist2);
	}
	@FXML
	public void addproduct() {
		error.setText("");
		if(pid.getText().equals("")||pprice.getText().equals("")||pdesc.getText().equals("")) {
			error.setText("Please fill all the boxes");
		}else {
			Product c=new Product(pid.getText(),pdesc.getText(), Double.parseDouble(pprice.getText()), rate.getValue(),rate2.getValue());
			addProduct(c);
		}
	}
	

	
	  @FXML
	    void SetProduct() {
		  if(pid.getText().equals("")) {
				error.setText("please inter an id");
				}else {
					Product cu=searchProduct1(pid.getText());
					if(cu==null) {error.setText("id doesnt exist");}
					else {
					fill(cu);
					}
				}
	    }
	
	private void fill(Product cu) {
		pid.setText(cu.getId());
		pprice.setText(Double.toString(cu.getPrice()));
		pdesc.setText(cu.getDescription());
		
		
	}
	@FXML
	private void Clear()
	{
		pid.setText("");
		pprice.setText("");
		pdesc.setText("");
	}
	 

}
