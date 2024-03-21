/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    private int getIndex(Node head, Node target){
        int i = 0;
        while(head!=null && head != target){
            head = head.next;
            i++;
        }
        return i;
    }
    private Node getNode(Node head, int index){
        int i = 0;
        while(i < index){
            head = head.next;
            i++;
        }
        return head;
    }
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        ArrayList<Integer> rl = new ArrayList<>();
        Node ptr1 = head;
        Node newHead = new Node(0), ptr2 = newHead;
        while(ptr1 != null){
            if(ptr1.random == null) rl.add(null);
            else rl.add(getIndex(head, ptr1.random));
            ptr2.next = new Node(ptr1.val);
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        ptr2 = newHead.next;
        for(int i=0; i<rl.size(); i++){
            if(rl.get(i) == null) ptr2.random = null;
            else ptr2.random = getNode(newHead.next,rl.get(i));
            ptr2 = ptr2.next;
        }
        return newHead.next;
    }
}