package org.mcghie.ace2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		String host = "127.0.0.1"; //args[0];
		int port = 6100; //Integer.parseInt(args[1]);
		String sName = Integer.toString(randInt(0, 999999));
		ExecutorService pool = Executors.newFixedThreadPool(10);

		// Start Server
		pool.submit(new Server(host, port));
		//for (int i = 0; i < 5; i++){
			@SuppressWarnings("unused")
			Client client = new Client(host, port, sName);
		//}
		
		pool.shutdown();
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
