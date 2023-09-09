package app;

public class Product {

	String name;
	String description;
	double price; 
	int quantity; 
	
	public Product() {
		this.name = "heart container";
		this.description = "a heart container that refills your life meter by 1";
		this.price = 12.99d;
		this.quantity = 10;	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
