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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
        1. example
        2. data structure
        3. logic
        4. result
        5. ananlysis
        ===================
        7 -> 2 -> 4 -> 3
             5 -> 6 -> 4
        ----------------
         7     8     0   7
        ====================
        Stack store two lists, each time pop one digit make the new list
        reverse the list
        ***/
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode p1 = l1, p2 = l2;
        while (p1 != null) {
            s1.push(p1);
            p1 = p1.next;
        }
        while (p2 != null) {
            s2.push(p2);
            p2 = p2.next;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        int sum = 0;
        
        while (!s1.isEmpty() || !s2.isEmpty()) {
            
            int v1 = 0;
            int v2 = 0;
            if (!s1.isEmpty()) {
                v1 = s1.pop().val;
            }
            if (!s2.isEmpty()) {
                v2 = s2.pop().val;
            }
            sum = carry + v1 + v2;
            
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            cur = cur.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        
        ListNode res = reverse(dummy.next);
        return res;
    }
    
    public ListNode reverse(ListNode root) {
        ListNode prev = null;
        ListNode cur = root;
        
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }
}