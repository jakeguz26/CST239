package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Health;

public class HealthTest {

	@Test
	public void testHealth() {
		
		Health health = new Health();
		assertEquals("Heart Container", health.getName());
		assertEquals("Refills life by 1", health.getDescription());
		assertEquals(12.99, health.getPrice(), 0.001);
		assertEquals(10, health.getQuantity());
	}

}
