package app;
import java.util.*;
import java.util.Scanner;

/**
 * Inventory class
 * Tracks items available for purchase and handles some programming flow
 */
public class Inventory {
	
	ArrayList<Product> productList;
	ShoppingCart cart;
	
	/**
	 * Constructor method for instances of Inventory class 
	 * Instantiates ArrayList object to be used as data-structure that holds Product instances
	 * Instantiates instance of Product
	 * Adds Product instance to productList field
	 * Instantiates instance of ShoppingCart class
	 */
	public Inventory() {
		productList = new ArrayList<>();
	
		Health heartContainer = new Health();
		productList.add(heartContainer);
		
		Lightsaber lightsaber = new Lightsaber();
		productList.add(lightsaber);
		
		MasterSword masterSword = new MasterSword();
		productList.add(masterSword);
		
		ChestArmor chestArmor = new ChestArmor();
		productList.add(chestArmor);
		
		Helmet helmet = new Helmet();
		productList.add(helmet);
		
		cart = new ShoppingCart();
	}
	
	/**
	 * Getter method for our 'productList' field
	 * @return ArrayObject containing our products that are in stock
	 */
	public ArrayList<Product> getProductList() {
		return productList;
	}
	
	/**
	 * Getter method for our 'cart' field
	 * @return instance of ShoppingCart that is associated with 'cart' field
	 */
	public ShoppingCart getCart() {
		return cart;
	}
	
	/**
	 * Displays menu with items available for purchase
	 */
	public void displayMenu() {
		System.out.println("Check out our menu!");
		
		for (int i = 0; i < productList.size(); i++) {
			System.out.println("\n***" + productList.get(i).getName() + "***" +
					"\n\n" + "- " + productList.get(i).getDescription() +
					"\n" + "- $" + productList.get(i).getPrice() +
					"\n" + "- " + productList.get(i).getQuantity());
		}
	}
	
	/**
	 * Handles programming flow for shopper's options in the store
	 * Uses while loop to continuously print shoppers' store options
	 * Instantiates an instance of scanner to accept user input
	 * Calls additional methods depending on shoppers' choice
	 */
	public void	accessCart() {
		boolean stay = true ;
				
		while (stay == true) {
			System.out.println("\nWhat would you like to do in the store?\n" +
				"Type 1 for VIEW MENU\n" +
				"Type 2 for ADD ITEM\n" +
				"Type 3 for VIEW CART\n" +
				"Type 4 for REMOVE ITEM\n" +
				"Type 5 for CHECKOUT\n" +
				"Type 6 for EXIT");
			
			Scanner scanner = new Scanner(System.in);
			int userInput = 1;
			
			try {
				userInput = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid input. Please enter a number 1 through 6.");
				accessCart();
			}
			
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
					if (cart.cartItems.size() > 0) {
						System.out.println("\nI'll ring you up!");
						System.out.println("Your total is: $" + cart.calculateTotal());
						return;
					} else {
						cart.viewShoppingCart();
						break;
					}
				case 6:
					return;
				default:
					System.out.println("\nInvalid input. Please enter a number 1 through 6.");
			}
		}
	}
	
	/**
	 * Prints list of potential items
	 * Instantiates an instance of Scanner to track user input
	 * Calls addItem() method from ShoppingCart class on 'cart' field
	 * Uses 'try' and 'catch' blocks to account for invalid input
	 * Calls decreaseQuantity() on item that has been selected
	 */
	public void addItem() {
		
		boolean stay = true;
		boolean stayTwo = true;
		int userInput = -1;
		
		while(stay == true) 
		{
			System.out.println("\nWhat item would you like to add?\n");
			for (int i = 0; i < productList.size(); i++) {
				System.out.println("Type " + i + " for " + productList.get(i).getName() + " ");
			}
	
			while(stayTwo == true) 
			{
				try {
					Scanner scanner = new Scanner(System.in);
					userInput = scanner.nextInt();
					stayTwo = false;
				} catch (InputMismatchException e) {
					System.out.println("Invalid input\nPlease enter a number 1 through 4.");
				}
			}
				
			try {
				cart.addItem(productList.get(userInput));
				decreaseQuantity(productList.get(userInput));
				stay = false;
			} catch (IndexOutOfBoundsException e) {
				stayTwo = true;
				System.out.println("Invalid input\nPlease enter a number 1 through 4.");
			} 
		}	
	}
	
	/**
	 * Gives user their current cart items and asks what they would like to remove from cart
	 * Uses various loops and 'try'/'catch' blocks to check user input and re-display menu
	 */
	public void removeItem() {
		
		boolean stay = true;
		boolean stayTwo =  true;
		int userInput = 0;
		
		while(stay == true) {
			
			while(stayTwo == true) {
				
				if (cart.getCartItems().size() > 0) {
					System.out.println("\nWhat item would you like to remove?\n");
					for (int i = 0; i < cart.cartItems.size(); i++) {
						System.out.println("Type " + i + " for " + cart.cartItems.get(i).getName() + " ");
					}
				
					Scanner scanner = new Scanner(System.in);
					
					try { 
						userInput = scanner.nextInt();
						stayTwo = false;
					} catch (InputMismatchException e) {
						System.out.println("\nInvalid input.");
					}
					
				} else {
					System.out.println("\nYour cart is empty!");
					stayTwo = false;
					stay = false;
					return;
				}
			}
		
			try {
				cart.cartItems.get(userInput).increaseQuantity(1);
				cart.removeItem(userInput);
				return;
			} catch (IndexOutOfBoundsException e) {
				stay = true;
				stayTwo = true;
				System.out.println("\nInvalid input.");
			}
		}
			
	}
	
	/**
	 * Decreases 'quantity' field of product by 1
	 * @param specific instance of Product class that will have quantity field decrease by 1
	 */
	public void decreaseQuantity(Product item) {
		item.setQuantity(1);
	}
	
}
