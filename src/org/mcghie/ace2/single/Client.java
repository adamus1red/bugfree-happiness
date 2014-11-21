package org.mcghie.ace2.single;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Client(String rHost, int rPort, String rSName) {
		try {
			System.out.println("Break 1");
			Socket socket = new Socket(rHost, rPort);
			System.out.println("Break 2");
			getInput(socket);
			System.out.println("Break 3");
			// receive the response from the server
			System.out.println("Recieving response...");
			InputStream in = socket.getInputStream();
			ObjectInputStream inStream = new ObjectInputStream(in);
			// in.close();
			try {
				while(inStream.readObject() != null){
					Object responce = inStream.readObject();
					System.out.println(responce.toString());
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
			System.out.println("Response recieved from the server...");
		} catch (UnknownHostException e) {
			System.out
					.println("Check the server is running because I cannie connect tae it");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getInput(Socket socket) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println("Break 4");
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		String s = input.nextLine();
		out.println(s);
		System.out.println("Break 5");
		input.close();

	}
}
