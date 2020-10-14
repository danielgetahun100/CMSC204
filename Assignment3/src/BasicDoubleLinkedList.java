import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *  BasicDoubleLinkedList class
 * @author steum
 *
 * @param <T> type arameter
 */
public class BasicDoubleLinkedList<T> {
	protected Link firstLink;
	protected Link lastLink;
	protected int sizeOfList=0;
	
	/**
	 * default constructor sets firstLink and lastLink to null
	 */
	public BasicDoubleLinkedList() {
		firstLink=null;
		lastLink=null;
		
	}
	
	/**
	 * returns the number of elements in the list
	 * @return sizeOfList
	 */
	public int getSize() {
		return sizeOfList;
	}
	
	/**
	 * checks if the list is empty
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		if(sizeOfList==0) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * adds an element to the back the list 
	 * @param data for the node to add to the list
	 * @return reference to current object
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data){
		Link tempLink=new Link(data);
		BasicDoubleLinkedList<T> list=list=new BasicDoubleLinkedList<T>();
		if(isEmpty()) {
			firstLink=tempLink;	
		}
		else {
			lastLink.next=tempLink;
			tempLink.previous=lastLink;	
		}
		lastLink=tempLink;
		sizeOfList++;
		return this;
	}
	
	/**
	 * adds an element to the front of the list
	 * @param data for the node to add to the list
	 * @return reference to current object
	 */
	public BasicDoubleLinkedList<T> addToFront(T data){
		Link tempLink=new Link(data);
		BasicDoubleLinkedList<T> list=list=new BasicDoubleLinkedList<T>();
		if(isEmpty()) {
			lastLink=tempLink;
		}
		else {
			tempLink.next=firstLink;
			firstLink.previous=tempLink;	
		}
		firstLink=tempLink;
		sizeOfList++;
		return this;
	}
	
	/**
	 * returns the first element of the list
	 * @return data or null
	 */
	public T getFirst() {
		if(isEmpty()) {
			return null;
		}
		else {
			return firstLink.data;
		}

	}
	
	/**
	 * returns the last element of the list
	 * @return data or null
	 */
	public T getLast() {
		if(isEmpty()) {
			return null;
		}
		else {
			return lastLink.data;
		}
	}
	
	/**
	 * removes the first instance of targetData in the list
	 * @param targetData data element to be removed
	 * @param comparator comparator to determine equality of data elements
	 * @return data element or null
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T>comparator){
		Link current=firstLink;
		Link previous=null;
		Link foundLink=null;
		BasicDoubleLinkedList<T>list1=new BasicDoubleLinkedList<T>();
		//boolean found=false;
		while(!isEmpty()) {
			
			if(comparator.compare(targetData,current.data)==0) {
				if(sizeOfList==1) {
					foundLink=firstLink;
					firstLink=null;
					lastLink=null;
					sizeOfList--;
					break;
				}
				else if(current==firstLink) {
					foundLink=current;
					firstLink.next.previous=null;
					firstLink=firstLink.next;
					sizeOfList--;
					break;
				}
				else if(current==lastLink){
					foundLink=current;
					lastLink.previous.next=null;
					lastLink=lastLink.previous;
					sizeOfList--;
					break;
				}
				else {
					foundLink=current;
					current.previous.next=current.next;
					current.next.previous=current.previous;
					sizeOfList--;
					break;
				}
			}
			previous=current;
			current=current.next;
		}

		return this;
	}
	
	/**
	 * removes and returns the first element of the list
	 * @return first data element or null
	 */
	public T retrieveFirstElement() {
		if(isEmpty()) {
			return null;
		}
		else if(sizeOfList==1) {
			T first=getFirst();
			firstLink=null;
			lastLink=null;
			sizeOfList--;
			return first;
		}
		else {
			T first=getFirst();
			firstLink.next.previous=null;
			firstLink=firstLink.next;
			sizeOfList--;
			return first;
		}	
		
	}
	/**
	 * removes and returns last element of the list
	 * @return last data element or null
	 */
	public T retrieveLastElement() {
		if(isEmpty()) {
			return null;
		}
		else if(sizeOfList==1) {
			T last=getLast();
			firstLink=null;
			lastLink=null;
			sizeOfList--;
			return last;
		}
		else {
			T last=getLast();
			lastLink.previous.next=null;
			lastLink=lastLink.previous;
			sizeOfList--;
			return last;
		}
	}
	
	/**
	 * Returns an arraylist of the items in the list from head of list to tail of list
	 * @return an arraylist of the items in the list
	 */
	public ArrayList<T> toArrayList(){
		ArrayList<T> list=new ArrayList<T>();
		ListIterator<T> it=iterator();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	/**
	 * creates a new iterator object and returns it
	 * @return iterator object
	 * @throws UnsupportedOperationException when a wrong method is called
	 * @throws NoSuchElementException when no element is found
	 */
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException{
		return new DoubleLinkedListIterator();
	}
	
	/**
	 * Link class
	 * @author steum
	 *
	 */
	protected class Link{
		public Link previous;
		public Link next;
		public T data;
		
		/**
		 * default constructor sets previous, next and data to null
		 */
		Link(){
			previous=null;
			next=null;
			data=null;
		}
		/**
		 * constructor to assign value to data
		 * @param data new data element to assign
		 */
		Link(T data){
			this.data=data;
		}
	}
	
	/**
	 * DoubleLinkedListIterator class
	 * @author steum
	 *
	 */
	protected class DoubleLinkedListIterator implements ListIterator<T> {
		private Link previousLink;
		private Link currentLink;
		
		/**
		 * default constructor to assign previousLink and currentLink beginning values 
		 */
		DoubleLinkedListIterator(){
			previousLink=null;
			currentLink=firstLink;
		}
		@Override
		/**
		 * operation invalid in iterator
		 * @throws  UnsupportedOperationException when called
		 */
		public void add(T arg0) {
			throw new UnsupportedOperationException();
			
		}

		@Override
		/**
		 * checks if current node is null or not
		 * @return true if not null, false otherwise
		 */
		public boolean hasNext() {
			
			return currentLink!=null;
		}
		
		/**
		 * checks if previous node is null or not
		 * @return true if not null, false otherwise
		 */
		@Override
		public boolean hasPrevious() {
			return previousLink!=null;
		}
		
		/**
		 * @return next data element
		 */
		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
				
			}
			else {
				previousLink=currentLink;
				currentLink=currentLink.next;
				return previousLink.data;
			}
		}
		
		/**
		 *  @return next data element
		 */
		@Override
		public T previous() {
			if(!hasPrevious()) {
				throw new NoSuchElementException();
				
			}
			else {
				currentLink=previousLink;
				previousLink=previousLink.previous;
				return currentLink.data;
			}

		}
		
		/**
		 * operation invalid in iterator
		 * @throws  UnsupportedOperationException when called
		 */
		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		/**
		 * operation invalid in iterator
		 * @throws  UnsupportedOperationException when called
		 */
		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}
		
		/**
		 * operation invalid in iterator
		 * @throws  UnsupportedOperationException when called
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}

		/**
		 * operation invalid in iterator
		 * @throws  UnsupportedOperationException when called
		 */
		@Override
		public void set(T e) {
			throw new UnsupportedOperationException();
			
		}
		
	}

}
