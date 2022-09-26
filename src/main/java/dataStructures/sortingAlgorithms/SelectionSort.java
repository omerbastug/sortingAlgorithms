package dataStructures.sortingAlgorithms;

public class SelectionSort {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void sort(Comparable[] array) {
    	
        for (int i = 0; i < array.length; i++) {
        	Comparable min = array[i];
        	int tmpindex = i;
        	
            for (int j = i+1; j < array.length; j++) {
                if (array[j].compareTo(min) == -1) {
                    min = array[j];
                    tmpindex = j;
                } 
            }
            
            Comparable tmp = array[i];
            array[i] = min;
            array[tmpindex] = tmp;
        }
        
    }
    
}
