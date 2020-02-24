import java.math.BigInteger;
import java.util.Random;

public class RSA {
	
	public static BigInteger[] euclidExtended(BigInteger a, BigInteger b) {
		BigInteger[] arr = {a,new BigInteger("1"),new BigInteger("0")};
		
		if(b.equals(new BigInteger("0"))) {
			return arr;
		} else {
			arr = euclidExtended(b, a.mod(b)).clone();
			BigInteger temp1 = arr[1];
			BigInteger temp2 = arr[2];
			arr[1] = temp2;
			arr[2] = temp1.subtract((a.divide(b)).multiply(temp2));
		}
		
		return arr;
	}

	public static BigInteger modularExp(int a, BigInteger b, BigInteger n) {
		
		BigInteger d = new BigInteger("1");
		int[] arr = (intToBinary(b));
		for(int i = 0; i < arr.length; i++) {
			d = d.multiply(d).mod(n);
			if(arr[i] == 1) {
				d = d.multiply(new BigInteger(Integer.toString(a)).mod(n));
			}
		}
		return d;
	}
	
	public static int[] intToBinary(BigInteger b) {
		String temp = b.toString(2);
		String[] bin = temp.split("");
		int[] arr = new int[temp.length()];
		for(int i = 0; i < temp.length(); i++) {
			arr[i] = Integer.parseInt(bin[i]);
		}
		return arr;
	}
	
	public static boolean pseudoprime(BigInteger n) {
		if(modularExp(2,n.subtract(new BigInteger("1")),n).equals(new BigInteger("1")) == false) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		boolean isPrime = false;
		BigInteger p = new BigInteger(1024, new Random());
		BigInteger q = new BigInteger(1024, new Random());
		
		while(isPrime == false) {
			isPrime = pseudoprime(p);
			if(isPrime) {
				isPrime = false; 
				while(isPrime == false && (p.equals(q) == false)) {
					isPrime = pseudoprime(q);
					if(isPrime) {
						break;
					}
					q = new BigInteger(1024, new Random());
				}
			}
			p = new BigInteger(1024, new Random());
		}
		
		BigInteger n = p.multiply(q);
		BigInteger e = new BigInteger("65537");
		BigInteger d = euclidExtended(e,n)[1];
		BigInteger[] P = {e,n};
		BigInteger[] S = {d,n};
		System.out.println("e = " + e.toString());
		System.out.println("d = " + d.toString());
		System.out.println("n = " + n.toString());		
		
		
//		pseudoprime(new BigInteger("1001"));
//		pseudoprime(new BigInteger("1009")); good gravy it works hallelujah
//		pseudoprime(new BigInteger("341")); 

	}

}
