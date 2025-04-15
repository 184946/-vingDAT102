package listADT;

import java.util.Arrays;

public class AList<T> implements ListInterface<T> {

	private T[] tabell;
	private int numberOfEntries;
	private static final int STANDARD_CAPACITY = 25;
	private static final int MAXIMUM_CAPACITY = 10000;
	private boolean initialized = false;

	public AList() {
		this(STANDARD_CAPACITY);
	}

	public AList(int size) {
		T[] tempTabell = (T[]) new Object[size];
		tabell = tempTabell;
		numberOfEntries = 0;
		initialized = true;
	}

	public void add(T newEntry) {

		checkInitialized();
		tabell[numberOfEntries + 1] = newEntry;
		numberOfEntries++;
		ensureCapacity();
	}

	public void add(int newPosition, T newEntry) {

		checkInitialized();

		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {

			for (int i = numberOfEntries; i >= newPosition; i--) {
				tabell[i + 1] = tabell[i];
			}

			tabell[newPosition] = newEntry;
			numberOfEntries++;
			ensureCapacity();

		} else {
			throw new IndexOutOfBoundsException("Posisjon må være mellom 1-" + numberOfEntries + 1);
		}

	}

	public T remove(int givenPosition) {
		checkInitialized();

		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1)) {

			assert !isEmpty();

			T removedValue = tabell[givenPosition];
			tabell[givenPosition] = null;

			for (int i = givenPosition; i < numberOfEntries; i++) {
				tabell[i] = tabell[i + 1];
			}

			numberOfEntries--;

			return removedValue;
		} else {
			throw new IndexOutOfBoundsException("Posisjonen må være mellom 1-" + numberOfEntries);
		}

	}

	public void clear() {
		checkInitialized();
		for (int i = 1; i < numberOfEntries; i++) {
			tabell[i] = null;
		}

		numberOfEntries = 0;
	}

	public T replace(int givenPosition, T newEntry) {
		checkInitialized();

		for (int i = numberOfEntries; i >= givenPosition; i--) {
			tabell[i + 1] = tabell[i];
		}

		T replacedValue = tabell[givenPosition];

		add(givenPosition, newEntry);

		return replacedValue;
	}

	public T getEntry(int givenPosition) {
		checkInitialized();

		if (numberOfEntries < givenPosition || givenPosition < 1) {
			throw new IllegalStateException("Feil posisjon");
		} else {
			return tabell[givenPosition];
		}

	}

	public T[] toArray() {
		checkInitialized();

		T[] tempTabell = (T[]) new Object[numberOfEntries];

		for (int i = 1; i <= numberOfEntries; i++) {
			tempTabell[i - 1] = tabell[i];
		}

		T[] returnTabell = tempTabell;
		return returnTabell;

	}

	public boolean contains(T anEntry) {
		checkInitialized();

		for (int i = 1; i < numberOfEntries; i++) {
			if (tabell[i].equals(anEntry)) {
				return true;
			}
		}
		return false;

	}

	public int getLength() {
		checkInitialized();
		return tabell.length - 1;
	}

	public boolean isEmpty() {
		checkInitialized();
		return numberOfEntries == 0;
	}

	public void checkCapacity(int size) {
		if (size > MAXIMUM_CAPACITY) {
			throw new IllegalStateException("Størrelsen på tabellen kan ikkje overstige " + MAXIMUM_CAPACITY
					+ " . Størrelsen må ligge mellom 1-10000");
		}
	}

	public void checkInitialized() {
		if (!initialized) {
			throw new IllegalStateException("Tabellen er ikkje opprettet");
		}
	}

	public void ensureCapacity() {

		checkCapacity(numberOfEntries + 1);

		if (numberOfEntries + 1 > tabell.length) {
			checkCapacity((tabell.length - 1) * 2);

			tabell = Arrays.copyOf(tabell, (tabell.length - 1) * 2);
		}
	}

	public String toString() {

		if (numberOfEntries == 0) {
			return "[]";
		}

		String str = "[";
		for (int i = 1; i < numberOfEntries + 1; i++) {
			str += tabell[i] + ", ";

			if (i == numberOfEntries - 1) {
				str += tabell[i + 1] + "]";
				break;
			}
		}

		return str;
	}

}
