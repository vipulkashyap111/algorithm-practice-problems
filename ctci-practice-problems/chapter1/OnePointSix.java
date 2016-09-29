package chapter1;

public class OnePointSix {

	public static void main(String args[])
	{
		int[][] A = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		//int[][] B = new int[A.length][A.length];
		/*for(int i = 1; i< A.length; i++)
			for(int j = 1; j<A.length;j++)
			{
				B[j][A.length-i-1] = A[i][j];
			}
		for(int i = 1; i< A.length; i++)
		{
			for(int j = 0; j<A.length-1;j++)
				System.out.print(B[i][j]+" ");
			System.out.println();
		}*/
		
		//In place rotation
		int n = A.length;
		int layer=0,temp;
		for(int i = 0; i<n/2; i++)
		{
			layer = i;
			for(int j = i; j<n-layer-1;j++)
			{
				temp = A[layer][j];
				//left to top
				A[layer][j]=A[n-1-j][layer];
				//bottom to left
				A[n-1-j][layer]=A[n-1-layer][n-1-j];
				//right to bottom
				A[n-1-layer][n-1-j] = A[j][n-1-layer];
				//top to right
				A[j][n-1-layer]=temp;
			}
		}
		for(int i = 0; i< A.length; i++)
		{
			for(int j = 0; j<A.length;j++)
				System.out.print(A[i][j]+" ");
			System.out.println();
		}
		
	}
}
