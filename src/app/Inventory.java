package app;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
	
	ArrayList<Product> productList;
	ShoppingCart cart;
	
	public Inventory() {
		productList = new ArrayList<>();
		Product heartContainer = new Product(10); 
		productList.add(heartContainer);
		
		cart = new ShoppingCart();
	}
	
	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
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
	
	public void accessCart() {
		System.out.println("\nWhat item would you like to add?\n");
		for (int i = 0; i < productList.size(); i++) {
			System.out.println("Type " + i + " for " + productList.get(i).getName() + " ");
		}
		
		Scanner scanner = new Scanner(System.in);
		int userInput = scanner.nextInt();
		
		cart.addItem(productList.get(userInput));
		decreaseQuantity(productList.get(userInput));
	}
	
	public void decreaseQuantity(Product item) {
		item.setQuantity(1);
	}
	
}
