package views.view;

import javafx.beans.property.SimpleStringProperty;

public class Table2 {
private final SimpleStringProperty id;
private final SimpleStringProperty desc;
private final SimpleStringProperty price;
private final SimpleStringProperty type;
private final SimpleStringProperty loc;
private final SimpleStringProperty shi;
private final SimpleStringProperty Od;
private final SimpleStringProperty delD;

public  Table2(String id, String desc, String price, String type, String loc,
		String shi, String od,String delD) {

	this.id = new SimpleStringProperty(id);
	this.desc = new SimpleStringProperty(desc);
	this.price =new SimpleStringProperty(price);
	this.type =new SimpleStringProperty(type);
	this.loc =new SimpleStringProperty(loc);
	this.shi =new SimpleStringProperty(shi);
	Od = new SimpleStringProperty(od);
	this.delD=new SimpleStringProperty(delD);
}

public String getDelD() {
	return delD.get();
}
public void setDelD(String de) {
	this.delD.set(de);
}
public String getId() {
	return id.get();
}
public void setId(String id) {
	this.setId(id);
}
public String getDesc() {
	return desc.get();
}
public void setDesc(String desc) {
	this.desc .set(desc);
}
public String getPrice() {
	return price.get();
}
public void setPrice(String price) {
	this.price.set(price);
}
public String getType() {
	return type.get();
}
public void setType(String type) {
	this.type .set(type);
}
public String getLoc() {
	return loc.get();
}
public void setLoc(String loc) {
	this.loc.set(loc);
}
public String getShi() {
	return shi.get();
}
public void setShi(String shi) {
	this.shi.set(shi);
}
public String getOd() {
	return Od.get();
}
public void setOd(String od) {
	Od.set(od);
}


}
