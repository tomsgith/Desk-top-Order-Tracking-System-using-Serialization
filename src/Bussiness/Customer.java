package Bussiness;

import java.io.Serializable;

public class Customer implements Serializable{
	
/**
	 * 
	 */
private static final long serialVersionUID = -381210821274195139L;
private String Fname;
private String Lname;
private String cuId;
private String Password;
private Order order;
private double next;
private CustomerRatting rate;
public Customer(String fname, String lname, String cuId, String password,CustomerRatting rate) {
	Fname = fname;
	Lname = lname;
	this.cuId = cuId;
	this.Password = password;
	this.rate=rate;
	order=new Order();
}

public CustomerRatting getRate() {
	return rate;
}

public void setRate(CustomerRatting rate) {
	this.rate = rate;
}

public String getFname() {
	return Fname;
}

public void setFname(String fname) {
	Fname = fname;
}

public String getLname() {
	return Lname;
}

public void setLname(String lname) {
	Lname = lname;
}

public String getCuId() {
	return cuId;
}

public void setCuId(String cuId) {
	this.cuId = cuId;
}

public String getPassword() {
	return Password;
}

public void setPassword(String password) {
	Password = password;
}

public Order getOrder() {
	return order;
}

public void setOrder(Order order) {
	this.order = order;
}
public double payBill() {
	return order.calculateAllPrice()-discount();
}
public double totalPrice() {
	return order.calculateAllPrice();
}
public void calcDiscForNextOrder() {
	if(order.Allpoints()>=25)
		 next=0.4;
}
public double discount() {
	calcDiscForNextOrder();
 double val= order.calculateAllPrice()*next;
 if(val>0)
 next=0;
	 return val;
 
}
@Override
public String toString() {
	return "Customer [Fname=" + Fname + ", Lname=" + Lname + ", cuId=" + cuId + ", Password=" + Password + ", order="
			+ order + "]";
}




}
