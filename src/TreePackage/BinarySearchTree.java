package TreePackage;
import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> implements SearchTreeInterface<T> {
	
	public BinarySearchTree() {
		super();
	}
	
	public BinarySearchTree(T rootEntry) {
		super();
		setRootNode(new BinaryNode<T>(rootEntry));
	}
	
	public void setTree(T rootData) {
		throw new UnsupportedOperationException();
	}
	
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		throw new UnsupportedOperationException();
	}
	
	public boolean contains(T entry) {
		
	}
	
	public T getEntry(T entry) {
		
	}
	
	public T add(T newEntry) {
		
	}
	
	public T remove(T entry) {
		
	}
	
	public Iterator<T> getInorderIterator() {
		
	}

}
