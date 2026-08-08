//my solution
import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {    
        List<Integer> list1 = getAllLeaves(root1);
        List<Integer> list2 = getAllLeaves(root2);
        System.out.println("List 1 = " + list1 + ", List 2 = " + list2);
        return list1.equals(list2); 
    }

    public List<Integer> getAllLeaves(TreeNode root){
        List<Integer> result = new ArrayList<>();
        dfs(result, root);
        return result;
    }

    public static void dfs(List<Integer> result, TreeNode node){
        
        if(node == null) return;

        if (node.left == null && node.right == null){
            result.add(node.val);
            return;
        }

        dfs(result, node.left);

        dfs(result, node.right);
    }
}

// best solution

class Solution {
   
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2, l2);
        return l1.equals(l2);
    }


    public void dfs(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        if(root.left==null && root.right== null){
            list.add(root.val);
            return;
        }

        dfs(root.left, list);
        dfs(root.right, list);
    }
}
