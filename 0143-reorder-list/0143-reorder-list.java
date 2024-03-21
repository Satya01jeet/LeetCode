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
    private ListNode reverseList(ListNode head){
        ListNode current=head, p=null;
        while(head != null){
            head = head.next;
            current.next = p;
            p = current;
            current = head;
        }
        return p;
    }
    public void reorderList(ListNode head) {
        if(head.next == null) return;
        ListNode slow = head, fast = head, p=null;
        while(fast != null && fast.next != null){
            p = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        p.next = null;
        ListNode p1 = head, p2 = reverseList(slow);
        p = new ListNode(0);
        while(p1!=null && p2!=null){
            p.next = p1;
            p = p.next;
            p1 = p1.next;
            p.next = p2;
            p = p.next;
            p2 = p2.next;
        }
        if(p2!=null) p.next = p2;
    }
}