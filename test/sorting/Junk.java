package sorting;

import java.lang.Math; 

public class Junk{
	
    public static double hash(int x){
    	
        double A = ((Math.sqrt(5)-1)/2);
        return 1000*(x*A%1);
        
    }
    
     public static void main(String []args){
    	 
        for(int i = 61; i < 66; i++){
            System.out.println("Hash of " + i + " is " +(int)hash(i));
        }
     }
}