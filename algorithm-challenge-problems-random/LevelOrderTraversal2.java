package practice;
import java.util.*;
public class LevelOrderTraversal2 {
public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(root==null)
            return list;
        List<Integer> subList = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode current = root;
        q.offer(current);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                current = q.poll();
                if(current.left!=null)
                    q.offer(current.left);
                if(current.right!=null)
                    q.offer(current.right);
                subList.add(current.val);
            }
            ((LinkedList<List<Integer>>) list).addFirst(subList);
            subList = new ArrayList<Integer>();
        }
        return list;
    }
}
