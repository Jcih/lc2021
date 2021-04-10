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
class BSTIterator {
    /*
    inorder: 3, 7, 9, 15, 20
    
    inorder traverse uses stack, to push root and left
    
    1. stack [7, 3]
    
    2. next: pop 3, pop 7, ask if 7 has right child, and push right child and all left child of right.
    **/

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        
        TreeNode res = stack.pop();
        if (res.right != null) {
            TreeNode tmp = res.right;
            while (tmp!= null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
        }
        return res.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */