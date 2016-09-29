package arrays;

public class QuickSort{

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
        QuickSort obj = new QuickSort();
        int[] a = {8, 6, 2, 5, 1, 5};
        obj.quickSort(a, 0, a.length-1);
        for(int i:a)
            System.out.print(i+" ");
    }
}
