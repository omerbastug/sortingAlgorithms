package dataStructures.sortingAlgorithms;

public class HeapSort {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort(Comparable[] arr) {
		BinaryHeap heap = new BinaryHeap();
	   	for(int i = 0; i<arr.length; i++) {
	   		heap.insert(arr[i]);
	   	}
	   	for(int i = arr.length-1; i>=0; i--) {
	   		arr[i] = (IPAddress) heap.delMax();
	   	}
	}
}
