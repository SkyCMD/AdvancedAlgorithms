import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Keys {
	
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
	
	public static void main(String[] args) throws IOException {
		BigInteger p = new BigInteger(1024, new Random());
		BigInteger q = new BigInteger(1024, new Random());
//		BigInteger p = new BigInteger("101");
//		BigInteger q = new BigInteger("103");    //for testing
		
		while(true) {
			if(pseudoprime(p))
				break;
			p = new BigInteger(1024, new Random());
		}
		while(true) {
			if(pseudoprime(q))
				if(q.equals(p) == false)
					break;
			q = new BigInteger(1024, new Random());
		}
		
		BigInteger n = p.multiply(q);
//		BigInteger e = new BigInteger("13");     for testing
		BigInteger e = new BigInteger("65537");
		BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		BigInteger d = euclidExtended(e,phi)[1];
//		BigInteger d = e.modInverse((p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)));
		if(d.signum() == -1) {
			d = d.add(phi);
		}
//		BigInteger[] P = {e,n};
//		BigInteger[] S = {d,n};
		System.out.println("e = " + e.toString());
		System.out.println("d = " + d.toString());
		System.out.println("n = " + n.toString());		
		
		Path filee = Paths.get("e.txt");
		Path filen = Paths.get("n.txt");
		Path filed = Paths.get("d.txt");
		List<String> lines = Arrays.asList(e.toString());
		Files.write(filee, lines, StandardCharsets.UTF_8);
		lines = Arrays.asList(n.toString());
		Files.write(filen, lines, StandardCharsets.UTF_8);
		lines = Arrays.asList(d.toString());
		Files.write(filed, lines, StandardCharsets.UTF_8);
	}

}
