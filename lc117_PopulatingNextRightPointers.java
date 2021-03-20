/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    
    /**
    1. test
    2. data struc,algo: level traverse, BFS, queue
    3. logic
    4. result
    5. analysis
    ==================================    
    queue.add(root)
    while (queue.isEmpty()) {
    
      for (int i =0; i < queue.size(); i++) {
          if (i != queue.size())
            queue.poll().next = queue.peek();
          else 
             queue.poll().next = null;
      }
     }
     return root;
    
    */

    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node cur = q.poll();
                if(i!=size-1) cur.next = q.peek();
                else cur.next = null;
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
        }
        return root;
    }

    
}

//Solution followup Space O(1)

public Node connect(Node root) {
        Node head = root;
        Node dummy = new Node(0);
        Node pre = dummy;
        
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if (root == null) {//reach the end of current layer
                pre = dummy;//next new layer
                root = dummy.next;//(current level's head )currrent layer, root comes down one level below to the first available non null node
                dummy.next = null;  //reset dummyhead back to default null
            }
        }
        return head;
        
    }