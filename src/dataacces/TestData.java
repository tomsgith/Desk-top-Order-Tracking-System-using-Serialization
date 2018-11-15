package dataacces;

import java.util.ArrayList;
import java.util.List;
import Bussiness.Customer;
import Bussiness.CustomerRatting;
import Bussiness.Product;

import Bussiness.ProductType;
import Bussiness.StoreLocation;




public class TestData {
	@SuppressWarnings("serial")
	List<User> allUsers = new ArrayList<User>() {
		{
			add(new User("Admin1", "xyz", Auth.ADMIN));
			add(new User("Admin2", "abc", Auth.ADMIN));
			add(new User("Admin3", "111", Auth.ADMIN));
		}
	};
	@SuppressWarnings("serial")
	public List<Customer> allCustomers = new ArrayList<>() {
		{
			add(new Customer("Joe", "Thomas", "cus1", "happy",CustomerRatting.POOR));
			add(new Customer("Sandra", "Thomas", "San","happys",CustomerRatting.EXCELLENT));
			add(new Customer("Nirmal", "Pugh", "nina","happyn",CustomerRatting.GOOD));
			add(new Customer("Andrew", "Cleveland", "976-445","happy6",CustomerRatting.EXCELLENT));
			add(new Customer("Sarah", "Connor", "123-422-2663","happy",CustomerRatting.POOR));
		}
	};
	
	@SuppressWarnings("serial")
	List<Product> allProducts = new ArrayList<>() {
		{
			add(new Product("20", "mouse", 21, ProductType.COMPUTER,StoreLocation.STORE));
			add(new Product("22", "Advil", 7, ProductType.HEALTH,StoreLocation.STOKE));
			add(new Product("24", "toy Bird",24, ProductType.OTHER,StoreLocation.STORE));
			add(new Product("26", "Tape", 7, ProductType.AUDIOVIDEO,StoreLocation.STOKE));
			add(new Product("28", "keyboard", 21, ProductType.COMPUTER,StoreLocation.STORE));
			add(new Product("30", "multivitamins", 7, ProductType.HEALTH,StoreLocation.STOKE));
			add(new Product("32", "paper towel",24, ProductType.OTHER,StoreLocation.STORE));
			add(new Product("34", "stereo", 7, ProductType.AUDIOVIDEO,StoreLocation.STOKE));
			
		}
	};
	
	public static void main(String[] args) {
		TestData td = new TestData();
	td.ProductData();
		td.customerData();
		td.userData();
		DataAccess da = new DataAccessFacade();
		//System.out.println(da.readProductMap());
		//System.out.println(da.readCustomerMap());
		//System.out.println(da.readUserMap());
		System.out.print(da.searchCustomer("cus1"));
	}
	public void userData() {
		DataAccessFacade.loadUserMap(allUsers);
	}
	///create Products
	public void ProductData() {
		
		DataAccessFacade.loadProductMap(allProducts);
	}
	
	public void customerData() {
		DataAccessFacade.loadCustomerMap(allCustomers);
	}
	
}
