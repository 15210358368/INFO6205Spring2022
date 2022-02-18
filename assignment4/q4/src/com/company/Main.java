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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> li = new ArrayList<>();
        ListNode pre = new ListNode(0);
        pre.next = head;
        int index = 0;
        while(head.next != null){

            if(pre.val != 0 && pre.val < head.val && head.next.val < head.val){
                li.add(index);
            }

            if(pre.val != 0 && pre.val > head.val && head.next.val > head.val){
                li.add(index);
            }

            index++;
            pre = head;
            head = head.next;
        }

        if(li.size() < 2){
            return new int[]{-1, -1};
        }

        Collections.sort(li);
        int minD = Integer.MAX_VALUE;
        for(int i = 1; i < li.size(); i++){
            minD = Math.min(li.get(i) - li.get(i - 1), minD);
        }

        int maxD = li.get(li.size() - 1) - li.get(0);

        return new int[]{minD, maxD};
    }
}