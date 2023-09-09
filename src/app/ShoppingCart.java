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
		if (cartItems.size() > 0) {
			System.out.println("Here is your cart:\n\n*******************");
			
			for (int i = 0; i < cartItems.size(); i++) {
				System.out.println(cartItems.get(i).getName() + "\n********************");	
			}
		} else {
			System.out.println("Your cart is empty!\n\n");
		}
		
	}

	public void removeItem(int index) {
		if (cartItems.size() > 0) {
			cartItems.remove(index);
			System.out.println("item removed!");
		} else
			System.out.println("your cart is empty!");
		
	}
	
	public void checkOut() {	
		
	}
	
}
