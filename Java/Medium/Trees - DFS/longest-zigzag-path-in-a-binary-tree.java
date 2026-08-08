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
class MySolution {
    
    int maxLength = 0;

    public int longestZigZag(TreeNode root) {
        
        dfs(root);
        return maxLength;

    }

    int[] dfs(TreeNode node){

        if (node == null){
            return new int[] {-1, -1};
        }

        int[] leftResult = dfs(node.left);
        int[] rightResult = dfs(node.right);

        int goingLeft = 1 + leftResult[1];
        int goingRight = 1 + rightResult[0];

        maxLength = Math.max(maxLength, Math.max(goingLeft, goingRight));

        return new int[] {goingLeft, goingRight};
    }
}


class BestSolution {
    public int longestZigZag(TreeNode root) {
        return longest(root, 0);
    }

    private int longest(TreeNode root, int dir) {
        if (root == null) {
            return 0;
        }

        int max = 0;

        TreeNode cur = root.left;
        boolean isLeft = true;
        int leftCount = 0;

        while (cur != null) {
            leftCount++;

            if (isLeft) {
                max = Math.max(max, longest(cur.left, 2));
                cur = cur.right;
            } else {
                max = Math.max(max, longest(cur.right, 1));
                cur = cur.left;
            }

            isLeft = !isLeft;
        }

        cur = root.right;
        isLeft = false;
        int rightCount = 0;

        while (cur != null) {
            rightCount++;

            if (isLeft) {
                max = Math.max(max, longest(cur.left, 2));
                cur = cur.right;
            } else {
                max = Math.max(max, longest(cur.right, 1));
                cur = cur.left;
            }

            isLeft = !isLeft;
        }

        if (dir == 1) {
            leftCount++;
        } else if (dir == 2) {
            rightCount++;
        }

        return Math.max(max, Math.max(leftCount, rightCount));
    }
}
