import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String>password;
	ArrayList<String>pass;
	@Before
	public void setUp() throws Exception {
		password=new ArrayList<String>();
		String [] passwords= {"PassWord#12","123ABC%abc","manNy34$NEV","MaVis#45@","Kirsten&26","imp23","###brez1","CASS456","boweR^^","Charre45","City%45$RRR"};
		password.addAll(Arrays.asList(passwords));
	}

	@After
	public void tearDown() throws Exception {
		password=null;
		pass=null;
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("PassWord#12"));
			PasswordCheckerUtility.isValidPassword("imp2");
			assertTrue("No length exception",false);
		}
		catch(LengthException e) {
			assertTrue("Threw Length exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("CASsidy#45"));
			PasswordCheckerUtility.isValidPassword("###brez1");
			assertTrue("Did not throw NoUpperAlpha exception",false);
		}
		catch(NoUpperAlphaException e) {
			assertTrue("Threw NoUpperAlpha exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("HASlower*78@"));
			PasswordCheckerUtility.isValidPassword("NOLOWER&98$");
			assertTrue("Did not throw NoLowerApha exception",false);
		}
		catch(NoLowerAlphaException e) {
			assertTrue("Threw NoLowerAlpha exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	/**
	 * Test if the password has between 6 and 9 characters
	 * This test should throw a WeakPasswordException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
		assertTrue(PasswordCheckerUtility.isWeakPassword("Ima#34"));
		PasswordCheckerUtility.isWeakPassword("");
		}
		catch(WeakPasswordException w) {
		assertTrue("Threw weakPassword exception",true);
		}
		
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("PeTe34%AA"));
			PasswordCheckerUtility.isValidPassword("PeTe34%AAA");
			assertTrue("did not Throw InvalidSequence exception",false);
		}
		catch(InvalidSequenceException e) {
			assertTrue("Threw InvalidSequence exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Im2cool4U#"));
			PasswordCheckerUtility.isValidPassword("ImcoolU#");
			assertTrue("did not throw HasDigit exception",false);
		}
		catch(NoDigitException e) {
			assertTrue("Threw NoDigit exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	
	/**
	 * Test if the password has 1 or more special characters
	 * Throws a NoSpecialCharacter exception for the second case
	 */
	@Test
	public void testValidPasswordNoSpecialChar() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("manNy34$NEV"));
			PasswordCheckerUtility.isValidPassword("manNy34NEV");
			assertTrue("did not throw NoSpecialCharacter exception",false);
		}
		catch(NoSpecialCharacterException e) {
			assertTrue("Threw NoSpecialCharacter exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
		PasswordCheckerUtility.isValidPassword("123ABC%abc");
		assertTrue("did not throw an exception",true);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		pass=PasswordCheckerUtility.getInvalidPasswords(password);
		Scanner in=new Scanner(pass.get(0));
		assertEquals(in.next(),"imp23");
		String comment = in.nextLine().toLowerCase();
		assertTrue(comment.contains("long"));
		//The password must be at least 6 characters long
		
		in = new Scanner(pass.get(1)); //
		assertEquals(in.next(), "###brez1");
		comment = in.nextLine().toLowerCase();
		assertTrue(comment.contains("uppercase"));
		//The password must contain at least one uppercase alphabetic character
		
		in = new Scanner(pass.get(2)); 
		assertEquals(in.next(), "CASS456");
		comment = in.nextLine().toLowerCase();
		assertTrue(comment.contains("lowercase"));
		//The password must contain at least one lowercase alphabetic character
		
		in = new Scanner(pass.get(3)); //
		assertEquals(in.next(), "boweR^^");
		comment = in.nextLine().toLowerCase();
		assertTrue(comment.contains("digit"));
		//The password must contain at least one digit
		
		in = new Scanner(pass.get(4)); //
		assertEquals(in.next(), "Charre45");
		comment = in.nextLine().toLowerCase();
		assertTrue(comment.contains("special character"));
		//The password must contain at least one special character 
		
		in = new Scanner(pass.get(5)); 
		assertEquals(in.next(), "City%45$RRR");
		comment = in.nextLine().toLowerCase();
		assertTrue(comment.contains("sequence"));
		//The password cannot contain more than two of the same character in sequence
	}
	
}

