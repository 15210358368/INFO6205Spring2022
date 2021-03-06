/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {

        if(head == null){
            Node newNode = new Node(insertVal, null);
            newNode.next = newNode;
            return newNode;
        };

        Node prev = head;
        Node cur = head.next;
        boolean found = false;

        while(cur != head){

            if(prev.val <= insertVal && insertVal <= cur.val){
                found = true;
            }else if(prev.val > cur.val){
                if(prev.val <= insertVal || insertVal <= cur.val){
                    found = true;
                }

            }

            if(found){
                prev.next = new Node(insertVal, cur);
                return head;
            }


            prev = cur;
            cur = cur.next;

        }
        prev.next = new Node(insertVal, cur);
        return head;
    }
}