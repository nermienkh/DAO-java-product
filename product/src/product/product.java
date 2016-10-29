package product;
//creating a class 
public class product {
private String ProductID;
private String Type;
private String Manufacturer;
private String Production_Date;
private String Expiry_Date;

//constructor doesnot return values , it takes values we can use it to execute a methode in object 
public product(){}

//encapsulation :getters and setters 
public String getProductID() {
	return ProductID;
}

public void setProductID(String productID) {
	this.ProductID = productID;
}

public String getType() {
	
	return Type;
}

public void setType(String type) {
	this.Type = type;
}

public String getManufacturer() {
	return Manufacturer;
}

public void setManufacturer(String manufacturer) {
	this.Manufacturer = manufacturer;
}

public String getProduction_Date() {
	return Production_Date;
}

public void setProduction_Date(String production_Date) {
	this.Production_Date = production_Date;
}

public String getExpiry_Date() {
	return Expiry_Date;
}

public void setExpiry_Date(String expiry_Date) {
	this.Expiry_Date = expiry_Date;
}


}
