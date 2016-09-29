package chapter2;

public class LLimp {

	public static void main(String args[]) {
		LinkedList l = new LinkedList();
		l.add(1);
		l.add(2);
		l.add(2);
		l.add(4);
		l.add(3);
		l.add(8);
		l.print();

		// Partition in place
		System.out.println("After Partition");
		l.partitionInPlace(4);

		// Partition LL
		/*
		 * System.out.println("After Partition"); l.partition(4);
		 */

		// Delete middle element
		/*
		 * l.deleteMiddle(); System.out.println("After deleting middle element"
		 * ); System.out.println(); l.print();
		 */
		// Kth to last element
		/*
		 * System.out.println("Kth to last element is"); Node k =
		 * l.printlastkthelement(0); if (k != null)
		 * System.out.println(k.getData()); else System.out.println(
		 * "K is more than length");
		 */
		/*
		 * System.out.println("3rd to last elements:"); l.printLastK(7);
		 * l.remove(2); System.out.println(); l.print(); l.add(2);
		 * System.out.println(); l.print(); l.remove(4); l.add(2);
		 * System.out.println(); l.print(); l.removeDuplicate();
		 * System.out.println("Duplicates removed"); l.print(); l.add(3);
		 * System.out.println(); l.print(); l.removeDuplicateHash();
		 * System.out.println("Duplicates removed"); l.print();
		 */
	}
}
