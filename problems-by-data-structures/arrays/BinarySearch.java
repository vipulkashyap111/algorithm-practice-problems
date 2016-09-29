package arrays;

import java.util.*;

public class BinarySearch{

   /* public int binarySearch(int[] a, int value){
        int res = search(a, 0, a.length, value);
        return res;        
    }
    
    public int search(int[] a, int l, int r, int value){
        if(l<r){
            int mid = (l+r)/2;
            if(a[mid]==value)
                return mid;
            else if(a[mid]>value)
                return search(a, l, mid, value);
            else if(a[mid]<value)
                return search(a, mid+1, r, value); 
        }
        return -1;
    }*/
	
	public int binarySearch(int[] a, int value){
        int first = 0;
        int last = a.length-1;
        int middle = (first + last)/2;
        
        while(first<=last){
            
            if(a[middle] == value)
                break;
            else if(a[middle]<value){
                first = middle+1;
            }
            else
                last = middle;
            middle = (first + last)/2;
            
            if(first>last)
                return -1;
        }
        return middle;
    }    
    
    
    public void quickSort(int[] a, int left, int right){
        if(left<right){
            int q = r_partition(a, left, right);
            quickSort(a, left, q-1);
            quickSort(a, q+1, right);
        }        
    }
    
    public int r_partition(int[] a, int l, int r){
        int rand = (int)(Math.random()*(r-l)+l);
        int temp = 0;
        temp = a[rand];
        a[rand] = a[r];
        a[r] = temp;
        int pivot = r;
        int i = l-1;
        
        for(int j = l; j<r; j++){
            if(a[j]<a[pivot]){
                i++;
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        temp = a[i+1];
        a[i+1]=a[pivot];
        a[pivot] = temp;
        return i+1;
    }
    public static void main(String[] args){
        BinarySearch obj = new BinarySearch();
        int[] a = {2, 5, 3, 1, 4};
        obj.quickSort(a, 0, a.length-1);
        System.out.println(obj.binarySearch(a, 3));
        
        LinkedList<Integer> l = new LinkedList<Integer>();
       
        
    }
}