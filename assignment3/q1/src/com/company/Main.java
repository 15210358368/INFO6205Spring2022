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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode pre1 = l1;
        ListNode pre2 = l2;
        ListNode newNode = new ListNode();
        ListNode res = newNode;

        int carry = 0;

        while(pre1 != null || pre2 != null){
            int sum = carry;

            if(pre1 != null){
                sum += pre1.val;
                pre1 = pre1.next;
            }

            if(pre2 != null){
                sum += pre2.val;
                pre2 = pre2.next;
            }

            carry = sum / 10;
            newNode.next = new ListNode(sum % 10);
            newNode = newNode.next;
        }

        if(carry != 0){
            newNode.next = new ListNode(1);
        }

        return res.next;

    }
}