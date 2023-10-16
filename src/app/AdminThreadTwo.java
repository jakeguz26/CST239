package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Second AdminThread
 * Exists on Inventory-side of the network
 * Responsible for receiving data from admin software
 */
public class AdminThreadTwo extends Thread {
	
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	private Inventory inventory;

	public AdminThreadTwo(Inventory inventory) {
	
		this.inventory = inventory;
	}
	
	/**
	 * Invokes start()
	 */
	public void run() {
		
		try {
			this.start("127.0.0.1", 6668);
		} catch (UnknownHostException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

}

	/**
	 * Establishes connection with admin software
	 * Responsible for receiving data from admin software and utilizing the string to instantiate new Product element
	 * New product element then gets added to Inventory
	 * @param ip
	 * @param port
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void start(String ip, int port) throws UnknownHostException, IOException {
			
		clientSocket = new Socket(ip, port);
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		String input = in.readLine();
		
		in.close();
		out.close();
		clientSocket.close();
		
		inventory.productList.add(new Product(input));
	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.run();	
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
