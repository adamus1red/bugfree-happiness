package org.mcghie.ace2.single;

import java.io.Serializable;

public class MessageImpl implements Message, Serializable {

	/**
	 * Set ID for serialising object
	 */
	private static final long serialVersionUID = -5819304224681541725L;
	public int digitCount;
	public int characterCount;
	private String message;

	public MessageImpl(String message) {
		digitCount = 0;
		characterCount = 0;
		this.message = message;
		setCounts();
	}

	public void setCounts() {
		String message_stripped = message.replaceAll("\\s+", "");
		characterCount = message_stripped.length();
		String message_digits = message.replaceAll("\\D+", "");
		digitCount = message_digits.length();
	}

	@Override
	public int getCharacterCount() {
		// TODO Auto-generated method stub
		return characterCount;
	}

	@Override
	public int getDigitCount() {
		// TODO Auto-generated method stub
		return digitCount;
	}

}
