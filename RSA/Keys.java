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
		
		BigInteger M = C.modPow(d, n);
		return M;
	}
	
	
	public static void main(String[] args) throws IOException {
//		Scanner in = new Scanner(new File("e.txt"));
//		String temp = in.nextLine();
		BigInteger M;
//		BigInteger e = new BigInteger(temp);
		BigInteger e = new BigInteger("65537");
//		in = new Scanner(new File("d.txt"));
//		temp = in.nextLine();
//		BigInteger d = new BigInteger(temp);
		BigInteger d = new BigInteger("1405662730738984844018758759398406337292358917503068686012926520728191381272661495503586778594326249900100300930577592686620393918021959643220822024578888247543444261677336909705418737435298303041585514368849484910121981515040501615548776335416237442356988211681334370686701039241304038055880851591384495194235521880442083406615284022703558248923693831621876491854951459459159578890444297459600827206079149585537484968171653620416518321486013532658943063087474212936417312763839604321046421475208778635232858756357102151153724299631168185944069145581274637549461751753197281030510695036078460287598381772249088512449");
//		in = new Scanner(new File("n.txt"));
//		temp = in.nextLine();
//		BigInteger n = new BigInteger(temp);
		BigInteger n = new BigInteger("2913346142893673499334536947430294934604513657898188307619277233135051976675829873527673593774275305641911179978092523699536407963233457801390310648772227288170984680356333735535372941883468103046595296011868337261777435961899034008355844365901582911980960008505727543458281711797771820690941569550126993502673674330981728385073000198288511376310382211045693322090625268326470493241860888583201333637323980935798435527445264544206846310855875762641068160062029844612196825984128848459558585445364471398108267748582107674818511604520134274144222133601577460766680554982934559689399013117562784217126900524031045167876");
//		M = new BigInteger(Files.readAllBytes(Paths.get("message.txt")));
		M = new BigInteger("66");
		System.out.println("message is " + M.toString());
		BigInteger C = encrypt(M, e, n);
//		Path file = Paths.get("encyptedMessage");
//		List<String> lines = Arrays.asList(C.toString());
//		Files.write(file, lines, StandardCharsets.UTF_8);
//		lines = Arrays.asList(n.toString());
		BigInteger D = decrypt(C, d, n);
		System.out.println("cipher is " + C.toString());
		System.out.println("decrypted cyper is " + D.toString());		
	}

}
