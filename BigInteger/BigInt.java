import java.math.BigInteger;
import java.util.Random;

public class BigInt {
	
	public static void main(String[] args) { 

			int i = 10240;
			Random rand1 = new Random();
			Random rand2 = new Random();
			Random rand3 = new Random();
			Random rand4 = new Random();
			BigInteger big1 = new BigInteger(i, 0, rand1);
			BigInteger big2 = new BigInteger(i, 0, rand2);
			System.out.println(big1);
			System.out.println(big2);
			
			long startTime = System.nanoTime();
			big1.multiply(big2);
			long endTime   = System.nanoTime();
			long totalTime = endTime - startTime;
			System.out.println("Multiplication time of bigs with bit length " + i + ": "+totalTime);
			
			BigInteger big3 = new BigInteger(i/2, 0, rand1);
			BigInteger big4 = new BigInteger(i/2, 0, rand2);
			System.out.println("\n" + big3);
			System.out.println(big4);
			startTime = System.nanoTime();
			big3.divide(big4);
			endTime   = System.nanoTime();
			totalTime = endTime - startTime;
			System.out.println("Division time of bigs with bit length " + i/2 + ": "+totalTime);
			System.out.println("-------------------------------------------------\n");
		
	}
}
