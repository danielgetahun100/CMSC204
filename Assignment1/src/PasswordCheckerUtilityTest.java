import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;




class PasswordCheckerUtilityTest {
	ArrayList<String>password;

	@Before
	void setUp() throws Exception {
		password=new ArrayList<String>();
		String [] passwords= {"PassWord#12","123ABC%abc","manNy34$NEV","Kirsten&26","imp23","CASS45","###brez1","bowe^^"};
		password.addAll(Arrays.asList(passwords));
		
	}

	@After
	void tearDown() throws Exception {
		password=null;
	}

	@Test
	void testValidLength() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("PassWord#12"));
		}
		catch(LengthException e) {
			assertFalse("Threw Length exception",false);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	
		
	}
	@Test
	void testInvalidLength () {
		try {
			PasswordCheckerUtility.isValidPassword("imp2");
		}
		catch(LengthException e) {
			assertTrue("Threw Length exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	@Test
	void testHasUpperAlpha() {
		try {
			PasswordCheckerUtility.isValidPassword("CASsidy#45");
		}
		catch(NoUpperAlphaException e) {
			assertFalse("Threw NoUpperAlpha exception",false);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	@Test
	void testHasNoUpperAlpha() {
		try {
			PasswordCheckerUtility.isValidPassword("###brez1");
		}
		catch(NoUpperAlphaException e) {
			assertTrue("Threw NoUpperAlpha exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	@Test
	public void testHasLowerAlpha() {
		try {
			PasswordCheckerUtility.isValidPassword("HASlower*78@");
		}
		catch(NoLowerAlphaException e) {
			assertFalse("Threw NoLowerAlpha exception",false);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	@Test
	public void testHasNoLowerAlpha() {
		try {
			PasswordCheckerUtility.isValidPassword("NOLOWER&98$");
		}
		catch(NoLowerAlphaException e) {
			assertTrue("Threw NoLowerAlpha exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	@Test
	public void testHasDigit() {
		try {
			PasswordCheckerUtility.isValidPassword("Im2cool4U#");
			assertFalse("Threw HasDigit exception",false);
		}
		catch(NoDigitException e) {
			assertTrue("Threw HasDigit exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	@Test
	public void testHasNoDigit() {
		try {
			PasswordCheckerUtility.isValidPassword("ImcoolU#");
			assertTrue("threw HasDigit exception",true);
		}
		catch(NoDigitException e) {
			assertTrue("Threw HasDigit exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	@Test
	public void testHasSpecialChar() {
		try {
			PasswordCheckerUtility.isValidPassword("manNy34$NEV");
			assertFalse("Threw NoSpecialCharacter exception",false);
		}
		catch(NoDigitException e) {
			assertTrue("Threw NoSpecialCharacter exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	@Test
	public void testHasNoSpecialChar() {
		try {
			PasswordCheckerUtility.isValidPassword("manNy34NEV");
			assertTrue("Threw NoSpecialCharacter exception",true);
		}
		catch(NoDigitException e) {
			assertTrue("Threw Length exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	@Test
	public void testHasSameCharInSequence() {
		try {
			PasswordCheckerUtility.isValidPassword("PeTe34%AAA");
			assertTrue("Threw InvalidSequence exception",true);
		}
		catch(NoDigitException e) {
			assertTrue("Threw InvalidSequence exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	@Test
	public void testHasNoSameCharInSequence() {
		try {
			PasswordCheckerUtility.isValidPassword("PeTe34%AA");
			assertFalse("Threw InvalidSequence exception",false);
		}
		catch(NoDigitException e) {
			assertTrue("Threw InvalidSequence exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	

}
