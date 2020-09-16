import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {
	GradeBook g1;
	GradeBook g2;

	@Before
	public void setUp() throws Exception {
		g1=new GradeBook(5);
		g2=new GradeBook(5);
		g1.addScore(50);
		g1.addScore(75);
		g1.addScore(40);
		g1.addScore(16);
		
		g2.addScore(15);
		g2.addScore(78);
		g2.addScore(100);
		g2.addScore(26);
		

	}

	@After
	public void tearDown() throws Exception {
		g1=null;
		g2=null;
	}

	@Test
	public void testAddScore() {
		assertTrue(g1.toString().equals("50.0 75.0 40.0 16.0 "));
		assertEquals(g1.getScoreSize(),4);
		
		assertTrue(g2.toString().equals("15.0 78.0 100.0 26.0 "));
		assertEquals(g2.getScoreSize(),4);
	}

	@Test
	public void testSum() {
		assertEquals(g1.sum(),181,0.0);
		assertEquals(g2.sum(),219,0.0);
	}

	@Test
	public void testMinimum() {
		assertEquals(g1.minimum(),16,0.0);
		assertEquals(g2.minimum(),15,0.0);
	}

	@Test
	public void testFinalScore() {
		assertEquals(g1.finalScore(),165,0.0);
		assertEquals(g2.finalScore(),204,0.0);
	}

}
