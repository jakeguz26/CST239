package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ InventoryTest.class, StoreTest.class, ShoppingCartTest.class, ProductTest.class, HealthTest.class })
public class AllTests {

}
