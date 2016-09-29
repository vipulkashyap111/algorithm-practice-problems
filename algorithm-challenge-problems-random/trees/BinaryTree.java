package trees;

public class BinaryTree{

	  static Node root;
	  public int maxDepth(Node node){
	    if(node.left == null && node.right == null){
	      return 0;
	    }
	    
	    int lDepth = maxDepth(node.left);
	    int rDepth = maxDepth(node.right);
	    
	    if(lDepth>rDepth)
	      return lDepth+1;
	    else
	      return rDepth+1;
	  }
	  
	  public static void main(String[] args){
		BinaryTree obj = new BinaryTree();
	    root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    int depth = obj.maxDepth(root);
	    System.out.println(depth);
	  }
}