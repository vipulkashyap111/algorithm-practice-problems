package matrixChain;

public class Recursion {

	static int[][] m, s;
	static int count = 0;

	public static void main(String args[]) {
		int[] d = { 30, 35, 15, 5, 10, 20, 25 };
		//int[] d = { 30,50,20,15};
		//int[] d = { 10,3,80,9};
		int n = d.length;
		m = new int[n][n];
		s = new int[n][n];
		double start = System.nanoTime();
		int scalar_multiplications = rec_matrix_chain(d, 1, n - 1);
		double end = System.nanoTime();
		System.out.println("No. of scalar multiplications is:");
		System.out.println(scalar_multiplications);
		System.out.println("No. of recursive calls is:");
		System.out.println(count);
		System.out.println("Running time of Recursive algorithm is: "+(end-start)+" ns");
		for (int k = 1; k < m.length; k++) {
			for (int l = 1; l < m[0].length; l++) {
				System.out.print(m[k][l]+" ");
			}
			System.out.println();
		}
	}

	public static int rec_matrix_chain(int[] d, int i, int j) {
		count++;
		int q = 0;
		if (i == j)
			return 0;
		m[i][j] = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			q = rec_matrix_chain(d, i, k) + rec_matrix_chain(d, k + 1, j) + d[i - 1] * d[k] * d[j];
			if (q < m[i][j]) {
				m[i][j] = q;
				s[i][j] = k;
			}
		}
		return m[i][j];
	}
}
