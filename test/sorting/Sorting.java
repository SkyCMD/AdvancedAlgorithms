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
	
	public static int[] sumBinary(int [] arr1, int [] arr2) {
		if(arr1.length != arr2.length) {
			throw new IllegalArgumentException("Arrays must be same length.");
		}
		int[] sumArray = new int[arr1.length+1];
		int sum;
		int rem = 0;
		for(int i = arr1.length-1; i > -1; i--) {
			sum = arr1[i] + arr2[i] + rem;
			if(sum == 1) {
				sumArray[i+1] = 1;
				rem = 0;
			} else if(sum == 2) {
				sumArray[i+1] = 0;
				rem = 1;
			} else if(sum == 3) {
				sumArray[i+1] = 1;
				rem = 1;
			}
		}
		sumArray[0] = rem;
		return sumArray;
	}
	
	public static void merge(int [] arr, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1+1];
		int[] R = new int[n1+1];
		for(int i = 0; i < n1; i++) {
			L[i] = arr[p+i];
		}
		for(int j = 0; j < n2; j++) {
			R[j] = arr[q+j+1];
		}
		int i = 0;
		int j = 0;
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		for(int k = p; k <= r; k++) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
				}
			else {
				arr[k] = R[j];
				j++;
			}
		}
	}
	
	public static void mergeSort(int[] arr, int p, int r) {
		if(p < r) {
			int q = (p+r)/2;
			mergeSort(arr, p, q);
			mergeSort(arr, q+1, r);
			merge(arr, p, q, r);
		}
	}
	
	public static int binary(int [] arr, int key, int l, int r) {
		
		
		
		return -1;
	}
	
	public static int binarySearch(int [] arr, int key) {
		
		boolean found = false;
		if(key == arr[arr.length/2]) {
			return arr.length/2;
		}
		while(found == false)
		
		return -1;
	}
	
	public static void main(String[] args) { 
		int [] arr = {2,3,9,1,1,3,1};
		System.out.println("Original array:\t\t" + Arrays.toString(arr));
		insertionSort(arr);
		System.out.println("Insertion sort:\t\t" + Arrays.toString(arr));
		reversedInsertionSort(arr);
		System.out.println("Reversed insertion:\t" + Arrays.toString(arr));
		int [] arr1 = {1,0,1,0,1};
		int [] arr2 = {0,1,0,1,1};
		System.out.println("Binary arrays:\t\t   " + Arrays.toString(arr1)+"\n\t\t\t   "+Arrays.toString(arr2));
		System.out.println("Binary sum:\t\t" + Arrays.toString(sumBinary(arr1,arr2)));
		mergeSort(arr, 0, arr.length-1);
		System.out.println("Merge sort:\t\t" + Arrays.toString(arr));
	}
}
