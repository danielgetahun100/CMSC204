import java.util.ArrayList;
import java.util.Collections;
public class NotationStack<T> implements StackInterface<T> {
	
	private int sizeOfStack;
	private ArrayList<T>stack;
	int topStack=0;
	int items=0;
	
	public NotationStack(){
		sizeOfStack=5;
		stack=new ArrayList<T> (sizeOfStack);
		Collections.fill(stack, (T)"-1");
	}
	
	public NotationStack(int size) {
		sizeOfStack=size;
		stack=new ArrayList<T> (sizeOfStack);
		Collections.fill(stack, (T)"-1");
	}

	@Override
	public boolean isEmpty() {
		int count=0;
		for(int i=0;i<stack.size();i++) {
			if(stack.get(i)!="-1") {
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
		for(int i=0;i<stack.size();i++) {
			if(stack.get(i)!="-1") {
				count++;
			}
		}
		if (count==stack.size())
			return true;
		else 
			return false;
	}

	@Override
	public T pop() throws StackUnderflowException {
		T poppedElement=null;
		if(items==0) {
			throw new StackUnderflowException();
		}
		else {
			poppedElement=stack.get(items-1);
			stack.remove(items-1);
			items--;
			return poppedElement;
		}
	}

	@Override
	public T top() throws StackUnderflowException {
		if(items<0) {
			throw new StackUnderflowException();
		}
		else {
			return stack.get(items-1);
		}
	}

	@Override
	public int size() {
		return items;
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
		if(items>=sizeOfStack) {
			throw new StackOverflowException();
		}
		else {
			stack.add(e);
			items++;
			return true;
		}

	}
	
	@Override
	public String toString() {
		String stackString="";
		for(T i:stack ) {
			stackString+=i;
		}
		return stackString;
	}
	
	@Override
	public String toString(String delimiter) {
		String stackString="";
		for(T i:stack ) {
			stackString+=i+delimiter;
		}
		return stackString;
	}

	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> listCopy=new ArrayList<T>(list);
		stack.addAll(listCopy);
		
	}

}
