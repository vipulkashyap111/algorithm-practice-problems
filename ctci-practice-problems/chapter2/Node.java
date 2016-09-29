package chapter2;

public class Node {
	private Node next = null;
	private int data;
	
	public Node(int d)
	{
		data = d;
	}
	
	public int getData()
	{
		return data;
	}
	
	public void setData(int d)
	{
		data = d;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public void setNext(Node n)
	{
		next = n;
	}
}
