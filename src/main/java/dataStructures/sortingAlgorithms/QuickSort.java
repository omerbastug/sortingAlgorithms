package dataStructures.sortingAlgorithms;

public class QuickSort {
	
	
	@SuppressWarnings("rawtypes")
	public static final void swap (Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static int partition(Comparable[] arr, int bot, int top) {
		int i = bot; // 1 lower than needed to use pre-increment- ++i;
		int j = top + 1; // 1 higher than needed to use pre-decrement- --j;
		while(true) {
			while(arr[bot].compareTo(arr[++i]) == 1) {// find lower element to swap
				if(i == top) break;
			}
			while(arr[bot].compareTo(arr[--j]) == -1) {// find upper element to swap
				if(j == bot) break;
			}
			if(i>=j) break;
			swap(arr,i,j);
			
		}
		swap(arr,bot,j);
		return j;
	}
//	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] arr) {
		qsort(arr, 0, arr.length - 1);
	}
	@SuppressWarnings("rawtypes")
	private static void qsort(Comparable[] arr, int bot, int top) {
		if(top<=bot) return;
		int j = partition(arr,bot,top);
		qsort(arr,bot,j-1);
		qsort(arr,j+1,top);
	}
	
}
