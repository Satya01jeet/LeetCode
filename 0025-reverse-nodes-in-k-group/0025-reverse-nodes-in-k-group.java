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
    private static ListNode giveKth(ListNode gp, int k){
        ListNode curr = gp;
        for(int i=0; i<k; i++){
            curr = curr.next;
            if(curr == null) return null;
        }
        return curr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        ListNode grpPrv = dummy;
        while(true){
            ListNode kth = giveKth(grpPrv,k);
            if(kth == null) break;
            ListNode grpNxt = kth.next;

            // Reverse the groups
            ListNode cur = grpPrv.next;
            ListNode start = cur;
            ListNode prv = grpNxt;
            ListNode nxt = cur.next;
            while(cur!=grpNxt){
                cur.next = prv;
                prv = cur;
                cur = nxt;
                if(nxt != null) nxt = nxt.next;
            }
            grpPrv.next = prv;
            grpPrv = start;
        }
        return dummy.next;
    }
}