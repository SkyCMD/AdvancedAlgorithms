import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.Random;

public class BCS {

	protected static String getSaltString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
	
	public static String findBCS(String str1, String str2) {
		int firstLength = str1.length();
		int secondLength = str2.length();
		int[][] BCSarr = new int[firstLength + 1][secondLength + 1]; 
        int strLen = 0;
        int rowNum = 0;
        int colNum = 0;
        String resultStr = "";
        
        for (int i=0; i<=firstLength; i++){ 
            for (int j=0; j<=secondLength; j++){ 
                if (i==0||j==0) {
                    BCSarr[i][j] = 0; 
                }else if(str1.charAt(i-1)==str2.charAt(j-1)){ 
                    BCSarr[i][j] = BCSarr[i-1][j-1]+1; 
                    if (strLen<BCSarr[i][j]){ 
                        strLen=BCSarr[i][j]; 
                        rowNum=i; 
                        colNum=j; 
                    } 
                } 
                else{
                    BCSarr[i][j]=0; 
                }
            } 
        } 
  
        if(strLen == 0){ 
            return "No Common Substring";
        }  
  
        while(BCSarr[rowNum][colNum]!=0){ 
            resultStr = str1.charAt(rowNum - 1) + resultStr;
            strLen--; 
            rowNum--; 
            colNum--; 
        } 
  
        return resultStr;
	}
	
	public static void main(String[] args) throws IOException {
		BigDecimal[] times = new BigDecimal[100000];
		long startTime;
		long endTime;
		BigDecimal sTime;
		BigDecimal eTime;
		String s1;
		String s2;
		FileWriter fw = new FileWriter("times.txt");
		BufferedWriter out = new BufferedWriter(fw);
		
//		for(int i = 10; i < 5010; i++) {
//			s1 = getSaltString(i);
//			s2 = getSaltString(i);
//			startTime = System.nanoTime();
//			findBCS(s1, s2);
//			endTime = System.nanoTime();
//			sTime = new BigDecimal(startTime);
//			eTime = new BigDecimal(endTime);
//			times[i-10] = (eTime.subtract(sTime)).divide(new BigDecimal(1000000000));  //(endTime - startTime)/1000000000;
//			System.out.println("Length: " + (i-10) + "\tTime: " + times[i-10].toString());
//			out.write(times[i-10].toString());
//			out.newLine();
//		}
		
		for(int i = 14900; i < 15010; i++) {
			s1 = getSaltString(i);
			s2 = getSaltString(i);
			startTime = System.nanoTime();
			findBCS(s1, s2);
			endTime = System.nanoTime();
			sTime = new BigDecimal(startTime);
			eTime = new BigDecimal(endTime);
			times[i-10] = (eTime.subtract(sTime)).divide(new BigDecimal(1000000000));  //(endTime - startTime)/1000000000;
			System.out.println("Length: " + (i-10) + "\tTime: " + times[i-10].toString());
			out.write(times[i-10].toString());
			out.newLine();
		}
		out.close();
	}
}
