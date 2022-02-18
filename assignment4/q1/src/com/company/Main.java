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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode node = list1;
        ListNode preA = null;
        ListNode preB = null;

        int index = 0;

        while(node.next != null){

            if(index + 1 == a){
                preA = node;
            }

            if(index - 1 == b){
                break;
            }

            index++;
            node = node.next;
        }


        preB = node;


        preA.next = list2;
        while(list2.next != null){
            list2 = list2.next;
        }

        list2.next = preB;

        return list1;
    }
}