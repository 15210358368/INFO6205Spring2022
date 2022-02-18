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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null) return null;

        ListNode dummy = new ListNode(0, head);

        int index = 1;
        while(index < left  && head != null){
            if(index == left - 1){
                break;
            }
            head = head.next;
            index++;

        }

        if(left == right){
            return dummy.next;
        }


        ListNode beforeReverse = null;
        if(left == 1){
            beforeReverse = dummy;
        }else{
            beforeReverse = head;
            head = head.next;
            index++;

        }


        ListNode back = null;
        ListNode mid = head;
        ListNode tail = head;
        ListNode front = head.next;



        while(front != null && index != right){
            mid.next = back;

            back = mid;
            mid = front;
            front = front.next;

            index++;

        }

        mid.next = back;
        beforeReverse.next = mid;

        tail.next = front;




        return dummy.next;
    }
}