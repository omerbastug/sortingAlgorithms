package dataStructures.sortingAlgorithms;

public class BubbleSort {
	static boolean swapped = false;
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {                 
            for (int j = 1; j < array.length-i; j++) {         
                if (array[j - 1].compareTo(array[j]) == 1) {
                    Comparable tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
            swapped = false;
        }
    }
}
