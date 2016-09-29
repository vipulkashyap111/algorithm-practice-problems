package arrays;

import java.util.*;

public class FindNumber{

  public static int r_select(int[] a, int i, int start, int end){
    int q = r_partition(a, start, end);
    int k = q-start+1;
    if(i==k)
      return a[q];
    if(i<k){ //left of partition element
      return r_select(a,i,start,q-1);
    }
    else{
      return r_select(a,i-k,q+1,end);
    }
    
  }

  public static int r_partition(int[]a, int start, int end){
    int i,j,r;
    j = start;
    r = end;
    i = j-1;
    int temp = 0;
    for(j=start;j<end;j++){
      if(a[j]<a[r]){
        temp = a[i+1];
        a[i+1]=a[j];
        a[j] = temp;
        i++;
      }
    }
    temp = a[i+1];
    a[i+1] = a[r];
    a[r] = temp;
    return i+1;
  }
  
  public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
    int[] a = {3,6,12,56,2,5,5};
    int i = sc.nextInt(); //ith smallest element
    int res = r_select(a,i,0,a.length-1);
    System.out.println(res);
  }
}
