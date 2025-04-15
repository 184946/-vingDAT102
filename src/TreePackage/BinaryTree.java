package TreePackage;

import java.util.Iterator;
import java.util.Stack;


public class BinaryTree<T> implements BinaryTreeInterface<T> {
	
	private BinaryNode<T> root;
	
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(T rootData) {
		root = new BinaryNode<>(rootData);
	}
	
	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		privateSetTree(rootData, leftTree, rightTree);
	}
	
	public void setTree(T rootData) {
		root = new BinaryNode<>(rootData);
	}
	
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		privateSetTree(rootData, (BinaryTree<T>)leftTree, (BinaryTree<T>)rightTree);
	}
	
	private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		root = new BinaryNode<>(rootData);
		
		if((leftTree != null) && !leftTree.isEmpty()) {
			root.setLeftChild(leftTree.root.copy());
		}
		
		if ((rightTree != null) && !rightTree.isEmpty()) {
			root.setRightChild(rightTree.root.copy());
		}
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public T getRootData() {
		if (isEmpty()){
			throw new EmptyTreeException();
		}
		else {
			return root.getData();
		}
	}
	
	public void clear() {
		root = null;
	}
	
	protected void setRootData(T rootData) {
		root.setData(rootData);
	}
	
	protected void setRootNode(BinaryNode<T> rootNode) {
		root = rootNode;
	}
	
	protected BinaryNode<T> getRootNode(){
		return root;
	}
	
	public int getHeight() {
		return root.getHeight();
	}
	
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}
	
	public void inorderTraverse() {
		inorderTraverse(root);
	}
	
	private void inorderTraverse(BinaryNode<T> node) {
		if (node != null) {
			inorderTraverse(node.getLeftChild());
			System.out.println(node.getData());
			inorderTraverse(node.getRightChild());
		}
	}
	
	public Iterator<T> getInorderIterator(){
		return new InorderIterator();
	}
	
	public void iterativeInorderTraverse() {
		StackInterface<BinaryNodeInterface<T>> nodeStack = new LinkedStack<>();
		BinaryNode<T> currentNode = root;
		
		while (!nodeStack.isEmpty() || (currentNode != null)) {
			
			while (currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}
			
			if (!nodeStack.isEmpty()) {
				BinaryNode<T> nextNode = nodeStack.pop();
				assert nextNode != null;
				
				System.out.println(nextNode.getData());
				currentNode = nextNode.getRightChild();
			}
		}
	}
	
	
	private class InorderIterator implements Iterator<T>{
		
		private StackInterface<BinaryNode<T>> nodeStack;
		private BinaryNode<T> currentNode;
		
		public InorderIterator() {
			nodeStack = new LinkedStack<>();
			currentNode = root;
		}
		
		public boolean hasNext() {
			return !nodeStack.isEmpty() || (currentNode != null);
		}
		
		public T next() {
			BinaryNode<T> nextNode = null;
			
			while (currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}
			
			if (!nodeStack.isEmpty()) {
				nextNode = nodeStack.pop();
				assert nextNode != null;
				
				currentNode = nextNode.getRightChild();
			}
			else {
				
				throw new NoSuchElementException();
			}
			
			return nextNode.getData();
		}
		
		public void remove() {
			throw new UnsupportedOperation();
		}
		
		
	}
	

}
