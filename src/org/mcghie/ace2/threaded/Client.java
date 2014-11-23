/*
 *
 * Filename: Client.java
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

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {

	private Socket socket;
	private Boolean debug;

	public Client(String rHost, int rPort, String rSName, Boolean debug_message) {
		debug = debug_message;
		if (debug) {
			System.out.println("Break 1");
		}
		try {
			socket = new Socket(rHost, rPort);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (debug) {
			System.out.println("Break 2");
		}
		System.out.println();
		System.out.println("Looks like server delivered. Closing client");
	}

	private void getInput(Socket socket, Boolean debug) throws IOException {
		Scanner input = new Scanner(System.in);
		if (debug) {
			System.out.println("Break 4");
		}
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		String s = input.nextLine();
		out.println(s);
		if (debug) {
			System.out.println("Break 5");
		}
		input.close();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			getInput(socket, debug);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (debug) {
			System.out.println("Break 3");
		}
		// receive the response from the server
		if (debug) {
			System.out.println("Break 6");
		}
		InputStream in;
		ObjectInputStream inStream;
		Object responce;
		try {
			in = socket.getInputStream();
			inStream = new ObjectInputStream(in);
			responce = inStream.readObject();
			System.out.println("Number of Characters "
					+ ((MessageImpl) responce).getCharacterCount());
			System.out.println("Number of Digits "
					+ ((MessageImpl) responce).getDigitCount());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (debug) {
			System.out.println("Break 7");
		}
	}
}
