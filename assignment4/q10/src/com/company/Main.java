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
    public int pairSum(ListNode head) {
        Map<Integer, Integer> mp = new HashMap<>(); //index, number
        int index = 0;
        while(head != null){
            mp.put(index, head.val);
            index++;
            head = head.next;
        }


        int max = Integer.MIN_VALUE;
        for(int i = 0; i < index/2; i++){
            max = Math.max(mp.get(i) + mp.get(index - 1 - i), max);
        }

        return max;
    }
}