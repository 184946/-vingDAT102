package TreePackage;

import java.util.Arrays;

public class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T> {
	private T[] heap;
	private int lastIndex;
	private boolean initialized;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	public MaxHeap() {
		this(DEFAULT_CAPACITY);
	}
	
	public MaxHeap(int size) {
		
		if (size < DEFAULT_CAPACITY) {
			size = DEFAULT_CAPACITY;
		}
		else {
			checkCapacity(size);
		}
		@SuppressWarnings("unchecked")
		T[] tempHeap = (T[]) new Comparable[size+1];
		heap = tempHeap;
		lastIndex = 0;
		initialized = true;
	}
	
	public void add(T newEntry) {
		checkInitialization();
		int newIndex = lastIndex + 1;
		int parentIndex = newIndex / 2;
		while ((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0) {
			heap[newIndex] = heap[parentIndex];
			newIndex = parentIndex;
			parentIndex = newIndex / 2;
		}
		heap[newIndex] = newEntry;
		lastIndex++;
		ensureCapacity();
		
	}
	
	public T removeMax() {
		checkInitialization();
		T root = null;
		
		if(!isEmpty()) {
			root = heap[1];
			heap[1] = heap[lastIndex];
			lastIndex--;
			reheap(1);
		}
		return root;
	}
	
	private static <T extends Comparable<? super T>> void reheap(T[] heap, int rootIndex, int lastIndex) {
		boolean done = false;
		T orphan = heap[rootIndex];
		int leftChildIndex = 2 * rootIndex + 1;
		
		while(!done && (leftChildIndex <= lastIndex)) {
			int largerChildIndex = leftChildIndex;
			int rightChildIndex = leftChildIndex + 1;
			
			if ((rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex])>0){
				largerChildIndex = rightChildIndex;
			}
			
			if (orphan.compareTo(heap[largerChildIndex]) < 0) {
				heap[rootIndex] = heap[largerChildIndex];
				rootIndex = largerChildIndex;
				leftChildIndex = 2*rootIndex + 1;
			} else {
				done = true;
			}
			heap[rootIndex] = orphan;
		}
	}
	
	public static <T extends Comparable<? super T>> void heapSort(T[] array, int n) {
		for (int rootIndex = n/2 - 1; rootIndex >= 0; rootIndex--) {
			reheap(array,rootIndex,n-1);
		}
		swap(array, 0, n-1);
		for (int lastIndex = n-2; lastIndex > 0; lastIndex--) {
			reheap(array, 0, lastIndex);
			swap(array, 0, lastIndex);
		}
	}
	
	public static <T extends Comparable<? super T>> void swap(T[] array, int swapIndex1, int swapIndex2) {
		T tempVariabel = array[swapIndex1];
		array[swapIndex1] = array[swapIndex2];
		array[swapIndex2] = tempVariabel;
	}
	
	public T getMax() {
		checkInitialization();
		T root = null;
		if (!isEmpty()) {
			root = heap[1];
		}
		return root;
		
	}
	
	public boolean isEmpty() {
		return lastIndex < 1;
	
	}
	
	public int getSize() {
		
		return lastIndex;
		}
		
	
	public void clear() {
		checkInitialization();
		while (lastIndex > -1) {
			heap[lastIndex] = null;
			lastIndex--;
		}
		lastIndex = 0;
		
	}
	
	public void checkCapacity(int size) {

	}
	
	private void checkInitialization() {
		if (initialized == false) {
			throw new IllegalStateException("Heap er ikkje implementert");
		}
	}

}
