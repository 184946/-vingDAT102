package arrayQueue;

public class ArrayQueue<T> implements QueueInterface<T> {
	
	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	
	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayQueue(int size) {
		
		checkCapacity(size);
		
		T[] tempQueue = (T[]) new Object[size+1];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = size;
		initialized = true;
	}
	
	
	public void enqueue(T newEntry) {
		checkInitialization();
		ensureCapacity();
		backIndex = (backIndex+1) % queue.length;
		queue[backIndex] = newEntry;
		
		
	}
	
	public T dequeue() {
		checkInitialization();
		if (isEmpty()) {
			throw new EmptyQueueException();
		} else {
			T front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			return front;
			
		}
	}
	
	public T getFront() {
		checkInitialization();
		if (isEmpty()) {
			throw new EmptyQueueException();
		} else {
			return queue[frontIndex];
		}
		
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public void clear() {
		
		for (int i = 0; i < size(); i++) {
			queue[i] = null;
		}
		
		frontIndex = 0;
		backIndex = queue.length - 1;
		
		
	}
	
	private void checkCapacity(int size) {
		if (size < 1 || size > MAX_CAPACITY) {
			throw new IllegalArgumentException("Kapasiteten må være mellom 1 og " + MAX_CAPACITY);
		}
	}
	
	private void checkInitialization() {
		if (!initialized) {
			throw new IllegalArgumentException("Tabellen er ikkje initialisert");
		}
	}
	
	private void ensureCapacity() {
		if ((backIndex + 1) % queue.length == frontIndex) {
			int nyKapasitet = queue.length*2;
			checkCapacity(nyKapasitet);
			
			T[] tempQueue = (T[]) new Object[nyKapasitet];
			int currentSize = size();
			for (int i = 0; i < currentSize; i++) {
				tempQueue[i] = queue[(frontIndex+i) % queue.length];
			}
			
			queue = tempQueue;
			frontIndex = 0;
			backIndex = currentSize - 1;
		}
	}
	
	private int size() {
		if (frontIndex <= backIndex) {
			return backIndex - frontIndex + 1;
		} else {
			return queue.length - frontIndex + backIndex + 1;
		}
	}
	
	
	

}
