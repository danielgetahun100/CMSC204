import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 * @author steum
 *
 */
public class CourseDBManagerSTUDENT_Test {
	private CourseDBManager manager = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		manager = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		manager = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			manager.add("SOCY100",56728,3,"HU120","Emerald Jones");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		manager.add("CMSC141",45608,1,"Distance-Learning","Ping.We Tsai");
		manager.add("SOCY100",56728,3,"HU120","Emerald Jones");
		manager.add("CHEM131",98287,4,"SC361","Valerie Pierce");
		manager.add("MATH181",83467,3,"SW215","Jack Kent");
		ArrayList<String> list = manager.showAll();
		
		
  		assertEquals(list.get(0),"\nCourse:SOCY100 CRN:56728 Credits:3 Instructor:Emerald Jones Room:HU120");
  		assertEquals(list.get(1),"\nCourse:CMSC141 CRN:45608 Credits:1 Instructor:Ping.We Tsai Room:Distance-Learning");
		assertEquals(list.get(2),"\nCourse:CHEM131 CRN:98287 Credits:4 Instructor:Valerie Pierce Room:SC361");
		assertEquals(list.get(3),"\nCourse:MATH181 CRN:83467 Credits:3 Instructor:Jack Kent Room:SW215");
	}
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("MATH181 83467 3 SW215 Jack Kent");
			inFile.print("CHEM131 98287 4 SC361 Valerie Pierce");
			
			inFile.close();
			manager.readFile(inputFile);

		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
	/**
	 * Test for the get method
	 */
	@Test
	public void testGet() {
		CourseDBElement cde=new CourseDBElement("CHEM131",98287,4,"SC361","Valerie Pierce");
		CourseDBElement cde1=new CourseDBElement("CMSC141",45608,1,"Distance-Learning","Ping.We Tsai");
		manager.add("CHEM131",98287,4,"SC361","Valerie Pierce");
		manager.add("CMSC141",45608,1,"Distance-Learning","Ping.We Tsai");
		assertEquals(0,manager.get(98287).compareTo(cde));
		assertEquals(0,manager.get(45608).compareTo(cde1));
		
	}
}