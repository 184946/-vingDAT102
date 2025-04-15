package iteratorList;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class SeparateIterator<T> implements Iterator<T> {
	private ListInterface<T> list;
	private int nextPosition;
	private boolean wasNextCalled;
	
	public SeparateIterator(ListInterface<T> myList) {
		list = myList;
		nextPosition = 0;
		wasNextCalled = false;
	}
	
	public boolean hasNext() {
		return nextPosition < list.getLength();
	}
	
	public T next() {
		
		if (hasNext()) {
			wasNextCalled = true;
			nextPosition++;
			return list.getEntry(nextPosition);
		} else {
			throw new NoSuchElementException("You have reached the end of the list.");
		}
	}
	
	public void remove() {
		
		if (wasNextCalled) {
			list.remove(nextPosition);
			nextPosition--;
			wasNextCalled = false;
			
		} else {
			throw new IllegalStateException("Next() was not called");
		}
	}

}
