package app;
import java.io.*;

/**
 * Health class
 * Inherits from Product superclass
 */
public class Health extends Product {

	/**
	 * Constructor for Health class
	 * Passes various values into the Health fields upon instantiation
	 * Invokes constructor of Product using super()
	 * Invokes inherited method readFile() 
	 */
	public Health() {
		super();	
		readFile("health.txt");
	}
}
