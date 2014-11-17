package org.mcghie.ace2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.Callable;

public class Server implements Callable<String> {
	private int port;
	private String host;

	public Server(String lHost, int lPort) {
		// create socket
		port = lPort;
		host = lHost;
		try {
			System.out.println("Break 1");
			Socket echoSocket = new Socket(host, port);
			PrintWriter out = new PrintWriter(echoSocket.getOutputStream(),
					true);
			String input = getInput(echoSocket); // BufferedReader in = new BufferedReader(new InputStreamReader(
					//echoSocket.getInputStream()));
			sendOutput(echoSocket, input);
			//BufferedReader stdIn = new BufferedReader(new InputStreamReader(
			//		System.in));
			System.out.println("Break 2");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sendOutput(Socket socket, String input) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out =
		        new PrintWriter(socket.getOutputStream(), true);
		out.println(input);
	}

	public String getInput(Socket socket) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		String input;
		input = in.readLine();
		return input;
	}

	@Override
	public String call() throws Exception {
		return null;
	}

}