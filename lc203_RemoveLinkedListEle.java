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
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode dummy = prev;
        
        
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
                //prev = prev.next;
            } else {
                prev = prev.next;
            }
        }
        
        return dummy.next;
    }
}