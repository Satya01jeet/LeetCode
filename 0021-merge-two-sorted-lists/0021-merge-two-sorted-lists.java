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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode();
        ListNode res = newHead;
        while(list1 != null || list2 != null){
            if(list1 == null){
                newHead.next = list2;
                newHead = newHead.next;
                list2 = list2.next;
            }
            else if(list2 == null){
                newHead.next = list1;
                newHead = newHead.next;
                list1 = list1.next;
            }
            else{
                if(list1.val<=list2.val){
                    newHead.next = list1;
                    newHead = newHead.next;
                    list1 = list1.next;
                }else{
                    newHead.next = list2;
                    newHead = newHead.next;
                    list2 = list2.next; 
                }
            }
        }
        return res.next;
    }
}