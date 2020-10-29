import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * @author steum
 */
public class CourseDBStructureSTUDENT_Test {
	CourseDBStructure structure, testStructure;

	@Before
	public void setUp() throws Exception {
		structure = new CourseDBStructure(20);
		testStructure = new CourseDBStructure("Testing", 20);
	}

	@After
	public void tearDown() throws Exception {
		structure = testStructure = null;
	}
	
	/**
	 * Test the tableSize for CourseDBStructures constructed
	 * with both constructors
	 */
	@Test
	public void testGetTableSize()
	{
		assertEquals(20, structure.getTableSize());
		assertEquals(20, testStructure.getTableSize());		
	}
	
	/**
	 * Test the hashTable for CourseDBStructures constructed
	 * with both constructors
	 */
	@Test
	public void testHashTable()
	{
		assertEquals(20, structure.hashTable.length);
		CourseDBElement cde = new CourseDBElement("SOCY100",56728,3,"HU120","Emerald Jones"); 
		structure.add(cde);
		LinkedList<CourseDBElement> list = structure.hashTable[cde.hashCode()%structure.getTableSize()];
		assertEquals(56728, list.get(0).getCRN());
		
		testStructure = new CourseDBStructure("Testing",20);
		assertEquals(20, testStructure.hashTable.length);	
		testStructure.add(cde);
		list = testStructure.hashTable[cde.hashCode()%20];
		assertEquals(56728, list.get(0).getCRN());
	}
	
	@Test
	public void testGet()  {
		CourseDBElement cde = new CourseDBElement("SOCY100",56728,3,"HU120","Emerald Jones"); 
		structure.add(cde);
		try {
			structure.get(56728);
			assertEquals(cde,structure.get(56728));
		}
		catch(IOException e) {
			assertTrue("Threw error",false);
		}
	}
} 