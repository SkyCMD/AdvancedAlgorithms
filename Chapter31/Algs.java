import java.math.BigInteger;
import java.util.Arrays;

public class Algs {

	public static BigInteger euclid (BigInteger a, BigInteger b) {
		
		if(b.equals(new BigInteger("0"))) {
			return a;
		} else {
			return euclid(b, a.mod(b));
		}
	}
	
	public static int[] euclidExtended(int a, int b) {
		int[] arr = {a,1,0};
		
		if(b == 0) {
			return arr;
		} else {
			arr = euclidExtended(b, a%b).clone();
			int temp1 = arr[1];
			int temp2 = arr[2];
			arr[1] = temp2;
			arr[2] = temp1-(a/b)*temp2;
		}
		
		return arr;
	}
	
	public static int modularExp(int a, int b, int n) {
		
		int d = 1;
		int[] arr = (intToBinary(b));
		for(int i = 0; i < arr.length; i++) {
			d = (d*d)%n;
			if(arr[i] == 1) {
				d = (d*a)%n;
			}
		}
		return d;
	}
	
	public static int[] intToBinary(int a) {
		String temp = Integer.toBinaryString(a);
		String[] bin = temp.split("");
		int[] arr = new int[temp.length()];
		for(int i = 0; i < temp.length(); i++) {
			arr[i] = Integer.parseInt(bin[i]);
		}
		return arr;
	}
	
	public static void pseudoprime(int n) {
		if(modularExp(2,n-1,n) != 1) {
			System.out.println(n + " is composite.");
		} else {
			System.out.println(n + " is probably prime.");
		}
	}
	
	public static void main(String[] args) {
		BigInteger a = new BigInteger("110");
		BigInteger b = new BigInteger("33");
		System.out.println("euclid gcd of " + a.toString() + " and " + b.toString() + " is " + euclid(a, b));
		System.out.println("Extended-Euclid output of 889 and 493 is " + Arrays.toString(euclidExtended(899,493)));
		System.out.println("(7^560)%561 is " + modularExp(7, 560, 561));
		pseudoprime(341);

	}

}
