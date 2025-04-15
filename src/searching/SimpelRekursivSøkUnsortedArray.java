package searching;

public class SimpelRekursivSøkUnsortedArray<T> {
	
	
	// BEST CASE = O(1)
	// AVERAGE CASE = O(n)
	// WORST CASE = O(n)
	
	public static <T> boolean inArray(T[] anArray, T anEntry) {
		
		return search(anArray, 0, anArray.length - 1, anEntry);
	}
	
	private static <T> boolean search(T[] anArray, int first, int last, T desiredItem) {
		boolean found;
		if (first > last) {
			found = false;
		}
		
		else if (desiredItem.equals(anArray[first])) {
			found = true;
		}
		
		else {
			found = search(anArray, first + 1, last, desiredItem);
		}
		
		return found;
	}

}
