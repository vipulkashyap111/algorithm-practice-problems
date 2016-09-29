package bitManipulation;

import java.util.*;

public class InsertMinN {
	
	public String printBinary(int n){
		StringBuilder s = new StringBuilder();
		while(n!=0){
			s.append(n%2);
			n = n/2;
		}
		return s.reverse().toString();
	}
	
	public boolean getBit(int num, int i){
		return ((num & (1<<i)) != 0);
	}
	
	public int updateBit(int num, int i, int v){
		int mask = ~(1<<i);
		return ((num & mask) | (v<<i));
	}
	
	public int insertMinN(int M, int N, int i, int j){
		int v = 0;		
		int l = 0;
		for(int k = i; k<=j;k++){			
			v = (getBit(M,l)==true)?1:0;
			N = updateBit(N, k, v);
			l++;
		}
		return N;
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		InsertMinN obj = new InsertMinN();
		System.out.println("Input N");
		int N = sc.nextInt();
		System.out.println("Input M");
		int M = sc.nextInt();
		System.out.println("Input i");
		int i = sc.nextInt();
		System.out.println("Input j");
		int j = sc.nextInt();
		System.out.println(obj.printBinary(N));
		System.out.println(obj.printBinary(M));
		int result = obj.insertMinN(M,N,i,j);
		System.out.println(obj.printBinary(result));
	}
}
