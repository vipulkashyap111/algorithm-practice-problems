package challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MinimumDifference {

	static String closestNumbers(int len, String s){
		StringBuilder res = new StringBuilder();
		String[] in = s.split(" ");
		ArrayList<Integer> a = new ArrayList<Integer>();
		int i = 0;
		for(String x: in){
			a.add(Integer.parseInt(x));
			i++;
		}
		Collections.sort(a);
		int[] diff = new int[len-1];
		for(int j = 0; j<diff.length; j++){
			diff[j]=a.get(j+1)-a.get(j);			
		}
		int min = 0;
		for(int j=0; j<diff.length;j++){
			if(diff[j]<diff[min])
				min = j;
		}
		
		for(int j=0; j<diff.length;j++){
			if(diff[j]==diff[min]){
				res.append(a.get(j)+" ");
				res.append(a.get(j+1)+" ");
			}
		}
		return res.toString();
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = 10;
		String in = "-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854";
		String res = closestNumbers(n,in);
	}
}
