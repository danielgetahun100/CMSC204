import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * data structure class that is used with the Course Database Manager class.
 * This is a hash table with buckets
 * @author steum
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface{
	
	protected int sizeOfHash=0;
	protected int elementSize=0;
	protected LinkedList [] hashTable;
	
	/**
	 * constructor taking an integer representing size of hash table
	 * @param size integer representing size of hash table
	 */
	public CourseDBStructure(int size) {
		sizeOfHash=size;
		hashTable=new LinkedList[sizeOfHash];
	}
	
	/**
	 * constructor used for testing
	 * @param testing testing string
	 * @param size size of hash Table
	 */
	public CourseDBStructure(String testing,int size) {
		sizeOfHash=size;
		hashTable=new LinkedList[sizeOfHash];
	}
	
	/**
	* Use the hashcode of the CourseDatabaseElement to see if it is 
	* in the hashtable. If the CourseDatabaseElement does not exist in the hashtable,
	* add it to the hashtable.
	* 
	* @param element the CDE to be added 
	 */
	@Override
	public void add(CourseDBElement element) {

		int code;
		code=Math.abs(element.hashCode())% sizeOfHash;
		LinkedList <CourseDBElement>current=hashTable[code];
		if(current==null) {
			hashTable[code]=new LinkedList<CourseDBElement>();
			
		}
		hashTable[code].add(element);
		elementSize++;
	}
	
	/**
	 * Use the hashcode of the CourseDatabaseElement to see if it is 
	 * in the hashtable. If the CourseDatabaseElement is in the hashtable, return it
	 * If not, throw an IOException
	 * @return  course with the passed crn
	 * @throws IOException thrown when course not found
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		String crn1=Integer.toString(crn);
		int code=Math.abs(crn1.hashCode())% sizeOfHash;
		if(hashTable[code]==null) {
			throw new IOException();
		}
		else{
			return (CourseDBElement) hashTable[code].get(0);
		}

	}
	/**
	 * @return size of hashTable
	 */
	@Override
	public int getTableSize() {
		return sizeOfHash;
	}
	
	/**
	 * Prints all courses in the database in string format
	 * @return list of course strings
	 */
	public ArrayList<String> showAll() {
		ArrayList<String> courses=new ArrayList<String>();
		for(int i=0;i<sizeOfHash;i++) {
			while(hashTable[i]!=null) {
				for(int j=0;j<hashTable[i].size();j++) {
					CourseDBElement element= (CourseDBElement) hashTable[i].get(j);
					courses.add("\n"+element.toString());
				}
				break;
			}
		}
		return courses;
	}
}
