import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class hangManTest {

	
	

	
	private String rightInput = "f";
	private String wrongStringInput = "asdfkasdfksalf";
	private String wrongIntegerInput = "32423";
	
	private boolean expectedResultForOne = true;
	private boolean expectedResultForTwo = false; // it should be false
	
	hangMan hangMan = new hangMan();
	private String rightInputForRestart = "1";
	private String wrongInputForRestart = "3";
	private String wrongStringInputForRestart = "asdf";
	
	@Test
	void testIsValidInput() {
		assertEquals(true, hangMan.isValidInput(rightInput));
		assertEquals(false, hangMan.isValidInput(wrongIntegerInput));
		assertEquals(false, hangMan.isValidInput(wrongStringInput));

	}
	
	@Test
	void testisValidRestart() {
		assertEquals(false, hangMan.isValidRestart(wrongInputForRestart));
		assertEquals(true, hangMan.isValidRestart(rightInputForRestart));
		assertEquals(false, hangMan.isValidRestart(wrongStringInputForRestart));

	}
		
	@Test
	void testisValidRestartBug() {
		assertEquals(expectedResultForOne, hangMan.isValidRestart("1"));
		assertEquals(expectedResultForTwo, hangMan.isValidRestart("2"));

	}

}
