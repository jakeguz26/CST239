package app;
import java.util.Scanner;

public class Store {

	String store_name;
	Inventory inventory;
	
	public Store(String name) {
		this.store_name = name;
		this.inventory = new Inventory();
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}	
	
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public void endShopping() {
		System.out.println("Thanks for coming! Come back soon!");
		int exitStatus = 0;
        System.exit(exitStatus);
	}

	public static void main(String[]args) {
		
		Store store = new Store("Jake's Store");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to " + store.getStore_name() + "!!" );
		System.out.println("Would you like to shop? Enter yes or no:");
		String userInput = scanner.nextLine();
		
		if (userInput.equals("yes")){
			System.out.println("Welcome!");
		} else {
			store.endShopping();
		}
		
		ShoppingCart cart = new ShoppingCart();
		
		System.out.println("Would you like to view the menu?");
		userInput = scanner.nextLine();
		
		if (userInput.equals("yes")){
			store.inventory.displayMenu();
		} else {
			store.endShopping();
		}
		
	}
	
}
