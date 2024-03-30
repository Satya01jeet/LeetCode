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
    private static ListNode findNode(int i, ListNode head){
        ListNode curr = new ListNode(0,head);
        for(int j=0; j<i; j++){
            curr = curr.next;
        }
        return curr;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        ListNode dummy = new ListNode(0,head);
        ListNode l = findNode(left,head);
        ListNode r = findNode(right,head);
        ListNode gp = dummy;
        if(left-1>0){
            gp = findNode(left-1,head);
        }
        ListNode gn = r.next;

        // reverse
        ListNode curr = l, p = gn, n = curr.next;
        while(curr != gn){
            curr.next = p;
            p = curr;
            curr = n;
            if(n!=null) n = n.next;
        }
        gp.next = p;
        return dummy.next;
    }
}