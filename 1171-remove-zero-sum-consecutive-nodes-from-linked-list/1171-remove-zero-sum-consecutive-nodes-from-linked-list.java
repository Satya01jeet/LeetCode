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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer,ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode();
        dummy.next = head;
        int sum = 0;
        for(ListNode current = dummy; current != null; current = current.next){
            sum += current.val;
            if(!map.containsKey(sum)){
                map.put(sum,current);
            }
            else{
                ListNode toBeRemoved = map.get(sum).next;
                int remove = sum + toBeRemoved.val;
                while(remove != sum){
                    map.remove(remove);
                    toBeRemoved = toBeRemoved.next;
                    remove += toBeRemoved.val;
                }
                map.get(sum).next = current.next;
            }
        }
        return dummy.next;
    }
}