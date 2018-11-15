package views.view;


import java.util.ArrayList;
import java.util.List;

import Bussiness.Customer;
import Bussiness.Product;
import Bussiness.ProductType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class billingformControls extends MainFrameworkControler{
	ObservableList<String> userlist=FXCollections
			.observableArrayList();
	@FXML
	 ComboBox<String> cuId;
	@FXML
	 TextField OrderDate;
	@FXML
	 TextField numberofPr;
	@FXML
	 TextField total;
	
	@FXML
	 Label error;
	public void initialize() {
		initcombos();
	 	cuId.setItems(userlist);
	}
	@FXML
	public void select() {
		Customer cu=searchCustomer1(cuId.getValue());
		fill(cu);
	}
	private void fill(Customer cu) {
	
		OrderDate.setText(cu.getOrder().getOrderdate().toString());
		numberofPr.setText(Integer.toString(cu.getOrder().getProducts().size()));
		total.setText(Double.toString(cu.payBill()));
		
		
	}
	@FXML
	public void initcombos() {
    List<String> cuids=new ArrayList<>();
		List<Customer> s=generateMonthlybill();
		System.out.println(s);
		for(Customer c:s) {
			cuids.add(c.getCuId());
			}
		userlist.addAll(cuids);
		
		
	}
}
