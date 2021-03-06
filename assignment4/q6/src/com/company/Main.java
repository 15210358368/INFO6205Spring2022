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

    Random rand;
    List<ListNode> arr;
    public Solution(ListNode head) {
        arr = new ArrayList<>();
        while(head != null){
            arr.add(head);
            head = head.next;
        }

        rand = new Random();

    }

    public int getRandom() {
        int r = rand.nextInt(arr.size());
        return arr.get(r).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */