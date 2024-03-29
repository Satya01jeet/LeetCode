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
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        int interval = 1;
        while(interval < size){
            for(int i=0; i+interval<size; i += 2*interval){
                lists[i] = merge(lists[i],i+interval<size?lists[i+interval]:null);
            }
            interval *= 2;
        }
        return size>0 ? lists[0]:null;
    }
    private static ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                head.next = l1;
                l1 = l1.next;
            }else{
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if(l2 == null) head.next = l1;
        if(l1 == null) head.next = l2;
        return dummy.next;
    }
}