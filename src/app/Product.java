package app;

/**
 * Product class that will represent products to be sold in store
 */
public class Product {

	String name;
	String description;
	double price; 	
	int quantity; 
	private int index = 0;
		
	/**
	 * Constructor for instantiating objects of Product class
	 * @param quantity integer that will be passed to constructor and will be assigned to quantity field
	 */
	public Product() {
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.index += 1;
	}
	
	/**
	 * Getter for value associated with name field
	 * @return String that represents name field
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter for value associated with description field
	 * @return String that represents description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Getter for value associated with price field
	 * @return double that represents the price field
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Getter for value associated with quantity field
	 * @return integer that represents the quantity field
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Setter for quantity field
	 * Refactored to be used as mechanism for decrementing integer  
	 * @param decreaseAmount integer that will be passed to method as the parameter that denotes decrement amount
	 */
	public void setQuantity(int decreaseAmount) {
		this.quantity -= decreaseAmount;
	}
	
	/**
	 * Increases value associated with Quantity field
	 * @param increaseAmount
	 */
	public void increaseQuantity(int increaseAmount) {
		this.quantity += increaseAmount;
	}
	
}
