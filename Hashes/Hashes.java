import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Hashes {

	public static void main(String[] args) throws FileNotFoundException {
		
		String[] list = {"Shakespeare_20_percent.txt","Shakespeare_40_percent.txt",
				"Shakespeare_60_percent.txt","Shakespeare_80_percent.txt",
				"Shakespeare_100_percent.txt"};
		for(int i = 0; i < 5; i++)
		{
			int sanityCheck = 0;
			Scanner inf = new Scanner(new File(list[i]));
			String str = inf.next();
			str = str.replaceAll("[^a-zA-Z0-9]", "");
			ArrayList<String> a = new ArrayList<String>();
			long startTime = System.nanoTime();
			while(inf.hasNext()){
				if(a.contains(str)) {
					str = inf.next();
					str = str.replaceAll("[^a-zA-Z0-9]", "");
					continue;
				}
				else {
					a.add(str);
					sanityCheck++;
				}
				str = inf.next();
				str = str.replaceAll("[^a-zA-Z0-9]", "");
			}
			long endTime   = System.nanoTime();
			long totalTime = endTime - startTime;
			double seconds = (double)totalTime/1000000000;
			System.out.println("ArrayList took "+ seconds + " seconds.");
			inf = new Scanner(new File(list[i]));
			str = inf.next();
			str = str.replaceAll("[^a-zA-Z0-9]", "");
			
			HashMap<String,Integer> h = new HashMap<String,Integer>();
			startTime = System.nanoTime();
			System.out.println("Number of words in ArrayList: " + sanityCheck);
			sanityCheck = 0;
			while(inf.hasNext()){
				if(h.containsKey(str)) {
					str = inf.next();
					str = str.replaceAll("[^a-zA-Z0-9]", "");
					continue;
				}
				else {
					h.put(str, str.hashCode());
					sanityCheck++;
				}
				str = inf.next();
				str = str.replaceAll("[^a-zA-Z0-9]", "");
			}
			endTime   = System.nanoTime();
			totalTime = endTime - startTime;
			seconds = (double)totalTime/1000000000;
			System.out.println("HashMap took "+ seconds + " seconds.");

			System.out.println("Number of words in HashMap: " + sanityCheck+"\n");

		}
	}
}
