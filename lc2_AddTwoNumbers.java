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
        5. analysis
        ===============
        2 + 5 = 7
        4 + 6 = 10, 
        3 + 4 = 7 + 1 = 8
        ===============
        
        if (a + b <= 9)
            new = a + b
        else 
            new = ( a + b ) % 10
            add = 1
        
        */
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        int flag = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            sum = flag + v1 + v2;
            
            flag = sum / 10;
            sum = sum % 10;
            ListNode newNode = new ListNode(sum);
            cur.next = newNode;
            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null) l2 = l2.next;     
        }
        
        if (flag == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
        
    }
}