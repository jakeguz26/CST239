package tests;
import app.Inventory;
import app.Store;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StoreTest {

	private Store store;
	
	@Before
	public void setUp() {
		
		store = new Store("My store");
	}
	
	@Test
	public void testStore() {
		
		Class<?> expectedClass = Store.class;
		assertTrue(expectedClass.isInstance(store));
	}
	
	@Test
	public void testGetStoreName() {
		
		String test = new String("My store");
		assertEquals(store.getStoreName(), test);
	}

	@Test
	public void testGetInventory(){
	
		Inventory inventory = store.getInventory();
		assertNotNull(inventory);
	}
}
