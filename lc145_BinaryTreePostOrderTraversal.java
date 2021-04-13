class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        helper(res, root);
        return res;
    }
    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }
}


class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                res.add(0, cur.val);
                stack.push(cur.left);
                stack.push(cur.right);
            }
        }
        return res;
    }
}