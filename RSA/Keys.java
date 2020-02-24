import java.math.BigInteger;

public class Keys {

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
	
	public static BigInteger encrypt(BigInteger M, BigInteger d, BigInteger n) {
		
//		BigInteger C = modularExp()
		
		return null;
	}
	
	public static void main(String[] args) {

		
		
	}

}
