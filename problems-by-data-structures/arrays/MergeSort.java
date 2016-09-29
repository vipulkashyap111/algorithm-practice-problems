package arrays;

public class MergeSort{

    public void mergeSort(int[] a, int start, int end){
        if(end<=start)
            return;
        int mid = (start+end)/2;
        mergeSort(a, start, mid);
        mergeSort(a, mid+1, end);
        merge(a, start, mid, end);
    }
    
    public void merge(int[] a, int start, int mid, int end){
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] b = new int[n1];
        int[] c = new int[n2];
        int k = 0;
        for(int i = start; i<=mid; i++)
            b[k++] = a[i];
        k = 0;
        for(int j = mid+1; j<=end; j++){
            c[k++] = a[j];
        }
        int i = 0;
        int j = 0;
        k = start;
        while(i<n1 && j<n2){
            if(b[i]<c[j]){
                a[k++] = b[i++];
            }
            else{
                a[k++] = c[j++];
            }
        }
        
        while(i<n1){
            a[k++] = b[i++];
        }
        
        while(j<n2){
            a[k++] = c[j++];
        }
       
    }
    
    public static void main(String[] args){
        MergeSort obj = new MergeSort();
        int[] a = {2, 5, 3, 1, 4};
        obj.mergeSort(a, 0, a.length-1);
        for(int i:a)
            System.out.print(i+" ");
    }
}