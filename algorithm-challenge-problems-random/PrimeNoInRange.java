package interview;

import java.util.*;

public class PrimeNoInRange{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the range:");
		int start = sc.nextInt();
		int end = sc.nextInt();
		int[] a = new int[end-start];
		int k=0;
		boolean prime = true;
		for(int j = start; j<end; j++){
			prime = true;
			for(int i = 2; i*i < j; i++){
				if(j%i==0){
					prime = false;
					break;
				}
			}
			if(prime)
				a[k++] = j;
		}
		for(int i =0; i<k; i++)
			System.out.println(a[i]+" ");
	}
}