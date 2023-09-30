package app;

/**
 * Weapon superclass
 * Inherits from Product
 */
public class Weapon extends Product implements Comparable<Weapon> {

	/**
	 * Constructor for Weapon
	 * Invokes constructor for Product
	 */
	public Weapon() {
		super();	
	}
	
	/**
	 * Implements compareTo method from Comparable interface
	 * Compares values associated with the name field of our weapons class
	 */
	@Override
	public int compareTo(Weapon other) {
		return this.name.compareToIgnoreCase(other.name);
	}
}	
