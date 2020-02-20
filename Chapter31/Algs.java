import java.util.Arrays;

public class Algs {

	public static int euclid (int a, int b) {
		
		if(b==0) {
			return a;
		} else {
			return euclid(b, a%b);
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
	
	public static void main(String[] args) {
		
		System.out.println(euclid(110,33));
		System.out.println(Arrays.toString(euclidExtended(899,493)));

	}

}
