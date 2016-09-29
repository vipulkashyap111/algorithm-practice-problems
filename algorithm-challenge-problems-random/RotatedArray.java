package interview;

import java.util.*;

public class RotatedArray{
	
	public static int search(int[] a, int x){
		return binary_search_modified(a, 0, a.length-1, x);
	}

	public static int binary_search_modified(int[] a, int low, int high, int x){
		int mid = (low+high)/2;
		if(a[mid]==x)
			return mid;
		else if(a[mid]>a[low]){	//left subarray is fully sorted and in normal order
			if(a[mid]>x && a[low]<=x ){
				return binary_search_modified(a,low,mid-1,x);
			}
			else
				return binary_search_modified(a,mid+1,high,x);
		}
		else if(a[mid]<a[high]){	//right array is sorted and in normal order
			if(a[mid]<x && a[high]>=x){
				return binary_search_modified(a,mid+1,high,x);
			}
			else
				return binary_search_modified(a,low,mid-1,x);
		} 
		return -1;
	}

	public static void main(String args[]){
		int[] a = {6, 7, 8, 9, 10, 1, 2, 2,  3, 4, 5};
		int x = 2;
		int indexOfx = search(a,x);
		if(indexOfx!=-1)
			System.out.println("Index of "+ x + " in array is: "+ indexOfx);
		else
			System.out.println("Element not present in the array");
	}
}