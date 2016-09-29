package interview;

import java.util.*;

public class LargestNNumbers{
	
	public static int r_select(int[] a, int p, int r, int i){
		int q = 0;
		int k = 0;
		while(p<r){
			q = r_Partition(a,p,r);
			k = r - q+1; //k contains no. of elements to right of q including q
			if(i==k)
				return a[q];
			if(i<k)
				p = q+1;
			else{
				r = q-1;
				i = i-k;
			}
		}
		return a[p];
	}
	
	public static int r_Partition(int[] a, int p, int r){
		int range = r-p+1;
		int randomIndex = (int)(Math.random()*range)+p;
		swap(a,randomIndex,r);
		return partition(a,p,r);
	}

	public static void swap(int[] a, int i, int j){
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
	
	public static int partition(int[] a, int p, int r){
		int i = p-1;
		for(int j = p; j<r;j++){
			if(a[j]<a[r]){
				swap(a,i+1,j);
				i++;
			}
		}
		swap(a,i+1,r);
		return i+1;
	}

	public static void main(String args[]){
		int[] a ={5,8,3,9,7,6,10};
		int n = a.length;
		int max = r_select(a,0,n-1,1);
		int max2 = r_select(a,0,n-1,2);
		int max3 = r_select(a,0,n-1,3);
		System.out.println("Largest 3 numbers are: "+max+" "+max2+" "+max3);
	}
}