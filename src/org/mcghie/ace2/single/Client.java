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

package org.mcghie.ace2.single;

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
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public Client(String rHost, int rPort, String rSName, Boolean debug) {
		try {
			if (debug) {
				System.out.println("Break 1");
			}
			;
			Socket socket = new Socket(rHost, rPort);
			if (debug) {
				System.out.println("Break 2");
			}
			getInput(socket, debug);
			if (debug) {
				System.out.println("Break 3");
			}
			// receive the response from the server
			if (debug) {
				System.out.println("Break 6");
			}
			InputStream in = socket.getInputStream();
			ObjectInputStream inStream = new ObjectInputStream(in);
			if (debug) {
				System.out.println("Break 7");
			}
			try {
				Object responce = inStream.readObject();
				System.out.println("Number of Characters "
						+ ((MessageImpl) responce).getCharacterCount());
				System.out.println("Number of Digits "
						+ ((MessageImpl) responce).getDigitCount());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
			System.out.println("Looks like server delivered. Closing client");
		} catch (UnknownHostException e) {
			System.out
					.println("Check the server is running because I cannie connect tae it");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getInput(Socket socket, Boolean debug) throws IOException {
		Scanner input = new Scanner(System.in);
		if(debug){
			System.out.println("Break 4");
		}
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		String s = input.nextLine();
		out.println(s);
		if(debug){
			System.out.println("Break 5");
		}
		input.close();

	}
}
