package bstFromSortedArray;

import java.util.*;

public class CreateBST{

	public Node createBST(int[] a, int left, int right){
		Node n = new Node();	
		if(left>right)
			return null;
		if(left == right){
			n.setValue(a[left]);
			return n;
		}		
		int mid = (left+right)/2;
		n.setValue(a[mid]);
		n.setLeft(createBST(a,left,mid-1));
		n.setRight(createBST(a,mid+1,right));
		return n;	
	}

	public void printBST(Node root){
		if(root == null)
			return;
		printBST(root.getLeft());
		System.out.print(root.getValue()+" ");
		printBST(root.getRight());
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements in the array:");
		int n = sc.nextInt();
		System.out.println("Enter elements of the array in sorted order(ascending):");
		int[] a = new int[n];
		for(int i = 0; i<n; i++){
			a[i]=sc.nextInt();
		}
		CreateBST obj = new CreateBST();
		Node root = obj.createBST(a,0,n-1);
		obj.printBST(root);
	}
}