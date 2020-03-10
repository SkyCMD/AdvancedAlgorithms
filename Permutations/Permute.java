import java.util.ArrayList;
import java.util.Arrays;

public class Permute {

	public static ArrayList<int[]> container = new ArrayList<int[]>();
	public static ArrayList<Integer> counter = new ArrayList<Integer>();
	
	public static void rip(int [] A) {
		for(int i = 0; i < A.length; i++){
			int temp = A[i]; 
			int rand= (int)(Math.random()*(A.length - i)+i);
			A[i] = A[rand];
			A[rand] = temp;
		}
	}
	
	public static void pwa(int [] A) {
		for(int i = 0; i < A.length; i++) {
			int temp = A[i];
			int rand = (int)(Math.random()*A.length);
			A[i] = A[rand];
			A[rand] = temp;
		}
	}
	
	public static void counter(int [] arr) {

		boolean contains = false;

		for(int i = 0; i < container.size(); i++) {
			if(Arrays.equals(arr, container.get(i))) {

				contains = true;
				int temp = counter.get(i);
				counter.set(i, temp+1);
				break;
			}
		}
		if(contains == false) {
			container.add(arr);
			counter.add(1);			
		}
		if(container.size() == 0) {
			container.add(arr);
			counter.add(1);
		}
	}
	
	public static void main(String[] args) {
		
		for(int i = 0; i < 1000000000; i ++) {
			int[] arr = {0,1,2,3,4};
			pwa(arr);
			counter(arr);
		}
		System.out.println(counter.toString());
		
		for(int i = 0; i < 1000000000; i ++) {
			int[] arr = {0,1,2,3,4};
			rip(arr);
			counter(arr);
		}
		System.out.println(counter.toString());
	}
}
