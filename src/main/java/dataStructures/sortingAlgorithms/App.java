package dataStructures.sortingAlgorithms;

import java.io.IOException;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws IOException {

    IPAddress[] arr = IPAddress.LoadFromFile(4000000, "c:\\IP-COUNTRY-REGION-CITY-SHUFFLED.csv");    
    Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    System.out.println(
    		"1. Heap sort \n"+
		    "2. Radix sort \n"+
		    "3. Quick sort \n"+
		    "4. Merge sort \n"+
		    "5. Shell sort \n"+
		    "6. Insertion sort \n"+
		    "7. Selection sort \n"+
		    "8. Bubble sort \n"+
		    "Enter index: ");

    int algorithm_index = scanner.nextInt();  // Read user input
    scanner.close();
    IPAddress.Sort_and_Write_into(arr, algorithm_index, "C:\\DS&A\\sortedIPaddresses.csv");
    boolean sorted = true;
    int faultyindex = -1;
    for(int i = 0;i <arr.length-1;i++) {
    	if(arr[i].compareTo(arr[i+1])==1) {
    		sorted = false;
    		faultyindex = i;
    		break;
    	}
    }
    System.out.println("Sorted : "+sorted + "\nFaulty index : " + faultyindex);
    
    System.out.println(IPAddress.binarySeach(arr, "188.58.33.04"));
  }
}
