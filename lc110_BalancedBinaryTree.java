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
    public boolean isBalanced(TreeNode root) {
        /**
        1. example
        2. data structure
        3. logic
        4. result
        5. analysis
        ====================
        get height of left node and right node
        height of 15 = 1
        height of 7 = 1
        height of 20 = 2
        height of 9 = 1
        height of 3 = 3 = max(1, 2) + 1 {abs(left - right) = 1} , so true
        ====================
        
        if getHeight(root) == -1
            return false;
        return true;
        
        int getHeight (root) {
            left = getHeight(root.left)
            right = getHeight(root.right)
            height = Math.max(left, right) + 1
            
            return height
        }
        */
        if (root == null) return true;
        
        if (getHeight(root) == -1)
            return false;
        return true;
        
    }
    
    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        
        int height = Math.max(left, right) + 1;
        
        if (left == -1 || right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return height;
    }
}