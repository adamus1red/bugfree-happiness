/**
 * 
 */
package org.mcghie.ace2.single;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Adam McGhie
 *
 */
public class MessageImplTest {

	private MessageImpl message1;
	private MessageImpl message2;
	private MessageImpl message3;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		message1 = new MessageImpl ("Test");
		message2 = new MessageImpl(null);
		message3 = new MessageImpl("VYJQkPJ=jT'Y?'3pJ>}-pvJ\6VZYLJJ,]EtARK9^mC/_B8][n)r?drs>jSffc^0");
	}

	@Test
	public void testGetCharacterCount() {
		assertEquals(4, message1.getCharacterCount());
		assertEquals(0, message2.getCharacterCount());
		assertEquals(63, message3.getCharacterCount());
	}
	
	@Test
	public void testGetDigitCount() {
		assertEquals(0, message1.getDigitCount());
		assertEquals(0, message2.getDigitCount());
		assertEquals(5, message3.getDigitCount());
	}
}

