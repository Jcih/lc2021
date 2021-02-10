//Time complexity: O(N) since we visit all nodes once.
//Space complexity: O(N) 
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
    public int maxAncestorDiff(TreeNode root) {
        /*
         dfs to get max and min
         root, root.val, root.val
         
         dfs()
        */
        return helper(root, root.val, root.val);
    }
    public int helper(TreeNode root, int max, int min) {
        
        if (root == null) return max - min;
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        return Math.max(helper(root.left, max, min), helper(root.right, max, min));
    }
}