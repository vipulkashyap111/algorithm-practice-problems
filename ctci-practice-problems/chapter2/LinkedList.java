package chapter2;

import java.util.HashSet;

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

	public void remove(int d) {
		if (!isEmpty()) {
			Node n = head;
			if (n.getData() == d) {
				head = n.getNext();
				return;
			}
			while (n.getNext() != null && n.getNext().getData() != d) {
				n = n.getNext();
			}
			if (n.getNext() == null) {
				System.out.println("Element not present");
			} else
				n.setNext(n.getNext().getNext());
		}
	}

	public void removeDuplicate() {

		Node current, previous;
		current = head;
		while (current != null) {
			previous = current;
			while (previous.getNext() != null) {
				if (previous.getNext().getData() == current.getData()) {
					previous.setNext(previous.getNext().getNext());
				} else {
					previous = previous.getNext();
				}
			}
			current = current.getNext();
		}
	}

	public void removeDuplicateHash() {
		HashSet<Integer> s = new HashSet<Integer>();
		Node previous = null;
		Node current = head;
		while (current != null) {
			if (s.contains(current.getData())) {
				previous.setNext(current.getNext());
			} else {
				s.add(current.getData());
				previous = current;
			}
			current = current.getNext();
		}
	}

	public void print() {
		Node n = head;
		while (n != null) {
			System.out.print(n.getData() + " ");
			n = n.getNext();
		}
	}

	public Node findk(int k) {
		Node n = null;
		int count = 0;
		if (head != null) {
			count = 1;
			n = head;
		}
		while (n.getNext() != null) {
			n = n.getNext();
			count++;
			if (count == k)
				return n;
		}
		if (count < k)
			System.out.println("K is greater than no. of elements in the list");
		n = null;
		return n;
	}

	public void printLastK(int k) {
		Node n = findk(k);
		if (n != null) {
			System.out.println();
			while (n != null) {
				System.out.print(n.getData());
				n = n.getNext();
			}
		}
	}

	public Node printlastkthelement(int k) {
		if (head == null) {
			return head;
		}
		Node p1 = head;
		Node p2 = head;
		int count = k - 1;
		while (count != 0 && p2.getNext() != null) {
			p2 = p2.getNext();
			count--;
		}
		if (p2.getNext() == null)
			return null;
		while (p2.getNext() != null) {
			p2 = p2.getNext();
			p1 = p1.getNext();
		}
		return p1;
	}

	public void deleteMiddle() {
		Node p1 = head;
		Node p2 = head;
		if (p1 != null) {
			while (p2.getNext() != null && p2.getNext().getNext() != null) {
				p1 = p1.getNext();
				p2 = p2.getNext().getNext();
			}
			Node n = head;
			while (n.getNext() != p1) {
				n = n.getNext();
			}
			n.setNext(p1.getNext());
		}

	}

	public void partition(int x) {
		if (head != null) {
			Node n = head;
			Node m = new Node(head.getData());
			Node i, j;
			i = j = m;

			while (n.getNext() != null) {
				n = n.getNext();
				m = new Node(n.getData());
				if (n.getData() < x) {
					m.setNext(i);
					i = m;
				} else {
					j.setNext(m);
					j = m;
				}
			}
			Node temp = i;
			while (temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getNext();
			}
		}

	}

	public void partitionInPlace(int x) {
		Node sStart, sEnd, lStart, lEnd;
		sStart = sEnd = lStart = lEnd = null;
		Node n = head;
		if (n != null) {
			while (n != null) {
				if (n.getData() < x) {
					if (sStart == null)
						sStart = sEnd = n;
					else {
						sEnd.setNext(n);
						sEnd = sEnd.getNext();
					}
				} else {
					if (lStart == null) {
						lStart = lEnd = n;
					} else {
						lEnd.setNext(n);
						lEnd = lEnd.getNext();
					}
				}
				n = n.getNext();
			}
			sEnd.setNext(lStart);
			Node temp = sStart;
			while (temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getNext();
			}
		}
	}

	public void reverse() {
		Node p1, p2;
		p1 = p2 = null;
		if (head != null) {
			p1 = head;
			if (head.getNext() != null)
				p2 = p1.getNext();
		}
		reverse(p1, p2);
	}

	public Node reverse(Node p1, Node p2) {
		if (p2 == null)
			return p1;
		else {
			if (p2.getNext() == null) {
				p2.setNext(p1);
				head=p2;
				return p1;
			} else {
				p2 = reverse(p2, p2.getNext());
				p2.setNext(p1);
				p1.setNext(null);
				return p1;
			}
		}
	}
}
