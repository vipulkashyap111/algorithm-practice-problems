package bitManipulation;

import java.util.*;

public class LargestSmallest {

	public static void printBinary(int n){
		StringBuilder s = new StringBuilder();
		while(n!=0){
			s.append(n%2);
			n = n/2;
		}
		System.out.println(s.reverse());
	}
	
	public static boolean getBit(int num, int i){
		return ((num & (1<<i)) != 0);
	}
	
	public static int getCount(int n){
		int count1s = 0;
		for(int i = 0; i< 32 ; i++){
			if(getBit(n, i))
				count1s++;
		}
		return count1s;
	}
	
	public static int smallest(int count1s){		
		int allones = ~0;
		return ((allones<<count1s)-1);
	}
	
	public static int largest(int count1s){
		int allones = ~0;
		count1s = 32 - count1s;
		return ((allones<<count1s));
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printBinary(n);
		int count1s = getCount(n);
		int smallest = smallest(count1s);
		int largest = largest(count1s);
		System.out.println(smallest);
		System.out.println(largest);
		printBinary(smallest);
		printBinary(largest);
		
	}
}
