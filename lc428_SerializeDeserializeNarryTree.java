//similar with 297


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        /*
        pre order to add to a list
        
        **/
        
        List<String> list = new ArrayList<>();
        serializeHelper(root, list);
        return String.join(",", list);
    }
    private void serializeHelper(Node root, List<String> list) {
        if (root == null) return;
        
        list.add(String.valueOf(root.val));
        list.add(String.valueOf(root.children.size()));
        for (Node child: root.children) {
            serializeHelper(child, list);
        }
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        
        String[] split = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(split));
        return deserializeHelper(q);
    }
    private Node deserializeHelper(Queue<String> q) {
        Node root = new Node();
        root.val = Integer.valueOf(q.poll());
        int size = Integer.valueOf(q.poll());
        
        root.children = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            root.children.add(deserializeHelper(q));
        }
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));