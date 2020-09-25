import java.util.ArrayList;
import java.util.Collections;

public class NotationQueue<T> implements QueueInterface<T> {

	private int sizeOfQueue;
	private ArrayList<T>queue;
	int front, end,items=0;
	
	public NotationQueue(){
		sizeOfQueue=5;
		queue=new ArrayList<T> (sizeOfQueue);
		Collections.fill(queue, (T)"-1");
	}
	
	public NotationQueue(int size) {
		sizeOfQueue=size;
		queue=new ArrayList<T> (sizeOfQueue);
		Collections.fill(queue, (T)"-1");
	}
	@Override
	public boolean isEmpty() {
		int count=0;
		for(int i=0;i<queue.size();i++) {
			if(queue.get(i)!="-1") {
				count++;
			}
		}
		if (count==0)
			return false;
		else 
			return true;
	}

	@Override
	public boolean isFull() {
		int count=0;
		for(int i=0;i<queue.size();i++) {
			if(queue.get(i)!="-1") {
				count++;
			}
		}
		if (count==sizeOfQueue)
			return true;
		else 
			return false;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(items==0) {
			throw new QueueUnderflowException();
		}
		else {
			queue.set(front, null);
			front++;
			items--;
		}
		return queue.get(front);
	}

	@Override
	public int size() {
		return items;
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(items==sizeOfQueue) {
			throw new QueueOverflowException();
		}
		else {
			queue.add(end,e);
			end++;
			items++;
			return true;
		}
	}
	
	@Override
	public String toString() {
		String queueString="";
		for(T i:queue ) {
			queueString+=i;
		}
		return queueString;
	}
	@Override
	public String toString(String delimiter) {
		String queueString="";
		for(T i:queue ) {
			queueString+=i+delimiter;
		}
		return queueString;
	}

	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> queueCopy=new ArrayList<T>(list);
		queue.addAll(queueCopy);
		
	}

}
