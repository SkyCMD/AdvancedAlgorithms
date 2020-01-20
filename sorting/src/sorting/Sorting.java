package sorting;

import java.util.Arrays;

public class Sorting {

	public static void insertionSort(int [] arr) {
		for(int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			arr[j+1] = key;
			}
		}
	}
	
	public static void reversedInsertionSort(int [] arr) {
		for(int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] < key) {
				arr[j+1] = arr[j];
				j--;
			arr[j+1] = key;
			}
		}
	}
	
	public static void sumBinary(int [] arr) {
		
	}
	
	public static void main(String[] args) { 
		int [] arr = {2,3,9,1,1,3,1};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
		reversedInsertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
