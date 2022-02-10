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

        Map<Node, Node> mp = new HashMap<>();
        Node node = head;
        while(node != null){
            if(node.random != null){
                mp.put(node.random, new Node(node.random.val));
            }
            node = node.next;
        }


        node = head;
        Node dummy = new Node(-1);
        dummy.next = node;
        Node res = dummy;

        while(node != null){

            dummy.next = mp.getOrDefault(node, new Node(node.val));
            dummy = dummy.next;
            dummy.random = mp.containsKey(node.random) ? mp.get(node.random) : null;
            node = node.next;

        }

        return res.next;
    }
}