package org.mcghie.ace2.single;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private int port;
	private ServerSocket socket;

	public Server(int lPort) {
		// create socket
		port = lPort;
		try {
				System.out.println("Break 1");
				socket = new ServerSocket(port);
				System.out.println("Break 2");
				Socket clientSocket = socket.accept();
				System.out.println("Break 4");
				ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
				BufferedReader in = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()));
				String inputLine = in.readLine();
				System.out.println("got input from client");
				System.out.println(inputLine);
				out.writeObject(in);
				System.out.println("Sent user reply");
				clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}