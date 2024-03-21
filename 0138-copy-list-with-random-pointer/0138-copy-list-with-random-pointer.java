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
    public Node copyRandomList(Node head) {
        Node curr = head;
        Node newHead = new Node(0), copy = newHead;
        HashMap<Node,Integer> og = new HashMap<>();
        HashMap<Integer,Node> cp = new HashMap<>();
        int index = 0;
        while(curr != null){
            copy.next = new Node(curr.val);
            copy = copy.next;
            og.put(curr,index);
            cp.put(index++,copy);
            curr = curr.next;
        }
        curr = head;
        copy = newHead.next;
        while(curr != null){
            if(curr.random == null) copy.random = null;
            else copy.random = cp.get(og.get(curr.random));
            curr = curr.next;
            copy = copy.next;
        }
        return newHead.next;
    }
}