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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (queue.peek() != null) { // break condition, memorize
            TreeNode cur = queue.poll();
            queue.offer(cur.left);
            queue.offer(cur.right);
            
        }
        
        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        return queue.isEmpty();
    }
}


/**
        there shouldn't be nodes after a null node
        */

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean end = false;
        
        while (!queue.isEmpty()) {
            
            TreeNode cur = queue.poll();
            
            if (cur == null) end = true;
            else {
                if (end) return false;
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            
        }
        return true;
    }
}