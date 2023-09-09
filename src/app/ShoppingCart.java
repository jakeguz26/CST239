package app;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
	
	ArrayList<Product> cartItems;
	
	public ShoppingCart() {
		cartItems = new ArrayList<>();
	}
	
	public ArrayList getCartItems() {
		return cartItems;
	}

	public void addItem(Product item) {
		cartItems.add(item);
		System.out.println("\n" + item.getName() + " added!!!");
		this.viewShoppingCart();
	}
	
	public void viewShoppingCart() {
		System.out.println("Here is your cart:\n");
		
		for (int i = 0; i < cartItems.size(); i++) {
			System.out.println(cartItems.get(i).getName() + "\n\n");	
		}
	}

	public void removeItem() {
		
	}
	
	public void checkOut() {	
		
	}
	
}
