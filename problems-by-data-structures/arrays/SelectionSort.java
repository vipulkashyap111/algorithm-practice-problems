package arrays;

public class SelectionSort{

    public void sort(int[] a){
        int min = 0;
        int n = a.length;
        
        int temp = 0;
        for(int i = 0; i<n; i++){
            min = i;
            for(int j = i; j<n;j++){
                if(a[j]<a[min]){
                    min = j;
                    
                }    
            }
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;          
        }
    }
    
    public static void main(String[] args){
        SelectionSort obj = new SelectionSort();
        int[] a = {2, 5, 3, 1, 4};
        obj.sort(a);
        for(int i:a)
            System.out.print(i+" ");
    }
}