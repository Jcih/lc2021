/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        
        //insert a new node for each node
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        
        //copy random pointer
        
        cur =  head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        //break list to separate
        cur = head;
        Node dummy = head.next;
        while (cur != null) {
            Node p = cur.next;
            cur.next = p.next;
            if (p.next != null)
                p.next = p.next.next;
            cur = cur.next;
        }
        return dummy;
        
    }
}