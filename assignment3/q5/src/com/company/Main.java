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
    public boolean isPalindrome(ListNode head) {

        List<Integer> arr = new ArrayList<>();

        ListNode node = head;

        while (node != null) {
            arr.add(node.val);
            node = node.next;
        }


        int left = 0;
        int right = arr.size() - 1;

        while (left < right) {

            if (arr.get(left) != arr.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
