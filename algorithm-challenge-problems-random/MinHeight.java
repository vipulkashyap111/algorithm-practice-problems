package practice;

public class MinHeight {
	public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        int minHeight = 0;
        if((left!=0 && right==0) || (left==0 && right!=0)){
            minHeight = (left>right?left:right) + 1;    
        } else
            minHeight = (left<right?left:right)+1;
        
        return minHeight;
    }
	
	public static void main(String[] args){
		MinHeight obj = new MinHeight();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		obj.minDepth(root);
	}
}
