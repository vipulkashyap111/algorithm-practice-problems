package interview;
import java.util.*;

public class ReverseN1toN2inLL{

	private static Node reverseHead = null;
	public static void reversen1n2 (LinkedList l, int v1, int v2)throws Exception{
		if(l.head!=null)
		{
			int counter = 1;
			Node pointer = l.head;
			Node n1,n2,p1,p2;
			n1=n2=p1=p2 = null;
			while(pointer.getNext()!=null){
				counter++;
				pointer = pointer.getNext();
				if(counter == v1-1){
					p1 = pointer;
					n1 = p1.getNext();
				}
				if(counter == v2){
					n2 = pointer;
					p2 = n2.getNext();
					break;
				}
			}
			if(counter<v2){
				n2 = pointer;
				p2 = n2.getNext();
			}
			n2.setNext(null);
			n2 = n1.getNext();
			reverse(l,n1,n2);
			Node t1 = reverseHead;
			p1.setNext(t1);
			pointer = t1;
			while(pointer.getNext()!=null)
				pointer = pointer.getNext();
			pointer.setNext(p2);
		}
		else throw new Exception("Linked list is empty");
	}

	public static Node reverse(LinkedList l, Node p1, Node p2){
		if(p2.getNext()==null){
			p2.setNext(p1);
			p1.setNext(null);
			reverseHead = p2;
			return p1;
		}	
		else{
			p2 = reverse(l,p2,p2.getNext());
			p2.setNext(p1);
			p1.setNext(null);
		}
		return p1;
	}

	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		LinkedList l = new LinkedList();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		l.add(7);
		l.add(8);
		l.add(9);
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();		// validate v1,v2 is within range
		reversen1n2(l,v1,v2);
		l.print();
	}
}