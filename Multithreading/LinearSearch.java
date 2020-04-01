import java.util.Arrays;
import java.util.Random;

public class LinearSearch {
	
	public static int[] randomize(int size) {
		int arr[] = new int[size];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*2000000000) - 1000000000;
		}
		
		return arr;
	}
	
	public static int getRandom(int[] arr) {
		Random generator = new Random();
		return arr[generator.nextInt(arr.length)];
	}

	public static void search(int [] arr, int key) {
		int location = -1;
		int div = arr.length/10;
		MyThread t0 = new MyThread(arr, 0, div, key);
		MyThread t1 = new MyThread(arr, div, 2*div, key);
		MyThread t2 = new MyThread(arr, 2*div, 3*div, key);
		MyThread t3 = new MyThread(arr, 3*div, 4*div, key);
		MyThread t4 = new MyThread(arr, 4*div, 5*div, key);
		MyThread t5 = new MyThread(arr, 5*div, 6*div, key);
		MyThread t6 = new MyThread(arr, 6*div, 7*div, key);
		MyThread t7 = new MyThread(arr, 7*div, 8*div, key);
		MyThread t8 = new MyThread(arr, 8*div, 9*div, key);
		MyThread t9 = new MyThread(arr, 9*div, 10*div, key);
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		try {
			t0.join();
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			t6.join();
			t7.join();
			t8.join();
			t9.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(t0.getResult() != -1) {
			location = t0.getResult();
			System.out.println("Thread 0");
		} else if (t1.getResult() != -1) {
			location = t1.getResult();
			System.out.println("Thread 1");
		} else if (t2.getResult() != -1) {
			location = t2.getResult();
			System.out.println("Thread 2");
		} else if (t3.getResult() != -1) {
			location = t3.getResult();
			System.out.println("Thread 3");
		} else if (t4.getResult() != -1) {
			location = t4.getResult();
			System.out.println("Thread 4");
		} else if (t5.getResult() != -1) {
			location = t5.getResult();
			System.out.println("Thread 5");
		} else if (t6.getResult() != -1) {
			location = t6.getResult();
			System.out.println("Thread 6");
		} else if (t7.getResult() != -1) {
			location = t7.getResult();
			System.out.println("Thread 7");
		} else if (t8.getResult() != -1) {
			location = t8.getResult();
			System.out.println("Thread 8");
		} else if (t9.getResult() != -1) {
			location = t9.getResult();
			System.out.println("Thread 9");
		}
		System.out.println("Key is at spot " + location);
	}
	
	public static void crapSearch(int [] arr, int key) {
		int location = -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == key) {
				location = i;
				break;
			}
		}
		System.out.println("Key is at spot " + location);
	}
	
	public static void main(String[] args) {
		double[] cTimes = new double[5];
		double[] mTimes = new double[5];
		long startTime;
		long endTime;
		int random;
		
		int[] small = randomize(10);
		random = getRandom(small);
		crapSearch(small, random);
		search(small,random);
		
		int[] medium = randomize(1000);
		random = getRandom(medium);
		crapSearch(medium, random);
		search(medium,random);
		
		int[] large = randomize(10000);
		random = getRandom(large);
		crapSearch(large, random);
		search(large,random);
		
		int[] wombo = randomize(1000000);
		random = getRandom(wombo);
		startTime = System.nanoTime();
		crapSearch(wombo, random);
		endTime   = System.nanoTime();
		cTimes[0] = endTime - startTime;
		startTime = System.nanoTime();
		search(wombo,random);
		endTime   = System.nanoTime();
		mTimes[0] = endTime - startTime;
		
		int[] wombo2 = randomize(100000000);
		random = getRandom(wombo2);
		startTime = System.nanoTime();
		crapSearch(wombo2, random);
		endTime   = System.nanoTime();
		cTimes[1] = endTime - startTime;
		startTime = System.nanoTime();
		search(wombo2,random);
		endTime   = System.nanoTime();
		mTimes[1] = endTime - startTime;
		
		int[] wombo3 = randomize(500000000);
		random = getRandom(wombo3);
		startTime = System.nanoTime();
		crapSearch(wombo3, random);
		endTime   = System.nanoTime();
		cTimes[2] = endTime - startTime;
		startTime = System.nanoTime();
		search(wombo3,random);
		endTime   = System.nanoTime();
		mTimes[2] = endTime - startTime;

		int[] wombo4 = randomize(1000000000);
		random = getRandom(wombo4);
		startTime = System.nanoTime();
		crapSearch(wombo4, random);
		endTime   = System.nanoTime();
		cTimes[3] = endTime - startTime;
		startTime = System.nanoTime();
		search(wombo4,random);
		endTime   = System.nanoTime();
		mTimes[3] = endTime - startTime;
		
		/*COMMENT OUT NEXT BLOCK ONLY IF PREVIOUS 3 BLOCKS ARE COMMENTED OUT
		 * OTHERWISE YOU WILL RUN OUT OF JAVA HEAP
		*/
		
//		int[] wat = randomize(2137483647);//2147483647);
////		wat[2137483626] = -2000000000;   					//used for worst case testing
//		random = getRandom(wat);
////		random = -2000000000;								//used for worst case testing
//		startTime = System.nanoTime();
//		crapSearch(wat, random);
//		endTime   = System.nanoTime();
//		cTimes[4] = endTime - startTime;
//		startTime = System.nanoTime();
//		search(wat,random);
//		endTime   = System.nanoTime();
//		mTimes[4] = endTime - startTime;

		for(int i = 0; i < 5; i++) {
			System.out.println(cTimes[i]/1000000000);
		}
		for(int i = 0; i < 5; i++) {
			System.out.println(mTimes[i]/1000000000);
		}
	}
}

class MyThread extends Thread {
	private int result = -1;
	private int arr[];
	private int index;
	private int div;
	private int key;
	
	public MyThread(int[] arr, int index, int div, int key) {
		this.arr = arr;
		this.index = index;
		this.key = key;
		this.div = div;
	}
	
	public int getResult() {
		
		return this.result;
	}
	
	public void setResult(int result) {
		this.result = result;
	}
	
	public void run() {
		for(int i = this.index; i < this.div; i++) {
			if(this.arr[i] == this.key) {
				setResult(i);
				break;
			}
		}
	}
}
