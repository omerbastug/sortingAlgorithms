package dataStructures.sortingAlgorithms;

public class InsertionSort {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void sort(Comparable[] array) {
    	
    	for (int i = 0; i < array.length; i++) {
	        for (int j = i; j > 0; j--) {
	            if (array[j].compareTo(array[j-1]) == -1) {
	            	Comparable tmp = array[j];
	            	array[j] = array[j-1];
	            	array[j-1] = tmp;
	            }
	        }
	    }
    }
    
}
