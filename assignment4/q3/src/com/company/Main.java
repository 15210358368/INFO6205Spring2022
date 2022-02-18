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
    ListNode prev;
    public ListNode reverseEvenLengthGroups(ListNode head) {

        if(head ==null || head.next == null){
            return head;
        }

        int groupNumber = 1;

        ListNode res = head;
        prev = null;

        while(head != null){
            int len = getLength(head, groupNumber);
            if(len % 2 == 0){
                head = reverse(head, len);
            }else{
                int cnt = len;
                if(groupNumber % 2 == 1){
                    while(cnt > 0 && head !=null){
                        cnt--;
                        if(cnt == 0){
                            prev = head;
                        }
                        head = head.next;
                    }
                }
            }

            groupNumber++;
        }
        return res;
    }



    public ListNode reverse(ListNode head, int len) {


        int cnt = len - 1;

        ListNode back = null;
        ListNode mid = head;
        ListNode front = head.next;

        while(cnt > 0 && front!=null){
            mid.next = back;
            back = mid;
            mid = front;
            front = front.next;
            cnt--;
        }

        mid.next = back;
        this.prev.next = mid;
        this.prev = head;
        head.next = front;
        head = head.next;


        return head;

    }

    public int getLength(ListNode head, int groupNumber){

        int length = 0;
        ListNode tmp = head;
        while(tmp != null && length < groupNumber){
            tmp = tmp.next;
            length++;
        }
        return length;
    }

}