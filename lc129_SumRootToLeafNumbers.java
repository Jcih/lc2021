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
    int res = 0;
    public int sumNumbers(TreeNode root) {
        /*
        
        DFS until the node has no child, we can add the number to result;
        each level, last * 10 + cur
        
        
        */
        
        if (root == null) return 0;
        helper(root, 0);
        return res;
    }
    
    private void helper(TreeNode root, int last) {
        if (root == null) return;
        
        last = last * 10 + root.val;
        if (root.left == null && root.right == null)
            res += last;
        
        helper(root.left, last);
        helper(root.right, last);
    }
}