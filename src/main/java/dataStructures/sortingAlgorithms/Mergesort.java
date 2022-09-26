package dataStructures.sortingAlgorithms;

public class Mergesort {
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] arr) {
		Comparable[] temp = new Comparable[arr.length];
		sort(arr, temp ,0 , arr.length-1);
	}
	
	@SuppressWarnings("rawtypes")
	private static void sort(Comparable[] arr, Comparable[] temp, int bot, int top) {
		if (top <= bot) return;
		int mid = (bot + top) / 2;
		sort(arr , temp , bot, mid);
		sort(arr, temp, mid+1, top);
		merge(arr, temp, bot, top);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void merge(Comparable[] arr, Comparable[] temp, int bot, int top) {
		int mid = (bot + top)/2;

		for(int k = bot; k <= top; k++) {
			temp[k] = arr[k];
		}
		
		int	i = bot;  // pointers
		int j = mid + 1;
		
		for(int k = bot; k<= top; k++) {
			if( i > mid ) arr[k] = temp[j++]; // copy top half 
			else if( j > top ) arr[k] = temp[i++];// copy bottom half
			else if(temp[j].compareTo(temp[i]) == -1) arr[k] = temp[j++]; // if top pointer smaller, 
																		// take/copy value and increment j
			else arr[k] = temp[i++];// else do it for bottom pointer
		}
		
	}
}











