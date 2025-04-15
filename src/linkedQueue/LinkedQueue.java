package linkedQueue;

public final class LinkedQueue<T> implements QueueInterface<T> {
	
	private class Node{
		
		private T data;
		private Node next;
		
		public Node() {
			data = null;
			next = null;
		}
		
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		public T getData() {
			return data;
		}
		
		public void setData(T data) {
			this.data = data;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node node) {
			this.next = node;
		}
	}
	
	
	
	
	
	
	private Node firstNode;
	private Node lastNode;
	
	private LinkedQueue() {
		firstNode = null;
		lastNode = null;
	}
	
	public void enqueue(T newEntry) {
		
		Node nyNode = new Node(newEntry, null);
		if (isEmpty()) {
			firstNode = nyNode;
		} else {
			lastNode.setNext(nyNode);
		}
		
		lastNode = nyNode;
	}	
	
	
	public T dequeue() {
		
		T front = getFront();
		assert firstNode != null;
		
		firstNode.setData(null);
		firstNode = firstNode.getNext();
		
		if (firstNode == null) {
			lastNode = null;
		}
		
		return front;
		
	}
	
	public T getFront() {
		
		if (isEmpty()) {
		   throw new EmptyQueueException();
		} else {
			return firstNode.getData();
		}
		

		
	}
	
	public boolean isEmpty() {
		
		return firstNode == null;
	}
	
	public void clear() {
		
		firstNode = null;
		lastNode = null;
	}
	

}
