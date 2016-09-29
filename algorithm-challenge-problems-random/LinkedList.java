package interview;

public class LinkedList {

	Node head;

	public LinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	public void print() {
		Node n = head;
		while (n != null) {
			System.out.print(n.getData() + " ");
			n = n.getNext();
		}
	}
	
	public void add(int d) {
		Node end = new Node(d);
		Node n = head;
		if (head == null) {
			head = end;
		} else {
			while (n.getNext() != null)
				n = n.getNext();
			n.setNext(end);
		}
	}
}
