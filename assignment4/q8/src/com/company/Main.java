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
    public ListNode[] splitListToParts(ListNode head, int k) {
        // 1.cut node one by one, save in array
        // 2.split and calculate each bolck has how many number 
        // 3.assign nodes
        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);


        ListNode node = head;
        int len = 0;
        while(node != null){
            len++;
            minHeap.offer(new ListNode(node.val, null));
            node = node.next;
        }

        int basic = len / k;
        int rest = len % k;

        int[] numbers = new int[k];
        for(int i = 0; i < k; i++){
            numbers[i] = basic;
            if(rest > 0){
                numbers[i]++;
            }

            rest--;
        }

        ListNode[] res = new ListNode[k];

        for(int m = 0; m < numbers.length; m++){
            ListNode tmpHead = new ListNode(0);
            ListNode tmpPre = tmpHead;
            for(int j = 0; j < numbers[m]; j++){
                tmpHead.next = minHeap.poll();
                tmpHead = tmpHead.next;
            }
            res[m] = tmpPre.next;

        }

        return res;

    }
}