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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            sz++;
        }
        int del = sz - n;
        if(sz - n == 0) head = head.next;
        else{
            curr = head;
            for(int i=0; i<sz; i++){
                if(sz - n -1 == i){
                    curr.next = curr.next.next;
                    break;
                }
                curr = curr.next;
            }
        }
        return head;
    }
}