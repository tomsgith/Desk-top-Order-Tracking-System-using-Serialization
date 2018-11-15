package Bussiness;

import java.io.Serializable;

public enum ProductType implements Serializable {
COMPUTER(2.00),HEALTH(1.00),AUDIOVIDEO(0.5),OTHER(0.25);
double douboeVal;

private ProductType(double d) {
	this.douboeVal = d;
}

public double getD() {
	return douboeVal;
}

}
