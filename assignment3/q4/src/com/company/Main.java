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
    public void reorderList(ListNode head) {

        Deque<ListNode> Q = new ArrayDeque<>();
        ListNode dummy = head.next;
        while(dummy != null){
            Q.offer(dummy);
            dummy = dummy.next;
        }

        boolean front = false;

        while(!Q.isEmpty()){
            ListNode cur = (front) ? Q.pollFirst() : Q.pollLast();
            head.next = cur;
            cur.next = null;
            head = head.next;
            front = !front;
        }
    }
}