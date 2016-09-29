package codingChallengePractice;

public class KnuthShuffle {

	public static void shuffle(int[] a){
		int n = a.length;
		int j = 0,temp=0;
		for(int i=0;i<n;i++){
			j = i+(int)(Math.random()*(n-i));
			temp = a[j];
			a[j]=a[i];
			a[i]=temp;
		}
	}
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,6,3,8,9};
		shuffle(a);
		for(int i:a)
			System.out.print(i+" ");
	}
}
