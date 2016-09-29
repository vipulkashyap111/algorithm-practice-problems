package interview;

import java.util.*;

public class ConsecutiveNumbers{
	static int n1,n2;
	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		n2 = (int)((-1+Math.sqrt(1+8*n))/2);
		int temp = n-n2*(n2+1)/2;
		n1 = (int)(((-1+Math.sqrt(1+8*temp))/2));
		if(n1 != 0)
			n1 = n1-1;
		computeSum(n,n2,n1);	
		System.out.println((n1+1)+" "+ n2);
	}

	public static void computeSum(int n,int n2,int n1){
		int sum = n2*(n2+1)/2-n1*(n1+1)/2;
		int diff=n-sum;
		if(diff <= 0)
			return;
		if(diff>n2){
			n2 = n2+1;
			computeSum(n,n2,n1);
		}
		else{
			n1 = n1 - 1;
			computeSum(n,n2,n1);
		}	
	
	}
}