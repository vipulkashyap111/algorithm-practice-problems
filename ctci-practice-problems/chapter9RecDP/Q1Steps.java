package chapter9RecDP;

import java.util.*;

public class Q1Steps {
	
	public static int countSteps(int n){		
		if(n == 0)
			return 1;
		if(n<0)
			return 0;
		return countSteps(n-1) + countSteps(n-2) + countSteps(n-3);		
					
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = countSteps(n);
		System.out.println(count);
	}
}
