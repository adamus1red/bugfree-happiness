package org.mcghie.ace2.single;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		String host = "127.0.0.1"; // args[0];
		int port = 6100; // Integer.parseInt(args[1]);
		String sName = Integer.toString(randInt(0, 999999));
		getinput(host, port, sName);
	}

	private static void getinput(String host, int port, String sName) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (true) {

			System.out
					.println("Enter 1 to start the client or 2 to start the server");
			System.out.println("or enter q to exit");
			String input = in.nextLine();
			String s = input.substring(0, 1);
			if (s.equals("2")) {
				Server server = new Server(port);
			} else if (s.equals("1")) {
				Client client = new Client(host, port, sName);
			} else if (s.equals("q")) {
				System.out.println("Good bye");
				break;
			} else {
				System.out.println("Invalid input. Try again.");
			}
		}
		in.close();
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
