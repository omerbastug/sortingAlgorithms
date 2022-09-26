package dataStructures.sortingAlgorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IPAddress implements Comparable<IPAddress> {
	long ipfrom;
	long ipTo;
	String countryCode;
	String countryName;
	String regionName;
	String cityName;
	
	public IPAddress(String ip) {
		super();
		String[] arr = ip.split("\",\"");
		this.ipfrom = Long.parseLong(arr[0].replace("\"", ""));
		this.ipTo = Long.parseLong(arr[1]);
		this.countryCode = arr[2];
		this.countryName = arr[3];
		this.regionName = arr[4];
		this.cityName = arr[5].replace("\"", "");
	}
	
	
	@Override
	public String toString() {
		return "\"" + this.ipfrom + "\",\"" + this.ipTo + "\",\"" + this.countryCode +"\",\"" + this.countryName + "\",\""
				+ this.regionName + "\",\"" + this.cityName + "\"\n";
	}


	@Override
	public int compareTo(IPAddress o) {
		if (this.ipfrom > o.ipfrom) {
			return 1;
		} else if(this.ipfrom < o.ipfrom) {
			return -1;
		} else {
			return 0;
		}
	}
	public String geo() {
		return this.countryCode + ", " + this.countryName + ", " + this.regionName + ", " + this.cityName;
	}
	
	public static IPAddress[] LoadFromFile(int i,String path) throws IOException {
		IPAddress[] addresses = new IPAddress[i];
		BufferedReader br = new BufferedReader(new FileReader(path));  
		String line = "";
		int j = 0;
		while((line = br.readLine()) != null) {
			addresses[j] = new IPAddress(line);
			//System.out.println(addresses[j]);
			if(j == addresses.length - 1) {
				break;
			}
			j++;
		}
		br.close();
		return addresses;
	}
	
	public static void Sort_and_Write_into(IPAddress[] addresses,int alg,String path) throws IOException {
		
		switch(alg) {
			case 1: 
				HeapSort.sort(addresses);
				break;
			case 2:
				Radixsort rad = new Radixsort();
				ArrayList<IPAddress> sorted = rad.sort(addresses);;
				File file = new File(path);
				FileWriter fw = new FileWriter(file);
				for(int i = 0; i < sorted.size() ; i++) {
					addresses[i] = sorted.get(i);
					fw.write(sorted.get(i).toString());
				}
				fw.close();
				return;
			case 3:
				QuickSort.sort(addresses);
				break;
			case 4:
				Mergesort.sort(addresses);
				break;
			case 5:
				ShellSort.sort(addresses);
				break;
			case 6:
				InsertionSort.sort(addresses);
				break;
			case 7:
				SelectionSort.sort(addresses);
				break;
			case 8:
				BubbleSort.sort(addresses);
				break;
			default:
				System.out.println("Please enter a number between 1 and 8");
				Scanner scanner = new Scanner(System.in);
				int index = scanner.nextInt();
				scanner.close();
				IPAddress.Sort_and_Write_into(addresses,index,path);
				return;
		}		
		File file = new File(path);
		FileWriter fw = new FileWriter(file);
		for(int i = 0; i < addresses.length ; i++) {
			fw.write(addresses[i].toString());
		}
		fw.close();
	}
	
//	public static void RadixSort_and_Write(IPAddress[] addresses) throws IOException {
//		Radixsort rad = new Radixsort();
//		ArrayList<IPAddress> sorted = rad.sort(addresses);;
//		File file = new File("C:\\DSlab3\\newCSV.csv");
//		FileWriter fw = new FileWriter(file);
//		for(int i = 0; i < sorted.size() ; i++) {
//			fw.write(sorted.get(i).toString());
//		}
//		fw.close();
//	}
	public long getIp() {
		return this.ipfrom;
	}

}
