package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.Product;

public class ProductTest {

	private Product product;
	
	@Before
	public void setUp() {
		
		String productFields = new String("Test product|Product used in test class|1.99|5");
		product = new Product(productFields);
	}
	
	@Test
	public void testGetName() {
		
		assertEquals(product.getName(), "Test product");
	}

	@Test
	public void testGetDescription() {
		
		assertEquals(product.getDescription(), "Product used in test class");	
	}

	@Test
	public void testGetPrice() {
		
		assertEquals(product.getPrice(), 1.99, 0.001);
	}
	
	@Test
	public void testGetQuantity() {
		
		assertEquals(product.getQuantity(), 5);
	}

	@Test
	public void testIncreaseQuantity() {
		
		int initialQuantity = product.getQuantity();
		product.increaseQuantity(1);
		int finalQuantity = product.getQuantity();
		
		assertEquals(initialQuantity + 1, finalQuantity);
	}

	@Test
	public void testReadFile() {
		
		product.readFile("test.txt");
		assertEquals(product.getName(), "Friend");
		assertEquals(product.getDescription(), "A companion that automatically raises health level");	
		assertEquals(product.getPrice(), 65.99, 0.001);
		assertEquals(product.getQuantity(), 1);
	}

	@Test
	public void testCompareTo() {
		
	    Product product1 = new Product("Apple|Apple for eating|10.99|1|");
	    Product product2 = new Product("Banana|Banana for eating|10.99|1|");
	    

	    int result = product1.compareTo(product2);
	    assertTrue(result < 0);
	}

}
