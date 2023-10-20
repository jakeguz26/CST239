package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import app.*;

public class ShoppingCartTest {

	private ShoppingCart cart;
	
	@Before
	public void setUp() {
		
		cart = new ShoppingCart();
		
		// create items to add to instance of cart
		Health health = new Health();
		Helmet helmet = new Helmet();
		
		cart.addItem(helmet);
		cart.addItem(health);
	}

	@Test
	public void testGetCartItems() {
		
		ArrayList<Product> cartItems = cart.getCartItems();
		Product helmet = cart.getCartItems().get(0);
		Product health = cart.getCartItems().get(1);
		
		assertEquals(2, cartItems.size());
		assertTrue(cartItems.contains(helmet));
		assertTrue(cartItems.contains(health));
	}

	@Test
	public void testAddItem() {
		
		cart.addItem(new MasterSword());
		assertEquals(3, cart.getCartItems().size());
	}

	@Test
	public void testCalculateTotal() {
		
		String cartTotal = cart.calculateTotal();
		String test = new String("17.98");
		 
		assertEquals(test, cartTotal);
	}

	@Test
	public void testRemoveItem() {
		
		int initialCartSize = cart.getCartItems().size();
		cart.removeItem(0);
		int finalCartSize = cart.getCartItems().size();
		
		assertEquals(initialCartSize - 1, finalCartSize);
	}

}
