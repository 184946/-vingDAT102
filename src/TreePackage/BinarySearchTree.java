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
	
	@Override
	public void setTree(T rootData) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		throw new UnsupportedOperationException();
	}
	
	public boolean contains(T entry) {
		return getEntry(entry) != null;
	}
	
	public T getEntry(T entry) {
		return findEntry(getRootNode(), entry);
		
	}
	
	private T findEntry(BinaryNode<T> rootNode, T entry) {
		T result = null;
		if (rootNode != null) {
			T rootEntry = rootNode.getData();
			if (entry.equals(rootEntry)) {
				result = rootEntry;
			} else if (entry.compareTo(rootEntry) < 0) {
				result = findEntry(rootNode.getLeftChild(), entry);
			} else {
				result = findEntry(rootNode.getRightChild(), entry);
			}
			
		}
		return result;
	}
	
	
	
	public T add(T newEntry) {
		T result = null;
		if (isEmpty()) {
			setRootNode(new BinaryNode<>(newEntry));
		} else {
			result = addEntry(getRootNode(), newEntry);
		} return result;
	}
	
	private T addEntry(BinaryNode<T> rootNode, T newEntry) {
		assert rootNode != null;
		T result = null;
		int comparison = newEntry.compareTo(rootNode.getData());
		
		if (comparison == 0) {
			result = rootNode.getData();
			rootNode.setData(newEntry);
		}
		
		else if (comparison < 0) {
			if (rootNode.hasLeftChild()) {
				result = addEntry(rootNode.getLeftChild(), newEntry);
			} else {
				rootNode.setLeftChild(new BinaryNode<>(newEntry));
			}
		}
		else {
			assert comparison > 0;
			if(rootNode.hasRightChild()) {
				result = addEntry(rootNode.getRightChild(), newEntry);
			} else {
				rootNode.setRightChild(new BinaryNode<>(newEntry));
			}
		}
		return result;
	}
	
	
	
	public T remove(T entry) {
		
	}
	
	public Iterator<T> getInorderIterator() {
		
	}

}
