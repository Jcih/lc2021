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
    List<Integer> res = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        res.add(root.val);// root
        leftBoundary(root.left); // add left boundary
        
        leaves(root.left); //add leaves
        leaves(root.right); // add leaves
        
        rightBoundary(root.right); // add right boundary
        return res;
    }
    
    private void leftBoundary(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) return; // leaves
        res.add(root.val);
        if (root.left == null) leftBoundary(root.right);
        else leftBoundary(root.left);
    }
    
    private void leaves(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
    
    private void rightBoundary(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) return; // leaves
        if (root.right == null) rightBoundary(root.left);
        else rightBoundary(root.right);
        res.add(root.val); // reverse order
    }
    
}