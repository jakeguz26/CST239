package app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Product class that will represent products to be sold in store
 */
public class Product implements Comparable<Product>{

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
	
	/**
	 * Reads information from file that is passed in
	 * Assigns information to the proper fields for each object
	 * @param inFile String that represents a txt file
	 */
	public void readFile(String inFile) {
	
		try (BufferedReader in = new BufferedReader(new FileReader(inFile));){
			
			String line;
			while((line = in.readLine()) != null) {
				String[] tokens = line.split("\\|");
				// Uses the elements we've parsed into tokens to assign to the fields of each Product instance
				this.name = tokens[0];
				this.description = tokens[1];
				this.price = Double.parseDouble(tokens[2]);
				this.quantity = Integer.parseInt(tokens[3]);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 	catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Implementation of compareTo from Comparable interface
	 * Has 4 options:
	 * Sort in ascending or descending order by 'name'
	 * Sort in ascending or descending order by 'price'
	 */
	public int compareTo(Product other) {
		
		// ***** SORT BASED ON NAME ******
		return this.name.compareTo(other.name);
		// return other.name.compareTo(this.name);
	
		// ***** SORT BASED ON PRICE ******
		//return Double.compare(this.price, other.price);
		//return Double.compare(other.price, this.price);
	}
	
	
}
