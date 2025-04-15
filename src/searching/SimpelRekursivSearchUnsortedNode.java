package searching;

public class SimpelRekursivSearchUnsortedNode<T> {
	
	Node firstNode;
	int antallElementer;
	
	
	public SimpelRekursivSearchUnsortedNode() {
		firstNode = null;
		antallElementer = 0;
	}
	
	//BEST CASE = O(1)
	//WORST CASE = O(n)
	//AVERAGE CASE = O(n)
	
	
	public boolean contains(T anEntry) {
		
		return search(firstNode, anEntry);
	}
	
	 private boolean search(Node currentNode, T desiredItem) {
		 
		 
		 boolean found;
		 if (currentNode == null) {
			 found = false;
		 }
		 
		 else if(desiredItem.equals(currentNode.getData())) {
			 found = true; 
		 }
		 
		 else {
			 found = search(currentNode.getNext(), desiredItem);
		 }
		 
		 return found;
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
