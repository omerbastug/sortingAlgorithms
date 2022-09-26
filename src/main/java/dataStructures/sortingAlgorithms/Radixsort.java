package dataStructures.sortingAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Radixsort {
	public Radixsort() {
		super();
	}
	HashMap<Integer, ArrayList<IPAddress>> bucket = new HashMap<Integer, ArrayList<IPAddress>>();

	@SuppressWarnings("unused")
	public ArrayList<IPAddress> sort (IPAddress[] array) {
		
		int size = array.length;
		
		int d = digitCounter(array);// maximum number of digits
		
		ArrayList<IPAddress> temp = new ArrayList<IPAddress>();
		
		for(int i=0;i<size;i++) {
			temp.add(array[i]);
		}
		
		for(int i=0; i<d; i++) { // iterate over each digit
			for(int j =0 ;j<temp.size();j++) { // iterate over every element
				long value= temp.get(j).getIp();
				int digit = getDigit(i, value);
				if(bucket.get(digit)==null) {
					bucket.put(digit, new ArrayList<IPAddress>());
				}
				bucket.get(digit).add(temp.get(j));  // add element into the corresponding bucket
			}
			
			// update temp array
			// transfer bucket to temp
			temp.clear(); 
			for (Entry<Integer, ArrayList<IPAddress>> entry : bucket.entrySet()) {//Append buckets into newArray
			    ArrayList<IPAddress> value = entry.getValue();
			    temp.addAll(value); // adds all elements of a list
			}
			bucket.clear();
		}
		return temp;
	}
	
	private int digitCounter(IPAddress[] array) {
		IPAddress max = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i].compareTo(max)==1) {
				max = array[i];
			}
		}
		return (int) Math.log10(max.ipfrom) + 1;
	}
	
	private int getDigit(int i, long value) {
		long remainder =  (long) (value % Math.pow(10, i+1));
		int digit = (int) (remainder / (int) Math.pow(10, i));
		return digit;
	}
}
