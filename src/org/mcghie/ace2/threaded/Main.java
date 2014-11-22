/*
 *
 * Filename: Main.java
 *
 * Synopsis: ace2 
 *
 * GitHub Repository: https://github.com/adamus1red/bugfree-happiness
 * 
 * Authors:
 *      Adam McGhie, Reg no: 201240207
 *
 * Promise: I confirm that this submission is all my own work.
 *
 *               (Adam McGhie)	__________________________________________
 *
 * Version: See https://github.com/adamus1red/bugfree-happiness/commits/master
 *
 */

package org.mcghie.ace2.threaded;
/**
 * This java program allows a client to connect to a server socket and send a string to the server.
 * The server then responds with the character count and digit count of the received text.
 * 
 * @author Adam McGhie
 * 
 */

import java.util.Random;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		String host = "127.0.0.1"; // args[0];
		int port = 6100; // Integer.parseInt(args[1]);
		String sName = Integer.toString(randInt(0, 999999));
		getinput(host, port, sName);
	}
	/**
	 * Get user input from command line and process it.
	 * 
	 * @author Adam McGhie
	 */
	private static void getinput(String host, int port, String sName) {
		while (true) {
			Scanner in = new Scanner(System.in);
			System.out
					.println("Enter 1 to start the client or 2 to start the server");
			System.out.println("or enter q to exit");
			String input = in.nextLine();
			String s = input.substring(0, 1);
			if (s.equals("2")) {
				startServer(port);
			} else if (s.equals("1")) {
				startClient(host, port, sName, true);
			} else if (s.equals("q")) {
				System.out.println("Good bye");
				break;
			} else {
				System.out.println("Invalid input. Try again.");
			}
			in.close();
		}
	}

	private static void startServer(int port){
		Server server = new Server(port);
	}
	
	private static void startClient(String host, int port, String sName, boolean b){
		Client client = new Client(host, port, sName, true);
	}
	
	private static int randInt(int min, int max) {

		// NOTE: Usually this should be a field rather than a method
		// variable so that it is not re-seeded every call.
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;

	}
}
