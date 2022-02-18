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
    public ListNode sortList(ListNode head) {
        if(head == null) return null;

        Queue<ListNode> Q = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode tmp = head;
        while(tmp != null){
            Q.offer(tmp);
            tmp = tmp.next;
        }

        ListNode res = new ListNode(0);
        ListNode ans = res;

        while(!Q.isEmpty()){
            res.next = Q.poll();
            res = res.next;
        }

        res.next = null;

        return ans.next;
    }
}