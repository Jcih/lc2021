/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null,";
        
        String s = "";
        s += root.val + ",";
        s += serialize(root.left);
        s += serialize(root.right);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> nodeList = new ArrayList<>(Arrays.asList(split));
        return deserializeHelper(nodeList);
    }
    
    private TreeNode deserializeHelper(List<String> nodeList) {
        if (nodeList == null) return null;
        
        String head = nodeList.get(0);
        nodeList.remove(0);
        if (head.equals("null")) return null;
        
        TreeNode root = new TreeNode(Integer.valueOf(head));
        root.left = deserializeHelper(nodeList);
        root.right = deserializeHelper(nodeList);
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));





//similar with 428
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        /*Preorder*/
        List<String> list = new ArrayList<>();
        serializeHelper(root, list);
        return String.join(",", list);
        
    }
    private void serializeHelper(TreeNode root, List<String> list) {
        if (root == null) 
            list.add("null");
        else {
            list.add(String.valueOf(root.val));
            serializeHelper(root.left, list);
            serializeHelper(root.right, list);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] split = data.split(",");
        
        Queue<String> q = new LinkedList<>(Arrays.asList(split));
        return deserializeHelper(q);
    }
    private TreeNode deserializeHelper(Queue<String> q) {
        if (q.isEmpty()) return null;
        
        TreeNode root = new TreeNode();
        if (q.peek().equals("null")) {
            q.poll();
            return null;
        }
        root.val = Integer.valueOf(q.poll());
        root.left = deserializeHelper(q);
        root.right = deserializeHelper(q);
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));