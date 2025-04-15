package linkedList;

public final class LList<T> implements ListInterface<T> {
	
	private class Node {
		
		private T data;
		private Node next;
		
		public Node() {
			data = null;
			next = null;
		}
		
		public Node(T data) {
			this.data = data;
			next = null;
		}
		
		public T getData() {
			return this.data;
		}
		
		public void setData(T data) {
			this.data = data;
		}
		
		public Node getNextNode() {
			return this.next;
		}
		
		public void setNextNode(Node node) {
			this.next = node;
		}
	}
	
	
	

}
