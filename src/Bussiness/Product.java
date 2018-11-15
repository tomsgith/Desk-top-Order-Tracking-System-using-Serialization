
package Bussiness;

import java.io.Serializable;
import java.time.LocalDate;

public class Product  implements Serializable{
	

	private static final long serialVersionUID = 1L;
private String id;
private String description;
private double price;
private ProductType type;
private StoreLocation p;
//private LocalDate shippingDate; 
private Order order;
public Product(String id, String description, double price, ProductType type, StoreLocation p) {

	this.id = id;
	this.description = description;
	this.price = price;
	this.type = type;
	this.p = p;
}

public Order getOrder() {
	return order;
}

public void setOrder(Order order) {
	this.order = order;
}

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public ProductType getType() {
	return type;
}
public void setType(ProductType type) {
	this.type = type;
}
public StoreLocation getP() {
	return p;
}
public void setP(StoreLocation p) {
	this.p = p;
}


public LocalDate getShippingDate() {
	if(p.equals(StoreLocation.STOKE))
	return LocalDate.of(order.getOrderdate().getYear(), order.getOrderdate().getMonth(), order.getOrderdate().getDayOfMonth()+1);
	return LocalDate.of(order.getOrderdate().getYear(), order.getOrderdate().getMonth(), order.getOrderdate().getDayOfMonth()+5);
	
}
public LocalDate arivalDate() {
	if(p.equals(StoreLocation.STOKE))
	return LocalDate.of(order.getOrderdate().getYear(), order.getOrderdate().getMonth(), order.getOrderdate().getDayOfMonth()+7);
	return LocalDate.of(order.getOrderdate().getYear(), order.getOrderdate().getMonth(), order.getOrderdate().getDayOfMonth()+7);
	
}

//public void setShippingDate(LocalDate shippingDate) {
//	this.shippingDate = shippingDate;
//}
@Override
public String toString() {
	return "Product [id=" + id + ", description=" + description + ", price=" + price + ", type=" + type + ", p=" + p
			+ "]";
}


}
