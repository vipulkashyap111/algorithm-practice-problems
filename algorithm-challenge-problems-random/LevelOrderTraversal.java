package practice;

import java.util.*;
import java.util.logging.Level;

public class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		List<Integer> subList = new ArrayList<Integer>();
		Queue<TreeNode> current = new LinkedList<TreeNode>();
		Queue<TreeNode> next = new LinkedList<TreeNode>();
		TreeNode node = root;
		current.add(node);

		while (!current.isEmpty()) {
			node = current.poll();
			subList.add(node.val);
			if (node.left != null) {
				next.add(node.left);
			}
			if (node.right != null) {
				next.add(node.right);
			}

			if (current.isEmpty()) {
				res.add(subList);
				subList = new ArrayList<Integer>();
				current = next;
				next = new LinkedList<TreeNode>();
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		LevelOrderTraversal obj = new LevelOrderTraversal();
		TreeNode root = new TreeNode(1);
		obj.levelOrder(root);
	}
}
