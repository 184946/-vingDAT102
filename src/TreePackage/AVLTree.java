package TreePackage;

public class AVLTree<T extends Comparable<? super T>> extends BinarySearchTree<T> implements SearchTreeInterface<T> {
	
	
	public AVLTree() {
		super();
	}
	
	public AVLTree(T rootEntry) {
		super(rootEntry);
	}

}
