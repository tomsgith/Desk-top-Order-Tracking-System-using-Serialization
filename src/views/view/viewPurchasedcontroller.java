package views.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Bussiness.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class viewPurchasedcontroller extends MainFrameworkControler  implements Initializable {
	@FXML
	Label te;
     @FXML
     TableView<Table> tableId;
     @FXML
     TableColumn<Table,String> tId;
     @FXML
     TableColumn<Table,String> desc;
     @FXML
     TableColumn<Table,String> price;
     @FXML
     TableColumn<Table,String> type;
     @FXML
     TableColumn<Table,String> sto;
     @FXML
     TableColumn<Table,String> SDat;
     @FXML
     TableColumn<Table,String> Od;
     ObservableList<Table> tableL=FXCollections
				.observableArrayList();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initTable();
		tId.setCellValueFactory(new PropertyValueFactory<Table,String>("id"));
		desc.setCellValueFactory(new PropertyValueFactory<Table,String>("desc"));
		price.setCellValueFactory(new PropertyValueFactory<Table,String>("price"));
		type.setCellValueFactory(new PropertyValueFactory<Table,String>("type"));
		sto.setCellValueFactory(new PropertyValueFactory<Table,String>("loc"));
		SDat.setCellValueFactory(new PropertyValueFactory<Table,String>("shi"));
		Od.setCellValueFactory(new PropertyValueFactory<Table,String>("Od"));
		tableId.setItems(tableL);
	}
	@FXML
	public void initTable() {
		System.out.println(searchCustomer1(id).getOrder().getRanN());
		te.setText(Integer.toString(searchCustomer1(id).getOrder().getRanN()));
		List<Table> tlist=new ArrayList<>();
		List<Product> s=searchCustomer1(id).getOrder().getProducts();
		System.out.println(s);
		for(Product p:s) {
			
Table t=new Table(p.getId(),p.getDescription(),Double.toString(p.getPrice()),p.getType().toString()
		,p.getP().toString(),p.getShippingDate().toString(),p.getOrder().getOrderdate().toString());
			
							tlist.add(t);
			}
		
		
		tableL.addAll(tlist);
		
		
	}

}
