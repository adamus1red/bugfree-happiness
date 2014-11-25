/*
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

package org.mcghie.ace2.single;

/**
 * This java program allows a client to connect to a server socket and send a string to the server.
 * The server then responds with the character count and digit count of the received text.
 * 
 * It takes in 2 optional cli arguments; 
 * 
 * Argument one: Host the client will connect to
 * Argument two: Port the server will run on 
 * 
 * @author Adam McGhie
 * 
 */

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String host;
		int port;
		if (args[0] == null) {
			host = "127.0.0.1"; // if we get no inputs on startup defualt
		} else {
			host = args[0]; // Get
		}
		if (args[1] == null) {
			port = 6100;
		} else {
			port = Integer.parseInt(args[1]); // Integer.parseInt(args[1]);
		}
		getinput(host, port);
	}

	/**
	 * Get user input from command line and process it.
	 * 
	 * @author Adam McGhie
	 */
	private static void getinput(String host, int port) {
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
				startClient(host, port, true);
			} else if (s.equals("q")) {
				System.out.println("Good bye");
				break;
			} else {
				System.out.println("Invalid input. Try again.");
			}
			in.close();
		}
	}

	private static void startServer(int port) {
		@SuppressWarnings("unused")
		Server server = new Server(port);
	}

	private static void startClient(String host, int port, boolean b) {
		@SuppressWarnings("unused")
		Client client = new Client(host, port, true);
	}
}
