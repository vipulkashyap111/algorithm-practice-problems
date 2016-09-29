package codingChallengePractice;

public class KthSmallest {

	public int findKthSmallest(int[] a, int astart, int aend, int[] b, int bstart, int bend, int k) {
		int m = aend - astart;
		int n = bend - bstart;
		int i = (int)((double)(m)/(m+n)*(k-1));
		int j = k - 1 - i;
		int Ai_1 = i <= 0 ? Integer.MIN_VALUE : a[i - 1];
		int Bj_1 = j <= 0 ? Integer.MIN_VALUE : b[j - 1];
		int Ai = i >= a.length ? Integer.MAX_VALUE : a[i];
		int Bj = j >= a.length ? Integer.MAX_VALUE : b[j];

		if (Ai_1 < Bj && Bj < Ai)
			return Bj;
		else if (Bj_1 < Ai && Ai < Bj)
			return Ai;

		if (Ai < Bj)
			return findKthSmallest(a, i + 1, aend, b, bstart, j - 1, k);
		else
			return findKthSmallest(a, astart, i - 1, b, j + 1, bend, k);

	}

	public static void main(String[] args) {
		KthSmallest obj = new KthSmallest();
		int[] a = { 1, 3, 5, 7 };
		int[] b = { 2, 4, 6, 8 };
		int k = 2;
		int res = obj.findKthSmallest(a, 0, a.length, b,0,b.length, k);
		System.out.println(res);
	}
}
