package arrays;

public class FindDuplicates {
	
	static int findDuplicate(int[] a){
		int sumOfA = 0;
		int n = a.length-1;
		int supposedSum = 0;
		for(int i:a)
			sumOfA+=i;
		supposedSum = n*(n+1)/2;
		System.out.println(sumOfA);
		System.out.println(supposedSum);
		return sumOfA - supposedSum;
	}
	
	public static void main(String[] args){
		int[] a = new int[1000];
		for(int i = 0;i<700;i++){
			a[i] = i+1;
		}
		a[700] = 700;
		for(int i= 701;i<1000;i++)
			a[i] = i;
		for(int i:a)
			System.out.print(i+" ");
		int res = findDuplicate(a);
		System.out.println(res);
	}
}
