package trees;

import java.util.*;

public class InOrderIterative {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		if (root == null)
			return res;
		s.push(root);
		TreeNode temp = new TreeNode(0);
		while (!s.isEmpty()) {
			temp = s.peek();
			while (temp.left != null) {
				s.push(temp.left);
				temp = temp.left;
			}
			temp = s.pop();
			res.add(temp.val);
			if (temp.right != null) {
				s.push(temp.right);
			} else {
				while (temp.right == null && !s.isEmpty()) {

					temp = s.pop();

					res.add(temp.val);

				}
				if (temp.right != null)
					s.push(temp.right);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		InOrderIterative obj = new InOrderIterative();
		obj.inorderTraversal(root);
	}
}
