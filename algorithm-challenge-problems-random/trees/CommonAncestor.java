package trees;

import java.util.*;

public class CommonAncestor {

	static Node1 root;

	public static Node1 findAncestor(Node1 one, Node1 two) {
		Node1 parent1, parent2;
		
		parent1 = one;
		parent2 = two;

		while(parent1!=null || parent2!=null){
			parent1 = parent1.parent;
			if(parent1.visited)
				return parent1;
			parent1.visited=true;
			parent2 = parent2.parent;
			if(parent2.visited)
				return parent2;
			parent2.visited=true;			
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		root = new Node1(1);
		root.parent = null;
		root.left = new Node1(2);
		root.right = new Node1(3);
		root.left.parent = root;
		root.right.parent = root;

		root.left.left = new Node1(4);
		root.left.right = new Node1(5);
		root.left.left.parent = root.left;
		root.left.right.parent = root.left;

		root.right.left = new Node1(6);
		root.right.right = new Node1(7);
		root.right.left.parent = root.right;
		root.right.right.parent = root.right;

		root.left.left.left = new Node1(8);
		root.left.left.left.parent = root.left.left;

		Node1 res = findAncestor(root.left , root.left.left);
		System.out.println(res.label);
	}
}
