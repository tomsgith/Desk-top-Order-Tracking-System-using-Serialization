package views.view;


import java.util.ArrayList;
import java.util.List;

import Bussiness.Customer;
import Bussiness.CustomerRatting;
import Bussiness.Product;
import Bussiness.ProductType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class purchaseControll extends MainFrameworkControler{
	Product p;
	Customer cu=searchCustomer1(id);
	List<String> Complist=new ArrayList<>();
	List<String> Healthlist=new ArrayList<>();
	List<String> Videothlist=new ArrayList<>();
	List<String> Otherlist=new ArrayList<>();
	
	 ObservableList<String> complisst=FXCollections
				.observableArrayList();
	 ObservableList<String> hellist=FXCollections
				.observableArrayList();
	 ObservableList<String> vidd=FXCollections
				.observableArrayList();
	 ObservableList<String> Other=FXCollections
				.observableArrayList();
	 @FXML
	 Label error;
	 @FXML
	 Label PId;
	@FXML
	 Label desc;
	@FXML
	 Label price;
	@FXML
	 Label type;
	@FXML
	 Label loca;
	@FXML
	Label Po;
	@FXML
	TextField to;
	@FXML
	TextField Disc;
	
	@FXML
	 ComboBox<String> comp;
	@FXML
	 ComboBox<String> hel;
	@FXML
	 ComboBox<String> vid;
	@FXML
	 ComboBox<String> oth;
	public void initialize() {
		initcombos();
	}
	@FXML
	public void initcombos() {
		
		List<Product> s=viewProducts();
		for(Product p:s) {
			if(p.getType()==ProductType.COMPUTER)
				Complist.add(p.getId());
			else if(p.getType()==ProductType.HEALTH)
				Healthlist.add(p.getId());
			else if(p.getType()==ProductType.AUDIOVIDEO)
				Videothlist.add(p.getId());
			else if(p.getType()==ProductType.OTHER)
				Otherlist.add(p.getId());
		}
		complisst.addAll(Complist);
		hellist.addAll(Healthlist);
		vidd.addAll(Videothlist);
		Other.addAll(Otherlist);
		
		comp.setItems(complisst);
		hel.setItems(hellist);
		vid.setItems(vidd);
		oth.setItems(Other);
		
	}
	@FXML
	public void oncompSelected() {
		if(comp.getValue()=="") {error.setText("Select one");}
		 p=searchProduct(comp.getValue());
		if(p==null){error.setText("doesnt exist");}
		else
		fill(p);
	}
	@FXML
	public void onhelthSelected() {
		if(hel.getValue()=="") {error.setText("Select one");}
		 p=searchProduct(hel.getValue());
		if(p==null){error.setText("doesnt exist");}
		else
		fill(p);
	}
	@FXML
	public void onOthSelected() {
		if(oth.getValue()=="") {error.setText("Select one");}
		 p=searchProduct(oth.getValue());
		if(p==null){error.setText("doesnt exist");}
		else
		fill(p);
	}
	@FXML
	public void onvideoSelected() {
		if(vid.getValue()=="") {error.setText("Select one");}
		 p=searchProduct(vid.getValue());
		if(p==null){error.setText("doesnt exist");}
		else
		fill(p);
	}
	private void fill(Product p) {
		PId.setText(p.getId());
		desc.setText(p.getDescription());
		price.setText(Double.toString(p.getPrice()));
		type.setText(p.getType().toString());
		loca.setText(p.getP().toString());
		
	}
	public void setOrder() {
		 
		cu.getOrder().add(p);
		Po.setText(Double.toString(cu.getOrder().Allpoints()));
		to.setText(Double.toString(cu.totalPrice()));
		Disc.setText(Double.toString(cu.discount()));

	}
	public void purchase() {
		if(cu.getRate().equals(CustomerRatting.POOR)) {
		error.setText("payed now");
		placeOrder(cu);
		}
	else {
		placeOrder(cu);
		error.setText("Order purchased");
	}
	
	}
}
