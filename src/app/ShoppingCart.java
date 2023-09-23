package app;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Iterator;

/**
 * ShoppingCart class that will be used to create cart object that track user's product choices
 */
public class ShoppingCart {
	
	ArrayList<Product> cartItems;
	
	/**
	 * Constructor for ShoppingCart class
	 * Instantiates ArrayList object and assigns to cartItems field
	 */
	public ShoppingCart() {
		cartItems = new ArrayList<>();
	}
	
	/**
	 * Getter for value associated with cartItems field
	 * @return ArrayObject that contains Product elements
	 */
	public ArrayList getCartItems() {
		return cartItems;
	}
	
	/** Adds Product elements to cartItems field
	 * @param item Instance of Product that will be added to cartItems field
	 */
	public void addItem(Product item) {
		cartItems.add(item);
		System.out.println("\n" + item.getName() + " added!!!");
		this.viewShoppingCart();
	}
	
	/**
	 * Displays current contents of cartItems field
	 */
	public void viewShoppingCart() {
		if (cartItems.size() > 0) {
			System.out.println("Here is your cart:\n\n*******************");
			
			for (int i = 0; i < cartItems.size(); i++) {
				System.out.println(cartItems.get(i).getName() + "\n********************");	
			}
			
			System.out.println("Your total is: $" + calculateTotal());
			
		} else {
			System.out.println("Your cart is empty!\n\n");
		}
		
	}
	
	/**
	 * Adds up all the prices of items that are currently in the cart
	 * Formats the returned string to only display 2 numbers after the decimal
	 * @return a String that represents the customer's total bill
	 */
	public String calculateTotal() {
		
		DecimalFormat df = new DecimalFormat("0.00");
		double total = 0;
		
		for (int i = 0; i < cartItems.size(); i++) {
			total = total + cartItems.get(i).getPrice();
		}
		
		String formattedTotal = df.format(total);
		return formattedTotal;
	}
	
	/**
	 * Removes item from cartItems field
	 * @param index integer that will represent index of Product element to be removed from cartItems field
	 */
	public void removeItem(int index) {
		if (cartItems.size() > 0) {
			cartItems.remove(index);
			System.out.println("item removed!");
		} else
			System.out.println("your cart is empty!");
	}

	public void removeAllItems() {
		Iterator<Product> iterator = cartItems.iterator();
		while(iterator.hasNext()) {
			Product product = iterator.next();
			product.increaseQuantity(1);
			iterator.remove();
		}
	}
	
}
