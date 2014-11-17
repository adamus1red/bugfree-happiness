package org.mcghie.ace2;

import edu.princeton.cs.introcs.Out;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Callable;

import edu.princeton.cs.introcs.In;

public class Client implements Callable<String> {

	public Client(String rHost, int rPort, String rSName) {
		String screenName = rSName;
		String host = rHost;
		int port = rPort;

		// connect to server and open up IO streams
		try {
			Socket socket = new Socket(host, port);
			In stdin = new In();
			In in = new In(socket);
			Out out = new Out(socket);
			System.err.println("Connected to " + host + " on port " + port);

			// read in a line from stdin, send to server, and print back reply
			while (!stdin.hasNextLine()) {

				// read line of client
				String s = stdin.readLine();

				// send over socket to server
				out.println("[" + screenName + "]: " + s);

				// get reply from server and print it out
				System.out.println(in.readLine());
			}

			// close IO streams, then socket
			System.err.println("Closing connection to " + host);
			out.close();
			in.close();

			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
