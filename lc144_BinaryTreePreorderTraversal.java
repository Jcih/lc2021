class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                res.add(cur.val);
                stack.add(cur.right);
                stack.add(cur.left);
            }
        }
        return res;
    }
}