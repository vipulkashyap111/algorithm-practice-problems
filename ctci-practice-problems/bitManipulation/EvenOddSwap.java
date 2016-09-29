package bitManipulation;

import java.util.*;

public class EvenOddSwap {
	
	public static void printBinary(int n){
		StringBuilder s = new StringBuilder();
		while(n!=0){
			s.append(n%2);
			n = n/2;
		}
		System.out.println(s.reverse());
	}
	
	public static int swap(int n){
		int evenmask = 0xaaaaaaaa;
		int oddmask = 0x55555555;
		int evens = (n & evenmask)>>1;
		int odds = (n & oddmask)<<1;
		int ans = (evens | odds);
		return ans;
		
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printBinary(n);
		n = swap(n);
		printBinary(n);
	}
}
