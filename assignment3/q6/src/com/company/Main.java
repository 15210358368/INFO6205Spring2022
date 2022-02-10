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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre;
        ListNode front = pre;

        for(int i = 0; i <= n; i++){


            front = front.next;

        }

        while(front != null){
            pre = pre.next;
            front = front.next;
        }

        pre.next = pre.next.next;

        return start.next;

    }
}