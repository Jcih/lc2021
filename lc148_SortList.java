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
    public ListNode sortList(ListNode head) {
        /*merge sort
        find mid of list -- split -- merge sorted list
        
        */
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        ListNode firstTail = head;
        while (fast != null && fast.next != null) {
            firstTail = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        firstTail.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
            
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        
        
        return dummy.next;
    }
}