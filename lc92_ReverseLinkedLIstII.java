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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if (head == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        //get prev to node 1
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        
        //head of to be reversed : node 2
        ListNode head_r = prev.next;
        
        ListNode tail = dummy;
        //get tail to node 4, end of to be reversed
        for (int i = 0; i < right; i++) {
            tail = tail.next;
        }
        
        //end will be the null for the regular reverse function
        ListNode end = tail.next;
        tail.next = null;
        
        prev.next = reverse(head_r, end);
        return dummy.next;
        
    }
    
    private ListNode reverse(ListNode head, ListNode end) {
        ListNode prev = end;
        ListNode cur = head;
        
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    
}