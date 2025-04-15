package TreePackage;

public class BinaryNode<T> {
	
	private BinaryNode<T> leftChild;
	private BinaryNode<T> rightChild;
	private T data;
	
	public BinaryNode() {
		leftChild = null;
		rightChild = null;
		data = null;
	}
	
	public BinaryNode(T data) {
		
	    leftChild = null;
	    rightChild = null;
	    this.data = data;
	}
	
	public BinaryNode(BinaryNode<T> leftChild, BinaryNode<T> rightChild, T data) {
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.data = data;
	}

	public BinaryNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public boolean hasLeftChild() {
		return leftChild != null;
	}
	
	public boolean hasRightChild() {
		return rightChild != null;
	}
	
	public boolean isLeaf() {
		return (rightChild == null) && (leftChild == null);
	}
	
	public int getNumberOfNodes() {
		int leftNumber = 0;
		int rightNumber = 0;
		
		if (leftChild != null) {
			leftNumber = leftChild.getNumberOfNodes();
		}
		
		if (rightChild != null) {
			rightNumber = rightChild.getNumberOfNodes();
		}
		
		return 1 + rightNumber + leftNumber;
	}
	
	public int getHeight() {
		return getHeight(this);
	}
	
	
	
	private int getHeight(BinaryNode<T> node) {
		int height = 0;
		
		if (node != null) {
			height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
		}
		return height;
	}
	
	
	public BinaryNode<T> copy() {
		BinaryNode<T> newRoot = new BinaryNode<T>(data);
		if (leftChild != null) {
			newRoot.setLeftChild(leftChild.copy());
		}
		
		if (rightChild != null) {
			newRoot.setRightChild(rightChild.copy());
		}
		
		return newRoot;
	}
	
	
}
