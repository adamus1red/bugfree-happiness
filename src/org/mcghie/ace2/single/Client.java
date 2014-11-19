package org.mcghie.ace2.single;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public Client(String rHost, int rPort, String rSName) {
		try {
			System.out.println("Break 1");
			Socket socket = new Socket(rHost, rPort);
			System.out.println("Break 2");
			getInput(socket);
			System.out.println("Break 3");
			while (true) {
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				System.out.println(in.toString());
			}
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
