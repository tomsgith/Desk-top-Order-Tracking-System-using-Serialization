package Bussiness;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order implements Serializable{
	
Random shaffle= new Random();
private static final long serialVersionUID = 5057150060338750993L;
private List<Product> products;
private LocalDate Orderdate=LocalDate.now();
private final int ranN=1+shaffle.nextInt(1000000);

public LocalDate getOrderdate() {
	return Orderdate;
}

public int getRanN() {
	return ranN;
}
public void setOrderdate(LocalDate orderdate) {
	Orderdate = orderdate;
}
Order(List<Product> prodcs){
	products=new ArrayList<>();
  products.addAll(prodcs);
  for(Product p:products)
	  p.setOrder(this);
}
Order() {
	products=new ArrayList<>();
	
	
	 
}
public void add(Product pro) {
	pro.setOrder(this);
	products.add(pro);
	
	}
public List<Product> getProducts() {
	return products;
}
public void setProducts(List<Product> products) {
	this.products = products;
}
@Override
public String toString() {
	return "Order [products=" + products + "]";
}
public double calculateAllPrice() {
	double sum=0;
	for(Product p:products)
		sum+=p.getPrice();
	return sum;
}
public double Allpoints() {
	double sum=0;
	for(Product p:products)
		sum+=p.getType().douboeVal;
	return sum;
}
}
