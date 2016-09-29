package matrixChain;

public class Dynamic {
	static int[][] m, s;
	static int count = 0;

	public static void main(String args[]) {
		//int[] d = { 10,3,80,9};
		//int[] d = { 30,50,20,15};
		int[] d = { 30, 35, 15, 5, 10, 20, 25 };
		int n = d.length;
		m = new int[n][n];
		s = new int[n][n];
		double start = System.nanoTime();
		dynamicMatrixChain(d);
		double end = System.nanoTime();
		int scalar_multiplications=m[1][n-1];
		System.out.println("No. of scalar multiplications is:");
		System.out.println(scalar_multiplications);
		System.out.println("Running time of Dynamic programming is: "+(end-start)+" ns");
		int multiplications = 0;
		for(int i = 1;i<n-1;i++){
			multiplications+=d[0]*d[i]*d[i+1];
		}
		System.out.println("No. of multiplications if they are multiplied in order is:");
		System.out.println(multiplications);
		print_optimal_path(s, 0, n-1);
	}

	public static void dynamicMatrixChain(int[] p){
		int n = p.length - 1;
			
		for(int l=2; l<=n; l++){
			for(int i=1; i<=n-l+1; i++){
				int j = i+l-1;
				m[i][j] = Integer.MAX_VALUE;
				for(int k=i; k<=j-1; k++){
					int q = m[i][k] + m[k+1][j] + (p[i-1] * p[k] * p[j]);
					if (q < m[i][j])
						m[i][j] = q;
						s[i][j]=k;
				}
			}
		}
	}
	
	public static void print_optimal_path(int[][] s, int i, int j) {
		if(i==j)
			System.out.print("A"+i);
		else{
			System.out.print("(");
			print_optimal_path(s, i, s[i][j]);
			print_optimal_path(s, s[i][j]+1, j);
			System.out.print(")");
		}
	}

}