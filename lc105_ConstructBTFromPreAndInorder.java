//https://www.youtube.com/watch?v=GeltTz3Z1rw
//(inIndex - inStart) is the size of root's left subtree.
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }
        
        root.left = helper(preStart + 1, inStart, index - 1, preorder, inorder);
        root.right = helper(preStart + 1 + index - inStart, index + 1, inEnd, preorder, inorder);
        return root;
    }
}