package arrays;

public class InsertionSort{

    public void sort(int[] a){
        int x = 0;;
        int j = 0;
        int n = a.length;
        for(int i = 1; i<n; i++){
            x = a[i];
            j = i-1;
            while(j>=0 && x < a[j]){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = x;
        } 
    }
    
    public static void main(String[] args){
        InsertionSort obj = new InsertionSort();
        int[] a = {8 ,7 ,6 , 5};
        obj.sort(a);
        for(int i:a)
            System.out.print(i+" ");
    }
}