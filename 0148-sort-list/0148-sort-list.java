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
        if(head == null || head.next == null) return head;
        ListNode prev=null, slow=head, fast=head;
        
        //Step 1: dividing the list in two halves
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        //Step 2: diving the two lists further untill single node list
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        //Step 3: merging the lists
        return merge(l1,l2);
    }
    ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }
            else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if(l2!=null) current.next = l2;
        else current.next = l1;
        return dummy.next;
    }
}