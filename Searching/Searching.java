import java.util.Arrays;

public class Searching {
	
	public static int randomSearch(int [] arr, int s){
		
		int spots = 0;
		int counter = 0; 
		int [] count = new int[arr.length];
		while(counter != arr.length) {
			int rand = (int)(Math.random()*arr.length);
			if(count[rand] == 1) {
				spots++;
				continue;
			}
			else if(arr[rand] == s) {
//				return rand;
				return spots;
			} else if(count[rand] == 0) {
				count[rand] = 1;
				counter++;
			}
			spots++;
		}
//		return -1;
		return spots;
	}
	
	public static int detSearch(int [] arr, int s) {
		
		int spots = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == s)
//				return i;
				return spots;
			spots++;
		}
//		return -1;
		return spots;
	}
	
	public static int scramble(int [] arr, int s) {
		int[] copy = arr.clone(); 
		rip(copy);
		int i = detSearch(copy,s);
		if(i == -1) 
//			return -1;
			return i;
		else
			return i;
	}
	
	public static void rip(int [] A) {
		for(int i = 0; i < A.length; i++){
			int temp = A[i]; 
			int rand= (int)(Math.random()*(A.length - i)+i);
			A[i] = A[rand];
			A[rand] = temp;
		}
	}
	
	public static int[] randomize(int size) {
		int arr[] = new int[size];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*1000);
		}
		return arr;
	}

	public static void main(String[] args) {

		int[] arr = randomize(10000);
		arr[1000] = -1;
		int s = -1;
		int[] randAvg = new int[10000];
		int[] detAvg = new int[10000];
		int[] scrAvg = new int[10000];
		int[] ranNot = new int[10000];

		for(int i = 0; i < 10000; i++) {
			randAvg[i] = randomSearch(arr,s);
			detAvg[i] = detSearch(arr,s);
			scrAvg[i] = scramble(arr, s);
			ranNot[i] = randomSearch(arr, -2);
		}
		
		int[] avgs = new int[4];
		for(int i = 0; i < 10000; i++) {
			avgs[0] += randAvg[i];
			avgs[1] += detAvg[i];
			avgs[2] += scrAvg[i];
			avgs[3] += ranNot[i];
		}
		avgs[0] = avgs[0]/10000;
		avgs[1] = avgs[1]/10000;
		avgs[2] = avgs[2]/10000;
		avgs[3] = avgs[3]/10000;
		
		System.out.println(avgs[0] +" "+avgs[1]+" "+avgs[2]+" "+avgs[3] );

	}
}
