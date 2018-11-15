package views.view;

import Bussiness.Customer;
import Bussiness.CustomerRatting;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CusstomerAddSaveFramecontroller extends MainFrameworkControler{
	static ObservableList<CustomerRatting> ratelist=FXCollections
			.observableArrayList(CustomerRatting.POOR,CustomerRatting.GOOD,CustomerRatting.EXCELLENT);
	
	@FXML
	 TextField cuId;
	@FXML
	 TextField fName;
	@FXML
	 TextField Lname;
	@FXML
	 TextField pass;
	@FXML
	 ComboBox<CustomerRatting> rate;
	@FXML
	 Label error;
	@FXML
	public void initialize() {
		rate.setValue(CustomerRatting.POOR);
		rate.setItems(ratelist);
	}
	@FXML
	public void addcustomer() {
		//error.setText("");
		if(cuId.getText().equals("")||fName.getText().equals("")||Lname.getText().equals("")||pass.getText().equals("")) {
			error.setText("Please fill all the boxes");
		}else {
			Customer c=new Customer(fName.getText(), Lname.getText(), cuId.getText(), pass.getText(),rate.getValue());
			addCustomer(c);
			Clear();
			error.setText("");
			
		}
	}
	

	
	  @FXML
	    void SetCustomer() {
		  if(cuId.getText().equals("")) {
				error.setText("please inter an id");
				}else {
					Customer cu=searchCustomer1(cuId.getText());
					if(cu==null) {error.setText("id doesnt exist");}
					else {
					fill(cu);
					}
				}
	    }
	
	private void fill(Customer cu) {
		cuId.setText(cu.getCuId());
		fName.setText(cu.getFname());
		Lname.setText(cu.getLname());
		pass.setText(cu.getPassword());
		rate.setValue(cu.getRate());
		
	}
	
	@FXML
	private void Clear()
	{
		cuId.clear();
		fName.clear();
		Lname.clear();
		pass.clear();
		
	}
	 
	
}
