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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i: nums){
            s.add(i);
        }

        int cnt = 0;
        int number = 0;

        while(head != null){

            while(s.contains(head.val) && head.next != null){
                number++;
                head = head.next;
            }

            if(s.contains(head.val)){
                number++;
            }

            if(number > 0){
                cnt++;
                number = 0;

                if(head.next == null){
                    return cnt;
                }

                continue;
            }

            head = head.next;


        }

        return cnt;

    }
}