/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode f=head, s=head;
        while(f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
            if(f==s){
                while(head!=s){
                    s = s.next;
                    head = head.next;
                }
                return s;

            }
        }
        return null;
    }
}