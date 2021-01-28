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
    public boolean isValidBST(TreeNode root) {
        /*
        1. example
        2. data structure
        3. logic
        4. result
        5. analysis
        =================
        root should ask left and right children if they are binary search tree
        left true: left maximum should be root
        right true: right minimum should be root
        
        boolaen left : isValid(root.left, max = root.val, min = null);
                left.val < max
        boolean right: isValid(root.right, max = null, min = root.val);
             right.val > min
        return isValid(left) && isValid(right);
        
        ===================
        Time: O(N) visited each node exactly once
        Space: O(N) keep up to entire tree
        **/
    
        return isValid(root, null, null);
        
    }
    public boolean isValid(TreeNode root, Integer max, Integer min) {
        if (root == null) return true;
        else if (max != null && root.val >= max || min != null && root.val <= min) return false;
        else {
            return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
        }
    }
    
}