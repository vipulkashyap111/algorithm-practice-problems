package challenge;

public class MergeSortedArrays {

	public static int[] mergeArrays(int[] a, int[] b){
		if(a.length==0 || b.length==0)
			return a;
		int[] res = new int[a.length+b.length];
		int i, j, k;
		i = j = k = 0;
		while(i<a.length && j<b.length){
			if(a[i]<b[j])
				res[k++] = a[i++];
			else
				res[k++] = b[j++];
		}
		if(i<a.length){
			while(i<a.length)
				res[k++] = a[i++];
		}
		if(j<b.length){
			while(j<b.length)
				res[k++] = b[j++];
		}
		return res;
	}
	
	public static void main(String[] args){
		int[] a = {};
		int[] b = {};
		int[] res = mergeArrays(a,b);
		for(int i:res)
			System.out.print(i+" ");
	}
}
