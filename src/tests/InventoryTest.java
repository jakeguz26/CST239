package tests;
import app.*;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;
public class InventoryTest {

	@Test
	public void testInventory() {
		
		Inventory inventory = new Inventory();
		Class<?> expectedClass = Inventory.class;
		assertTrue(expectedClass.isInstance(inventory));
	}
	
	@Test
	public void testGetProductList() {
		
		Inventory inventory = new Inventory();
		assertNotNull(inventory.getProductList());
	}
	
	@Test
	public void testGetCart() {
		
		Inventory inventory = new Inventory();
		assertNotNull(inventory.getCart());
	}

	@Test
	public void testSortItems() {
		
		Inventory inventory = new Inventory();
		
		// add items to test list
		ArrayList<Product> testList = new ArrayList<>();
		
		ChestArmor chestArmor = new ChestArmor();
		testList.add(chestArmor);
		
		Health heartContainer = new Health();
		testList.add(heartContainer);
		
		Helmet helmet = new Helmet();
		testList.add(helmet);
		
		Lightsaber lightsaber = new Lightsaber();
		testList.add(lightsaber);
		
		MasterSword masterSword = new MasterSword();
		testList.add(masterSword);
		
		// get names from each product in test list
		String[] testListNames = new String[5] ;
		
		for(int i = 0; i < testList.size(); i++) {
			testListNames[i] = testList.get(i).getName();
		}
		
		// get names from each product in inventory and call sort()
		inventory.sortItems();
		String[] inventoryListNames = new String[5] ;
		
		for(int i = 0; i < testList.size(); i++) {
			inventoryListNames[i] = inventory.getProductList().get(i).getName();
		}
		
		assertArrayEquals(inventoryListNames, testListNames);
	}

	@Test
	public void testAddItem() {
		
		Inventory inventory = new Inventory();
		ShoppingCart cart = inventory.getCart();
		int initialCartSize = cart.getCartItems().size();
		cart.addItem(inventory.getProductList().get(0));
		int newCartSize = cart.getCartItems().size();
		
		assertEquals(initialCartSize + 1, newCartSize);
	}

	@Test
	public void testRemoveItem() {
		
		Inventory inventory = new Inventory();
		
		ShoppingCart cart = inventory.getCart();
	
		//add several items to cart
		cart.addItem(inventory.getProductList().get(0));
		cart.addItem(inventory.getProductList().get(1));
		
		int initialCartSize = cart.getCartItems().size();
		
		inventory.getCart().removeItem(0);
	
		int newCartSize = cart.getCartItems().size();
		
		assertEquals(initialCartSize - 1, newCartSize);	}
}
