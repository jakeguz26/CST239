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
	
	public void	accessCart() {
		boolean stay = true ;
				
		while (stay == true) {
			System.out.println("\nWhat would you like to do in the store?\n" +
				"Type 1 for VIEW MENU\n" +
				"Type 2 for ADD ITEM\n" +
				"Type 3 for VIEW CART\n" +
				"Type 4 for REMOVE ITEM\n" +
				"Type 5 for CHECKOUT");
			
			Scanner scanner = new Scanner(System.in);
			int userInput = scanner.nextInt();
			
			switch(userInput) {
				case 1:
					displayMenu();
					break;
				case 2:
					addItem();
					break;
				case 3:
					cart.viewShoppingCart();
					break;
				case 4: 
					removeItem();
					break;
				case 5:
					System.out.println("I'll ring you up! Thanks for coming!");
					return;
				default:
					System.out.println("\ninvalid input");
			}
		}
	}
	
	public void addItem() {
		System.out.println("\nWhat item would you like to add?\n");
		for (int i = 0; i < productList.size(); i++) {
			System.out.println("Type " + i + " for " + productList.get(i).getName() + " ");
		}
		
		Scanner scanner = new Scanner(System.in);
		int userInput = scanner.nextInt();
		
		cart.addItem(productList.get(userInput));
		decreaseQuantity(productList.get(userInput));
	}
	
	public void removeItem() {
		System.out.println("\nWhat item would you like to remove?\n");
		for (int i = 0; i < productList.size(); i++) {
			System.out.println("Type " + i + " for " + productList.get(i).getName() + " ");
		}
	
	Scanner scanner = new Scanner(System.in);
	int userInput = scanner.nextInt();
	cart.removeItem(userInput);
	
	}
	
	
	public void decreaseQuantity(Product item) {
		item.setQuantity(1);
	}
	
}
