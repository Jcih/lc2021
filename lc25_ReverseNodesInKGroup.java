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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        
        //get k + 1 node
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        
        if (count == k) {
            cur = reverseKGroup(cur, k);
            head = reverseWithTail(head, cur, count);  
        }
         
        return head;
    }
    
    private ListNode reverseWithTail(ListNode head, ListNode tail, int count) {
        ListNode prev = tail; // replace null in standard reverse template
        ListNode cur = head;
        
        while (count-- > 0) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    /* For reference:
    // standart reverse linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = tmp;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
    */
}