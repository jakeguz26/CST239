package app;
import java.util.Scanner;

/**
 *Store class. Contains our main method and several additional methods relating to the top layer of the program. 
 */
public class Store {

	String storeName;
	Inventory inventory;
	/**
	 * Constructor method for instances of Store
	 * @param name string argument that gets passed to our constructor
	 * It will be associated with our 'storeName' field
	 */
	public Store(String name) {
		this.storeName = name;
		this.inventory = new Inventory();
	}
	/**
	 * Getter method for value associated with "storeName" field
	 * @return the string that represents the "storeName" field
	 */
	public String getStore_name() {
		return storeName;
	}
	/**
	 * Setter method to set the value associated with "storeName" field
	 * @param store_name String value that will be passed to "storeName" field as the new value
	 */
	public void setStore_name(String store_name) {
		this.storeName = store_name;
	}	
	/**
	 * Getter method that returns the inventory object that is associated with our 'inventory' field
	 * @return inventory object that is associated with the 'inventory' field
	 */
	public Inventory getInventory() {
		return inventory;
	}
	/**
	 * Terminates the program and prints 'good bye' message
	 */
	public void endShopping() {
		System.out.println("Thanks for coming! Come back soon!");
		int exitStatus = 0;
        System.exit(exitStatus);
	}
	/**
	 * Main method that handles the programming flow of the application
	 * @param args
	 */
	public static void main(String[]args) {
		
		Store store = new Store("Jake's Store");
		Scanner scanner = new Scanner(System.in);
		
		boolean stay = true;
		
		System.out.println("Welcome to " + store.getStore_name() + "!!" );
		System.out.println("Would you like to shop? Enter yes or no:");
		
		while (stay == true) {
			String userInput = scanner.nextLine();
			
			if (userInput.equals("yes")){
				store.inventory.accessCart();
				stay = false;
			} else if (userInput.equals("no")) {
				store.endShopping();
			} else {
				System.out.println("Invalid input. Please enter 'yes' or 'no':\n");
			}
		}
		
		store.endShopping();
		
	}
			
}
