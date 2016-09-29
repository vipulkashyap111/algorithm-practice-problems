package bstFromSortedArray;
public class Node{
	private int value;
	private Node left;
	private Node right;

	Node(){
		value = 0;
		left = null;
		right = null;
	}

	public void setValue(int n){
		value = n;
	}
		
	public int getValue(){
		return value;
	}

	public void setLeft(Node n){
		left = n;
	}
		
	public Node getLeft(){
		return left;
	}

	public void setRight(Node n){
		right = n;
	}
		
	public Node getRight(){
		return right;
	}
}