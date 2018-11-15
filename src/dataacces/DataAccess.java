package dataacces;

import java.util.HashMap;

import Bussiness.Customer;
import Bussiness.Product;

//import business.Book;
//import business.LibraryMember;





public interface DataAccess {
	
	public Product searchProduct(String id);
	
	
	///////save methods
	//public void saveNewMember(LibraryMember member);
	//public void updateMember(LibraryMember member);
	
	//save new book
	//public void saveNewBook(Book book);
	public void updateCustomer(Customer cu);
	public void addCustomer(Customer cu);
	public User searchUser(String usID);
	public void AddProduct(Product pro);
	public Auth login(String id, String pwd);
	//////read methods 
	public HashMap<String,Product> readProductMap();
	public HashMap<String,Customer> readCustomerMap();
	public  HashMap<String,User> readUserMap();
	//public void saveCustomer(String cuid);
	public boolean isCustomerAvailable(String MemebrID);
	public void updateProduct(Product pro);
	public Customer searchCustomer(String cuid);
	//public HashMap<String, LibraryMember> readMemberMap();



}
