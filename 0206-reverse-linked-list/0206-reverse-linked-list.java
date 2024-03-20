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
    public ListNode reverseList(ListNode h) {
        ListNode p = null, current = null;
        while(h != null){
            current = h;
            h = h.next;
            current.next = p;
            p = current;
        }
        return current;
    }
}