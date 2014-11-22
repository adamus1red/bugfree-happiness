/*
 *
 * Filename: Server.java
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private int port;
	private ServerSocket socket;
	private MessageImpl message;

	public Server(int lPort) {
		// create socket
		port = lPort;

		try {
			System.out.println("Break 1");
			socket = new ServerSocket(port);
			System.out.println("Break 2");
			Socket clientSocket = socket.accept();
			System.out.println("Break 4");
			ObjectOutputStream out = new ObjectOutputStream(
					clientSocket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			String inputLine = in.readLine();
			System.out.println("got input from client");
			System.out.println("User Input: " + inputLine);
			message = new MessageImpl(inputLine);
			System.out.println("Char Count: " + message.getCharacterCount()
					+ "\nDigit Count: " + message.getDigitCount());
			out.writeObject(message);
			System.out.println("Sent user reply");
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}