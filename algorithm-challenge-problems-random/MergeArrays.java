package challenge;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author karishma
 */
import java.util.*;
import java.io.*;

public class MergeArrays
{
	public static int[] MergeArray(int [] A, int [] B)
	{
		int [] C = new int[A.length+B.length];
		int i=0,j=0,k=0;
		while(i<A.length && j<B.length)
		{
			if(A[i]<=B[j])
			{
				C[k]=A[i];
				i++;
				k++;
			}
			else if (B[j]<A[i])
			{
				C[k]=B[j];
				j++;
				k++;
			}
		}
		if(i<A.length)
		{
			for (int l=i;l<A.length;l++)
			{
				C[k]=A[l];
				k++;
			}
		}
		else if (j<B.length)
		{
			for (int l=j;l<B.length;l++)
			{
				C[k]=B[l];
				k++;
			}
		}
		return C;
	}
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int [] A = {1, 3, 5, 7};
		int [] B = {2, 4,6 , 8};
		
		int [] C = MergeArray(A,B);
		for (int i=0;i<C.length;i++)
		{
		System.out.print(C[i]+" ");
		}
	}
}
