class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }
    
    private TreeNode helper(int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if (postEnd < 0 || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        for (int i = inEnd; i >= inStart; i--) {
            if (inorder[i] == root.val) {
                root.left = helper(postEnd - 1 - (inEnd - i), inStart, i - 1, inorder, postorder);
                root.right = helper(postEnd - 1, i + 1, inEnd, inorder, postorder);
            }
        }
        return root;
    }
}