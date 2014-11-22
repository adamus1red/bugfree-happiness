/*
 *
 * Filename: Message.java
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
public interface Message {
	public void setCounts();

	public int getCharacterCount();

	public int getDigitCount();
}
