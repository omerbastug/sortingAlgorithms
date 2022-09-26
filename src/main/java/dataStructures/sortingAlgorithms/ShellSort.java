package dataStructures.sortingAlgorithms;

public class ShellSort {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort(Comparable[] arr) {
		int h = 1;
	    Comparable temp;

	    while(h <= arr.length/3){ 
	      h = (h * 3) + 1; 
	    }
	    
	    while(h > 0){  
	    	
	      for(int i = h; i < arr.length; i++){ 
	        temp = arr[i];
	        int j;
	        for(j = i; j > h - 1 && arr[j-h].compareTo(temp)==1; j-=h){
	          arr[j] = arr[j - h];                    
	        }
	        arr[j] = temp;
	      }
	      
	      h = (h - 1)/3;
	    }
	}
}
