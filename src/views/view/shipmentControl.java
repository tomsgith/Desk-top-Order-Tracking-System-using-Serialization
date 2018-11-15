package views.view;

import java.util.ArrayList;
import java.util.List;


import Bussiness.Customer;
import Bussiness.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class shipmentControl extends MainFrameworkControler  {
	Product p;
//	ObservableList<String> pl=FXCollections
//			.observableArrayList();
// List<String> plst=new ArrayList<>();
// @FXML
// ComboBox<String> plist;
	@FXML
	TextField tck;
//	@FXML
//	TextField oD;
//	@FXML
//	TextField sD;
//	@FXML
//	TextField aV;
	@FXML
	Label error;
public void TrackOrder() {
	if(!isInteger(tck.getText())||tck.getText().equals(""))error.setText("please inter a nimeric value or put in a tracking number");
	else {
	Customer cu=searchTrckingNumD(tck.getText());
	if(cu==null)error.setText("track number doesn Excist");
	else {
		initTable( cu);
		initialize2();
	}
	}
}
//private void fill(Customer cu) {
//	List<Product> s=cu.getOrder().getProducts();
//	for(Product p:s) {
//			plst.add(p.getId());
//	}
//	pl.addAll(plst);
//	plist.setItems(pl);
//}
boolean isInteger( String input )
{
   try
   {
      Integer.parseInt( input );
      return true;
   }
   catch(Exception ex )
   {
      return false;
   }
}
//@FXML
//public void onProSelected() {
//	if(plist.getValue()=="") {error.setText("Select one");}
//	 p=searchProduct(plist.getValue());
//	if(p==null){error.setText("doesnt exist");}
//	else {
//	fill(p);
//	}
//}
//private void fill(Product p) {
//	System.out.println(p.getOrder().getOrderdate());
//	//oD.setText(p.getOrder().getOrderdate().toString());
////	sD.setText(p.getShippingDate().toString());
////	aV.setText(p.arivalDate().toString());
//	
//	
//}
@FXML
TableView<Table2> tableId;
@FXML
TableColumn<Table2,String> tId;
@FXML
TableColumn<Table2,String> desc;
@FXML
TableColumn<Table2,String> price;
@FXML
TableColumn<Table2,String> type;
@FXML
TableColumn<Table2,String> sto;
@FXML
TableColumn<Table2,String> SDat;
@FXML
TableColumn<Table2,String> Od;
@FXML
TableColumn<Table2,String> aD;
ObservableList<Table2> tableL=FXCollections
			.observableArrayList();

public void initialize2() {
	
	tId.setCellValueFactory(new PropertyValueFactory<Table2,String>("id"));
	desc.setCellValueFactory(new PropertyValueFactory<Table2,String>("desc"));
	price.setCellValueFactory(new PropertyValueFactory<Table2,String>("price"));
	type.setCellValueFactory(new PropertyValueFactory<Table2,String>("type"));
	sto.setCellValueFactory(new PropertyValueFactory<Table2,String>("loc"));
	SDat.setCellValueFactory(new PropertyValueFactory<Table2,String>("shi"));
	Od.setCellValueFactory(new PropertyValueFactory<Table2,String>("Od"));
	aD.setCellValueFactory(new PropertyValueFactory<Table2,String>("delD"));
	tableId.setItems(tableL);
}

public void initTable(Customer cu) {
	//System.out.println(searchCustomer1(id).getOrder().getRanN());

	List<Table2> tlist=new ArrayList<>();
	List<Product> s=cu.getOrder().getProducts();
	for(Product p:s) {
		
Table2 t=new Table2(p.getId(),p.getDescription(),Double.toString(p.getPrice()),p.getType().toString()
	,p.getP().toString(),p.getShippingDate().toString(),p.getOrder().getOrderdate().toString(),p.arivalDate().toString());
		
						tlist.add(t);
		}
	
	
	tableL.addAll(tlist);
	
}


	
	 
}

