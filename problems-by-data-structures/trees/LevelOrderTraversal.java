package trees;

import java.util.*;

public class LevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return null;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> values = new ArrayList<Integer>();
        Queue<TreeNode> current = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        TreeNode node = root;
        current.add(node);
        
        while(!current.isEmpty()){
            node = current.poll();
            values.add(node.val);
            if(node.left!=null){
                next.add(node.left);
            }
            if(node.right!=null){
                next.add(node.right);
            }
            
            if(current.isEmpty()){
                current = next;
                res.add(values);
                next = new LinkedList<TreeNode>();
                values = new ArrayList<Integer>();
            }
        }
        return res;
    }
	
	public static void main(String[] args){
		TreeNode t1 = new TreeNode(3);
		t1.left = new TreeNode(9);
		t1.right = new TreeNode(20);
		t1.right.left = new TreeNode(15);
		t1.right.right = new TreeNode(7);
		LevelOrderTraversal obj = new LevelOrderTraversal();
		obj.levelOrder(t1);
	}
}
