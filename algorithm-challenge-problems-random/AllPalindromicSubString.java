package interview;

import java.util.*;

public class AllPalindromicSubString{
	
	public void computePalindromes(String ip, boolean[][] s){
		int n = ip.length();
		//each element is palidrome with itself
		for(int i = 0; i<n; i++){
			s[i][i] = true;
		}
		//find all palindromes of length 2
		for(int i = 0; i< n-1; i++){
			if(ip.charAt(i)==ip.charAt(i+1))
			s[i][i+1] = true;	
		}
		int startIndex = 0;
		//find all palindromes from length 3
		for(int len = 2; len<n; len++){
			for(int j = 0; j< n-len; j++){
				if(s[j+1][startIndex + len-1] && ip.charAt(startIndex + len)==ip.charAt(j))
					s[j][startIndex + len]=true;
				startIndex++;
			}
			startIndex=0;;
		}
		
	}

	/*public void printPalindromes(String ip, boolean[][] s){
		HashSet<String> op = new HashSet<String>();
		int n = ip.length();
		for(int i = 0; i< n; i++){
			for(int j = 0; j< n; j++){
				if(s[i][j]==true)
					System.out.println(ip.substring(i,j+1));
			}
		}
	}*/
	
	public void printPalindromes(String ip, boolean[][] s){
		ArrayList<String> op = new ArrayList<String>();
		int n = ip.length();
		String temp;
		int startIndex = 0;
		for(int i = 0; i< n; i++){
			for(int j = 0; j< n-i; j++){
				if(s[j][i+startIndex]==true){
					temp = ip.substring(j,i+startIndex+1);
					if(!op.contains(temp))
						op.add(temp);
				}
				startIndex++;
				/*if(s[i][j]==true){
					temp = ip.substring(i,j+1);
					if(!op.contains(temp))
						op.add(temp);
					//System.out.println(ip.substring(i,j+1));
				}*/
			}
			startIndex=0;
		}
		for(String x : op)
			System.out.print(x+" ");
	}
	
	public static void main(String args[]){
	
		Scanner sc = new Scanner(System.in);
		String ip = sc.next();
		int n = ip.length();
		AllPalindromicSubString obj = new AllPalindromicSubString();
		boolean[][] s = new boolean[n][n];
		obj.computePalindromes(ip, s);
		obj.printPalindromes(ip,s);
	}
}