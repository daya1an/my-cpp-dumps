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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if (root == null)
            return null;
        
        if (root.val == key){
            
            //leaf node
            if(root.left == null && root.right == null) 
                return null;

            //single child
            else if (root.right == null)
                return root.left;
            
            else if (root.left == null)
                return root.right;

            // sub-tree
            else{
                TreeNode sucessor = root.right;
                
                while (sucessor.left != null)
                    sucessor = sucessor.left;
                
                root.val = sucessor.val;
                root.right = deleteNode(root.right, sucessor.val);  
            }

        } 
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
        
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        
        return root;
    }
}
