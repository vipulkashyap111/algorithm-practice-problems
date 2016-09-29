package codingChallengePractice;

class NodeMetaData {
	TreeNode current;
	TreeNode parent;
	int noOfChildren;
}

public class DeleteNodeFromBST {

	static TreeNode root;
	
	public DeleteNodeFromBST() {
		// TODO Auto-generated constructor stub
		root = null;
	}
	
	public void deleteNode(int value){
		root = deleteNode(root,value);
	}
	
	public TreeNode deleteNode(TreeNode node, int value){
		if(node==null)
			return node;
		if(node.data<value)
			node.right = deleteNode(node.right,value);
		else if(node.data>value)
			node.left = deleteNode(node.left, value);
		else{
			if(node.left==null)
				return node.right;
			else if(node.right==null)
				return node.left;
			else{
				node.data = findInOrderSuccessor(node);
				node.right = deleteNode(node.right, node.data);
			}
		}
		return node;
	}
	
	public int findInOrderSuccessor(TreeNode node) {
		TreeNode current = node.right;
		while (current.left != null)
			current = current.left;
		return current.data;
	}

	public void print(TreeNode node) {
		if (node != null) {
			print(node.left);
			System.out.println(node.data);
			print(node.right);
		}
	}

	public static void main(String[] args) {
		DeleteNodeFromBST obj = new DeleteNodeFromBST();
		root = new TreeNode(7);
		root.left = new TreeNode(5);
		root.right = new TreeNode(9);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(10);
		root.right.right.right = new TreeNode(11);
		// obj.search(root, root.right.right);
		// if (n != null)
		// System.out.println(n.current.data + ": " + n.parent.data + ": " +
		// n.noOfChildren);
		// System.out.println(n.parent.left.data);
		// obj.print(root);
		obj.deleteNode(7);

		obj.print(root);
	}
}