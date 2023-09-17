package app;

/**
 * Heal class
 * Inherits from Product superclass
 */
public class Health extends Product {

	/**
	 * Constructor for Health class
	 * Passes various values into the Health fields upon instantiation
	 * Invokes constructor of Product using super()
	 */
	public Health() {
		super();	
		this.name = "Heart Container";
		this.description = "Refills health level by 1";
		this.price = 12.99d;
		this.quantity = 10;
	}
}
