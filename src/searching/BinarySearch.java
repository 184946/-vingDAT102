package searching;

public class BinarySearch<T>{
	
	//BEST CASE = O(1)
	//AVERAGE CASE = O(log n)
	//WORST CASE = O(log n)
	
	
	public static <T extends Comparable<? super T>> boolean inArray(T[] anArray, T anEntry) {
		return binarySearch(anArray, 0, anArray.length - 1, anEntry);
	}
	
	
	private static <T extends Comparable<? super T>> boolean binarySearch(T[] anArray, int first, int last, T desiredItem) {
		boolean found;
		int mid = first + (last-first) / 2;
		
		if (first > last) {
			found = false;
		}
		
		else if (desiredItem.equals(anArray[mid])) {
			found = true;
		}
		
		else if (desiredItem.compareTo(anArray[mid]) < 0) {
			found = binarySearch(anArray, first, mid-1, desiredItem);
		}
		
		else {
			found = binarySearch(anArray, mid + 1, last, desiredItem);
		}
		
		return found;
	}

}
