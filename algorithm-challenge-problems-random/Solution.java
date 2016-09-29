package codingChallengePractice;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void binarize(int[] a){
		int n = a.length;
		if(n==0)
			return;
		int[] a1 = new int[n];
		int[] a2 = new int[n];
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<a.length;i++){
			if(!map.containsKey(a[i])){				
				map.put(a[i], i);
			}else{
				a1[i] = 1;
				a2[map.get(a[i])]=1;
			}
		}
		print(a1);
		System.out.println();
		print(a2);
	}
	
	public static void print(int[] a){
		for(int i:a)
			System.out.print(i);
	}
	public static void main(String[] args){
		int[] a = {1,3,2,4,3,0,1};
		binarize(a);		
	}
}
