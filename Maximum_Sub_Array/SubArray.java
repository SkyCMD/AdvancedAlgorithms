import java.util.Arrays;

public class SubArray {
	
	public static int[] randomize(int size) {
		int arr[] = new int[size];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*200) - 100;
		}
		
		return arr;
	}

	public static int[] bruteForce(int[] arr) {
		
		int max = Integer.MIN_VALUE;
		int left = 0;
		int right = 0;
		
		for(int i = 0; i < arr.length; i++) {
			int sum = 0;
			for(int j = i; j < arr.length; j++) {
				sum += arr[j];
				if(sum > max) {
					max = sum;
					left = i;
					right = j;
				}
			}
		}
		
		return new int[] {left, right, max};
	}
	
	public static int[] findMaxCrossingSubarray(int[] A, int low, int mid, int high) {
		
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		int maxLeft = 0;
		for(int i = mid; i >= low; i--) {
			sum = sum + A[i];
			if(sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}
		int maxRight = 0;
		sum = 0;
		int rightSum = Integer.MIN_VALUE;
		for(int j = mid+1; j <= high; j++) {
			sum = sum + A[j];
			if(sum > rightSum) {
				rightSum = sum;
				maxRight = j;
			}
		}
		
		return new int[] {maxLeft, maxRight, leftSum + rightSum};
	}
	
	public static int[] linear(int[] A, int low, int high) {
		
		if(high == low)
			return new int[] {low, high, A[low]};
		else if(A.length < 31) {
			return bruteForce(A);
		}
		else {
			int mid = (low + high)/2;
			int[] left = linear(A, low, mid);
			int[] right = linear(A, mid+1, high);
			int[] cross = findMaxCrossingSubarray(A, low, mid, high);
			
			if(left[2] >= right[2] && left[2] >= cross[2]) {
				return left;
			} else if(right[2] >= left[2] && right[2] >= cross[2]) {
				return right;
			} else {
				return cross;
			}
		}
	}
	
	public static void main(String[] args) {
		double[] bTimes = new double[100];
		double[] rTimes = new double[100];
		long startTime;
		long endTime;
		for(int i = 1; i < 101; i++) {
			int[] arr = randomize(i);
			startTime = System.nanoTime();
			bruteForce(arr);
			endTime   = System.nanoTime();
			bTimes[i-1] = endTime - startTime;
			
			startTime = System.nanoTime();
			linear(arr, 0, arr.length-1);
			endTime   = System.nanoTime();
			rTimes[i-1] = endTime - startTime;
		}
		
		System.out.println(Arrays.toString(bTimes));
		System.out.println(Arrays.toString(rTimes));
	}

}
