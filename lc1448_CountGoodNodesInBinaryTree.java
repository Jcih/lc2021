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
    public int goodNodes(TreeNode root) {
        
        /*
        DFS, each node need to compare with a maximum number in the path
        **/
        if (root == null) return 0;
        
        helper(root, root.val);
        
        return res;
    }
    
    private void helper(TreeNode root, int max) {
        if (root == null) return;
        
        if (root.val >= max) {
            res++;
        }
        //update max if the current node is greater        
        helper(root.left, Math.max(max, root.val));
        helper(root.right, Math.max(max, root.val));
        
    }
}