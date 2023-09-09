package app;
import java.util.ArrayList;

public class Inventory {
	
	ArrayList<Product> productList;
	
	public Inventory() {
		productList = new ArrayList<>();
		Product heartContainer = new Product(); 
		productList.add(heartContainer);
	}
	
	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	public void displayMenu() {
		System.out.println("Check out our menu!\n");
		
		for (int i = 0; i < productList.size(); i++) {
			System.out.println("***" + productList.get(i).getName() + "***" +
					"\n\n" + "- " + productList.get(i).getDescription() +
					"\n" + "- $" + productList.get(i).getPrice() +
					"\n" + "- " + productList.get(i).getQuantity());
		}

	}
	
}
