package searching;

public class SimpelSearchingSortedChainNode<T extends Comparable<? super T>>{
	
	Node firstNode;
	int antallElementer;
	
	
	public SimpelSearchingSortedChainNode() {
		this.firstNode = null;
		this.antallElementer = 0;
	}
	
	public boolean contains(T anEntry) {
		Node currentNode = firstNode;
		
		while ((currentNode != null) && (anEntry.compareTo(currentNode.getData()) > 0)) {
			currentNode = currentNode.getNext();
		}
		
		return (currentNode != null) && anEntry.equals(currentNode.getData());
	}
	
	
	
	
	
	
	
	
	private class Node{
		T data;
		Node next;
		
		public Node() {
			this.data = null;
			this.next = null;
		}
		
		public Node(T data) {
			this.data = data;
			this.next = null;
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

		public void setNext(Node next) {
			this.next = next;
		}
		
		
	}

}
