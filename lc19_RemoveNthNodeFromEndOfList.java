/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        count the numbe of nodes t
        remove the t - n th node
        **/
        
        ListNode p = head;
        int t = 0;
        
        while (p != null) {
            t++;
            p = p.next;
        }
        int d = t - n;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        
        for (int i = 0; i < d; i++) {
            cur = cur.next;
        }
        
        cur.next = cur.next.next;
        
        return dummy.next;
        
        
    }
}



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        count the numbe of nodes t
        remove the t - n th node
        **/
        
        ListNode slow = head;
        ListNode fast = head;
        
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        if (fast == null) return head.next;
        
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}