import java.util.Comparator;
import java.util.ListIterator;
/**
 * SortedDoubleLinkedList class
 * @author steum
 *
 * @param <T> type parameter
 */
public class SortedDoubleLinkedList <T> extends BasicDoubleLinkedList<T>{
	
	private Comparator comp;
	/**
	 * Creates an empty list that is associated with the specified comparator.
	 * @param comparator2 Comparator to compare data elements
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator2) {
		comp=comparator2;
	}
	
	/**
	 * inserts specified element at correct position
	 * @param data data to be added to the list
	 * @return a reference to the current object
	 */
	public SortedDoubleLinkedList<T> add(T data){
 		Link tempLink=new Link(data);
		Link current=firstLink;
		Link previous;
		if(sizeOfList==0) {
			firstLink=tempLink;
			lastLink=tempLink;
			sizeOfList++;
			return this;
		}
		if(sizeOfList==1) {
			if(comp.compare(data,current.data)<0||comp.compare(data,current.data)==0){
				super.addToFront(data);
				return this;
			}
			else {
				super.addToEnd(data);
				return this;
			}
		}
		else {
			while(comp.compare(current.data,data)<0) {
				previous=current;
				current=current.next;
				if(current==null) {
					current=tempLink;
					tempLink.previous=previous;
					previous.next=tempLink;
					lastLink=tempLink;
					sizeOfList++;
					return this;
				}
			}
			if(current==firstLink) {
				if(comp.compare(data,current.data)<0) {
					super.addToFront(data);
					//return this;
				}
			}
			else if(current==lastLink) {
				current.previous.next=tempLink;
				tempLink.next=current;
				tempLink.previous=current.previous;
				current.previous=tempLink;
				sizeOfList++;
				//return this;
			}
			else {
				current.previous.next=tempLink;
				tempLink.next=current;
				tempLink.previous=current.previous;
				current.previous=tempLink;
				sizeOfList++;
				//return this;
			}
		return this;
		}


		
	}
	@Override
	/**
	 * Operation invalid for sorted list
	 * @Override addToEnd in class BasicDoubleLinkedList<T>
	 * @data data for the Node within the linked list
	 * @returns reference to current object
	 * @throws UnsupportedOperationException if method is called
	 */
	public SortedDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	@Override
	/**
	 * Operation invalid for sorted list
	 * @Override addToFront in class BasicDoubleLinkedList<T>
	 * @data data for the Node within the linked list
	 * @returns reference to current object
	 * @throws UnsupportedOperationException if method is called
	 */
	public SortedDoubleLinkedList<T> addToFront(T data){
		throw new UnsupportedOperationException();
	}
	@Override
	/**
	 * Implements the iterator by calling the super class iterator method.
	 * @Overrides iterator in class BasicDoubleLinkedList<T>
	 * @returns an iterator positioned at the head of the list
	 */
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	@Override
	/**
	 * Implements the remove operation by calling the super class remove method.
	 * @Overrides remove in class BasicDoubleLinkedList<T>
	 * @targetData data element to be removed
	 * @comparator comparator to determine equality of data elements
	 * @returns data element or null
	 */
	public SortedDoubleLinkedList<T> remove(T targetData, Comparator<T>comparator){
		super.remove(targetData, comparator);
		return this;
	}
}
