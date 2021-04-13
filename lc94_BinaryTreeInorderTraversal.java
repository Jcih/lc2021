class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
}


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            
            cur = cur.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }
}