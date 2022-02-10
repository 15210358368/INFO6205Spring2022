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

        if(lists.length == 0){
            return null;
        }

        Queue<ListNode> Q = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode node : lists){
            if(node != null){
                Q.offer(node);
            }

        }

        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while(!Q.isEmpty()){
            ListNode cur = Q.poll();
            dummy.next = new ListNode(cur.val);
            if(cur.next != null) Q.offer(cur.next);
            dummy = dummy.next;
        }

        return res.next;
    }
}