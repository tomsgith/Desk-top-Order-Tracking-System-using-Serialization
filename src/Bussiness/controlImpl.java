package Bussiness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataacces.Auth;
import dataacces.DataAccess;
import dataacces.DataAccessFacade;

import javafx.application.Application;

public abstract  class controlImpl extends Application implements controlList {
	static DataAccessFacade d=new DataAccessFacade();
	public Customer searchTrckingNumD(String tn ) {
		return d.searchTrckingNum(Integer.parseInt(tn));
	}
	
	@Override
	public void placeOrder(Customer cu) {
		d.updateCustomer(cu);
	}
//public static void main(String args[]) {
//	loginController n=new loginController();
//	Auth s= d.login("Admin1", "xyz") ;
//	if(s==null) System.out.println("User doesnt exist");
//	else if(s.equals(Auth.ADMIN))System.out.println("go to admin window");
//	else System.out.print("Go to Customer window");
//}
	public Product searchProduct(String id) {
		
		return d.searchProduct(id);
		
	}
	public Customer searchCustomer1(String cuid) {
		return d.searchCustomer(cuid);
	}
	public Product searchProduct1(String id)
	{
		return d.searchProduct(id);
	}
@Override
public void addCustomer(Customer cu) {
	
	d.addCustomer(cu);
	
}
@Override
public void updateCustomer(Customer cu) {

	d.updateCustomer(cu);
	
}
@Override
public Auth logIn(String id, String pass) { 
	
	return d.login(id,pass);
	}
@Override
public void addProduct(Product p) {
	
	d.AddProduct(p);
	
}
@Override
public List<Product> viewProducts() {
	HashMap<String, Product> p = d.readProductMap();
	List<Product> list=new ArrayList<>();
	list.addAll(p.values());
	return list;
}
//@Override
//public Customer getcustomerdetail(String id) {
//	DataAccess d=new DataAccessFacade();
//	d.searchCustomer(id);
//	return null;
//}
@Override
public List<Customer> generateMonthlybill() {
	HashMap<String, Customer> p = d.readCustomerMap();
	List<Customer> list=new ArrayList<>();
	for(Customer c:p.values())
		if(!(c.getRate()==CustomerRatting.POOR))
			list.add(c);
	
	return list;
}
@Override
public List<Customer> generatebill() {
	HashMap<String, Customer> p = d.readCustomerMap();
	List<Customer> list=new ArrayList<>();
	for(Customer c:p.values())
		if(c.getRate()==CustomerRatting.POOR)
			list.add(c);
	
	return list;
}

@Override
public List<Product> trackOrderofCustomer(String id) {
	Customer c=d.searchCustomer(id);
	
	return c.getOrder().getProducts();
}
}
