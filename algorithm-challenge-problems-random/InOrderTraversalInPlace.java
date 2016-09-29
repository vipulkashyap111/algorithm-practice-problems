package codingChallengePractice;

public class InOrderTraversalInPlace {

	public void inorder(TreeNode root){
		if(root==null)
			return;
		TreeNode current = root;
		TreeNode runner = null;
		while(current!=null){
			if(current.left!=null){
				runner = current.left;
				while(runner.right!=null && runner.right!=current){
					runner = runner.right;
				}
				if(runner.right!=current){
					runner.right = current;
					current = current.left;
				}else{					
					runner.right=null;
					System.out.print(current.data+" ");
					current = current.right;
					
				}
			}else{
				System.out.print(current.data+" ");
				current = current.right;
			}
		}
		
	}
	
	public static void main(String[] args){
		InOrderTraversalInPlace in = new InOrderTraversalInPlace();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		in.inorder(root);
	}
}
