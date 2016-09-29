package matrixChain;

public class Memoization {

	static int[][] m, s;
	static int count = 0;

	public static void main(String args[]) {
		//int[] d = { 30, 35, 15, 5, 10, 20, 25 };
		//int[] d = { 30,50,20,15};
		int[] d = { 10,3,80,9};
		int n = d.length;
		m = new int[n][n];
		s = new int[n][n];
		double start = System.nanoTime();
		int scalar_multiplications = mem_matrix_chain(d, 1, n - 1);
		double end = System.nanoTime();
		System.out.println("No. of scalar multiplications is:");
		System.out.println(scalar_multiplications);
		System.out.println("No. of recursive calls is:");
		System.out.println(count);
		System.out.println("Running time of Memoization is: "+(end-start)+" ns");
	}

	public static int mem_matrix_chain(int[] d, int i, int j) {
		for (int k = 1; k < m.length; k++) {
			for (int l = 1; l < m[0].length; l++) {
				m[k][l] = Integer.MAX_VALUE;
			}
		}
		return lookup_chain(d, i, j);
	}

	private static int lookup_chain(int[] d, int i, int j) {
		int q = 0;
		if (m[i][j] < Integer.MAX_VALUE)
			return m[i][j];
		count++;
		if (i == j) {
			m[i][j]= 0;
		} else {
			for (int k = i; k < j; k++) {
				q=lookup_chain(d, i, k)+lookup_chain(d, k+1, j)+d[i-1]*d[k]*d[j];
				if(q<m[i][j]){
					m[i][j]=q;
					s[i][j]=k;
				}
			}
		}
		return m[i][j];
	}

}
