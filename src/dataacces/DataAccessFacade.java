package dataacces;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import Bussiness.Customer;
import Bussiness.Product;




public class DataAccessFacade implements DataAccess {
	
	enum StorageType {
		PRODUCTS, CUSTOMERS,USERS;
	}
	
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "\\src\\dataacces\\storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	

	
	////specialized lookup methods
	//public LibraryMember searchMember(String memberId) {
		//implement
	//}
	
	public Product searchProduct(String id) {
		HashMap<String,Product> productMap =  readProductMap();
		Product p = productMap.get(id);
		return p;
	}
	
	public Auth login(String id, String pwd) {
		HashMap<String, User> userMap = readUserMap();
		if(userMap.containsKey(id)) {
		User user = userMap.get(id);
		if(pwd.equals(user.getPassword())) {
			return user.getAuthorization();
		}
		}
		HashMap<String,Customer> CustomerMap =  readCustomerMap();
		Customer cu = CustomerMap.get(id);
		if(!CustomerMap.containsKey(id)) return null;
		if(pwd.equals(cu.getPassword())) {
			return Auth.CUSTOMER;
		}
		return null;
	}
	
	
	public boolean isCustomerAvailable(String cuid)
	{
		Customer cu=searchCustomer(cuid);
		if(cu==null)
			return false;
		return true;
		
	}
	
	////////////////////////////////////////////////////////////////////////////
	public Customer searchCustomer(String cuid) {
		HashMap<String,Customer> CustomerMap =  readCustomerMap();
		Customer cu = CustomerMap.get(cuid);
		return cu;
	}
	public Customer searchTrckingNum(int tr) {
		HashMap<String,Customer> CustomerMap =  readCustomerMap();
		for(Customer cu:CustomerMap.values()) {
		if(cu.getOrder().getRanN()==tr)
			return cu;
		
		}
		return null;
	}
	
	public User searchUser(String usID) {
		HashMap<String,User> LibraryMembersMap =  readUserMap();
		User us = LibraryMembersMap.get(usID);
		return us;
	}
	
	
//	public void saveLibraryMember(LibraryMember Member) {
//		HashMap<String, LibraryMember> MemberMap =readLibraryMemberMap();
//	    String MemmberID = Member.getMemeberID();
//		MemberMap.put(MemmberID, Member);
//		saveToStorage(StorageType.MEMBERS, MemberMap);	
//		
//		
//	}
	
//	@SuppressWarnings("unchecked")
//	public  HashMap<String,LibraryMember> readLibraryMemberMap() {	
//		return (HashMap<String, LibraryMember>) readFromStorage(StorageType.MEMBERS);
//	}
	
	
	///////save methods
	//saveNewMember
	//public void saveNewMember(LibraryMember member) 
		
	public void addCustomer(Customer cu) {
		updateCustomer(cu);
	}
	public void updateCustomer(Customer cu) {
		
		HashMap<String,Customer> customerHashMap =  readCustomerMap();
		String cuID = cu.getCuId();
		customerHashMap.put(cuID, cu);
		System.out.println("its updating");
		saveToStorage(StorageType.CUSTOMERS, customerHashMap);	
	}
	//save new lendable item
	public void AddProduct(Product pro) {
		 updateProduct( pro);
	}
	
	public void updateProduct(Product pro) {
		HashMap<String, Product> Productmap = readProductMap();
		String Pid = pro.getId();
		Productmap.put(Pid, pro);
		saveToStorage(StorageType.PRODUCTS, Productmap);
	}
	
	//////read methods that return full maps
	
	
	@SuppressWarnings("unchecked")
	public  HashMap<String,Product> readProductMap() {	
		return (HashMap<String,Product>) readFromStorage(StorageType.PRODUCTS);
	}
	@SuppressWarnings("unchecked")
	public  HashMap<String,User> readUserMap() {	
		return (HashMap<String,User>) readFromStorage(StorageType.USERS);
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Customer> readCustomerMap() {
		return (HashMap<String, Customer>)readFromStorage(StorageType.CUSTOMERS);
	}
	
	
	/////load methods - these place test data into the storage area
	///// - used just once at startup  
	//static void loadMemberMap(List<LibraryMember> memberList) {
		
	static void loadProductMap(List<Product> productlist) {
		HashMap<String, Product> map = new HashMap<>();
		//extract each product in the productlist, and add (id, each product item) as an entry in the HashMap
		productlist.forEach(prod -> map.put(prod.getId(), prod));
		saveToStorage(StorageType.PRODUCTS, map);
	}
	static void loadCustomerMap(List<Customer> CustomerList) {
		HashMap<String, Customer> map = new HashMap<>();
		CustomerList.forEach(cus -> map.put(cus.getCuId(), cus));
		saveToStorage(StorageType.CUSTOMERS, map);
	}
	static void loadUserMap(List<User> userList) {
		HashMap<String, User> map = new HashMap<String, User>();
		userList.forEach(user -> map.put(user.getId(), user));
		saveToStorage(StorageType.USERS, map);
	}
	
	static void saveToStorage(StorageType type, Object ob) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}
	
	static Object readFromStorage(StorageType type) {
		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			in = new ObjectInputStream(Files.newInputStream(path));
			retVal = in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return retVal;
	}
	
//	public static void main(String[] args) {
//		HashMap<String, Customer> hm = new HashMap<>();
//		hm = (HashMap<String, Customer>)readFromStorage(StorageType.CUSTOMERS);
//		Customer c1=hm.get("15");
//		System.out.println(c1);
//		for(Customer c: hm.values()) {
//			System.out.println(c);
//		}
//	}
		
}
