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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while(node != null){
            list.add(node.val);
            node = node.next;
        }

        int[] res = new int[list.size()];
        Stack<Integer> st = new Stack<>();
        node = head;


        for(int i = list.size() - 1; i >= 0; i--){

            while(!st.isEmpty() && st.peek() <= list.get(i)){
                st.pop();
            }

            if(!st.isEmpty()){
                res[i] = st.peek();
            }

            st.push(list.get(i));

        }


        return res;

    }
}