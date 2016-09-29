package chapter2;

public class TwoPointFive {

	public static void main(String args[]) {
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		LinkedList l3 = new LinkedList();
		l1.add(6);
		l1.add(1);
		l1.add(7);
		l2.add(2);
		l2.add(9);
		l2.add(5);
		int n1, n2, n3;
		n1 = n2 = n3 = 0;
		int len1,len2;
		len1=len2=0;
		int multiplier = 1;
		Node n = l1.head;
		while(n!=null){
			len1++;
			n=n.getNext();
		}
		n = l2.head;
		while(n!=null){
			len2++;
			n=n.getNext();
		}
		
		//Forward storage
		
		//Reverse storate
		/*while(n!=null){
			n1 = n1 + multiplier*(n.getData());
			multiplier*=10;
			n=n.getNext();
		}
		n = l2.head;
		multiplier = 1;
		while(n!=null){
			n2 = n2 + multiplier*(n.getData());
			multiplier*=10;
			n=n.getNext();
		}
		n3 = n1+n2;
		System.out.println(n3);
		while(n3!=0){
			l3.add(n3%10);
			n3=n3/10;
		}
		l3.print();*/
		
	}
}
