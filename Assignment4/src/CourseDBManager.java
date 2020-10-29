import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Course Database Manager class
 * @author steum
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {
	CourseDBStructure cds=new CourseDBStructure(20);

	/**
	 * creates a CDE object and adds it to the hash table CDS
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement cde=new CourseDBElement(id,crn,credits,roomNum,instructor);
		cds.add(cde);
		
	}
	/**
	 * uses the CDS get method to return course with the passed crn
	 * @return course with the passed crn
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return cds.get(crn);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	/**
	 * reads courses information from a file
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner in=new Scanner(input);
		int cred,crn;
		CourseDBElement cde;
		String courses;
		String[] course;
		while (in.hasNextLine()) {
			courses=in.nextLine();
			course=courses.split(" ",5);
			crn=Integer.parseInt(course[1]);
			cred=Integer.parseInt(course[2]);
			cde=new CourseDBElement(course[0],crn,cred,course[3],course[4]);
			cds.add(cde);
		}
		
	}
	/**
	 * uses the CDS showAll method to print all courses in the database
	 */
	@Override
	public ArrayList<String> showAll() {
		return cds.showAll();
	}
	
}
