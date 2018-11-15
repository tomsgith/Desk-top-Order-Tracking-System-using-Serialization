package Bussiness;

import java.util.List;

import dataacces.Auth;

public interface controlList {
public void placeOrder(Customer cu);
public void addCustomer(Customer cu);
public void updateCustomer(Customer cu);
public Auth logIn(String id,String pass);
public void addProduct(Product p);
public List<Product> viewProducts();
//public Customer getcustomerdetail();
public List<Customer> generateMonthlybill();
public List<Customer> generatebill();
public List<Product> trackOrderofCustomer(String id);
//public Customer searchCustomer(String cuid);

}
