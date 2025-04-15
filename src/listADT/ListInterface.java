package listADT;

public interface ListInterface<T> {
	
	void add(T newEntry);
	void add(int newPosition, T newEntry);
	T remove(int givenPosition);
	void clear();
	T replace(int givenPosition, T newEntry);
	T getEntry(int givenPosition);
	T[] toArray();
    boolean contains(T newEntry);
    int getLength();
    boolean isEmpty();

}
