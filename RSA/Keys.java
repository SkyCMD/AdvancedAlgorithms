import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Keys {

	public static BigInteger modularExp(BigInteger a, BigInteger b, BigInteger n) {
		
		BigInteger d = new BigInteger("1");
		int[] arr = (intToBinary(b));
		for(int i = 0; i < arr.length; i++) {
			d = d.multiply(d).mod(n);
			if(arr[i] == 1) {
				d = d.multiply(a.mod(n));
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
	
	public static BigInteger encrypt(BigInteger M, BigInteger e, BigInteger n) {
		
//		BigInteger C = modularExp(M,e,n);
		BigInteger C = M.modPow(e, n);
		return C;
	}
	

	public static BigInteger decrypt(BigInteger C, BigInteger d, BigInteger n) {
		
//		BigInteger M = modularExp(C,d,n);
		BigInteger M = C.modPow(d, n);
		return M;
	}
	
	
	public static void main(String[] args) throws IOException {
		BigInteger M;
		M = new BigInteger(Files.readAllBytes(Paths.get("message.txt")));
		Scanner in = new Scanner(new File("e.txt"));
		String temp = in.nextLine();
		BigInteger e = new BigInteger(temp);
		
		in = new Scanner(new File("d.txt"));
		temp = in.nextLine();
		BigInteger d = new BigInteger(temp);

		in = new Scanner(new File("n.txt"));
		temp = in.nextLine();
		BigInteger n = new BigInteger(temp);

		BigInteger C = encrypt(M, e, n);
		BigInteger D = decrypt(C, d, n);

		Path file = Paths.get("encyptedMessage.txt");
		List<String> lines = Arrays.asList(C.toString());
		Files.write(file, lines, StandardCharsets.UTF_8);

		System.out.println("message is " + M.toString());
		System.out.println("cipher is " + C.toString());
		System.out.println("decrypted cyper is " + D.toString());	

		file = Paths.get("unencryptedMessage.txt");
		lines = Arrays.asList(new String(D.toByteArray(), StandardCharsets.UTF_8));
		Files.write(file, lines, StandardCharsets.UTF_8);
//		String string = new String(bytes, StandardCharsets.UTF_8);
	}
}
