/*
 *
 * Filename: MessageImpl.java
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

import java.io.Serializable;

/**
 * This java program allows a client to connect to a server socket and send a string to the server.
 * The server then responds with the character count and digit count of the received text.
 * 
 * @author Adam McGhie
 * 
 */

public class MessageImpl implements Message, Serializable {

	/**
	 * Set ID for serialising object
	 */
	private static final long serialVersionUID = -5819304224681541725L;
	public int digitCount;
	public int characterCount;
	private String message;

	/**
	 * Create message info and default all counters to 0
	 * 
	 * @see org.mcghie.ace2.single.Message#setCounts()
	 */
	public MessageImpl(String message) {
		digitCount = 0;
		characterCount = 0;
		this.message = message;
		setCounts();
	}

	
	/**
	 * Sets the Character count and Digit count when called. 
	 * 
	 * Note: It does not count spaces " " and includes digits in the character count.
	 * 
	 * @see org.mcghie.ace2.single.Message#setCounts()
	 */
	public void setCounts() {
		if (message == null) {
			characterCount = 0;
			digitCount = 0;
		} else {
			String message_stripped = message.replaceAll("\\s+", "");
			characterCount = message_stripped.length();
			String message_digits = message.replaceAll("\\D+", "");
			digitCount = message_digits.length();
		}
	}

	
	/**
	 * Return the character count of the message as counted by setCounts().
	 * 
	 * @see org.mcghie.ace2.single.Message#setCounts()
	 */
	@Override
	public int getCharacterCount() {
		// TODO Auto-generated method stub
		return characterCount;
	}

	
	/**
	 * Return the digit count of the message as counted by setCounts();
	 * 
	 * @see org.mcghie.ace2.single.Message#setCounts()
	 */
	@Override
	public int getDigitCount() {
		// TODO Auto-generated method stub
		return digitCount;
	}

}
