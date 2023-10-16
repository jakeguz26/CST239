package app;
import java.io.*;
import java.net.*;

/**
 * AdminThread class
 * Runs on separate thread from Inventory
 * Connects to AdminService class via socket connection
 */
public class AdminThread extends Thread {

	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	private Inventory inventory;
	protected volatile boolean run = true;
	
	private Thread adminTwo;
	
	public AdminThread(Inventory inventory) {
		
		this.inventory = inventory;
	}
	
	/**
	 * Invokes start() 
	 */
	public void run() {
		
			try {
				this.start("127.0.0.1", 6667);
			} catch (UnknownHostException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
	}
	
	/**
	 * Establishes connection between inventory class and admin service software
	 * Specifically provides functionality to send elements of Inventory array back to admin service software
	 * @param ip
	 * @param port
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void start(String ip, int port) throws UnknownHostException, IOException {
				
			clientSocket = new Socket(ip, port);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			this.sendMessage();
			out.close();
			clientSocket.close();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.run();	
	}
	
	/**
	 * Invokes createProductStrings
	 * Assigns return value from createProductStrings to products local variable
	 * Outputs value of products to admin software via "out" local variable
	 * @throws IOException
	 */
	public void sendMessage() throws IOException {
		
		String products = this.createProductStrings();
		out.println(products);
	}
	
	/**
	 * Builds one singular string object by parsing through array object in inventory
	 * @return
	 */
	public String createProductStrings() {
		
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < inventory.productList.size(); i++) {
			result.append("\n***" + inventory.productList.get(i).getName() + "***" +
					"\n\n" + "- " + inventory.productList.get(i).getDescription() +
					"\n" + "- $" + inventory.productList.get(i).getPrice() +
					"\n" + "- " + inventory.productList.get(i).getQuantity() + "\n");
		}
		return result.toString();
	}
	
	/**
	 * Closes resources
	 */
	public void shutDown() {
		
		try {
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
