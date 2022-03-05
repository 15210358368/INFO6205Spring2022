/** q6 222. Count Complete Tree Nodes
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {

        if(root == null) return 0;


        int res = 0;

        Queue<TreeNode> Q = new LinkedList();
        Q.offer(root);

        while(!Q.isEmpty()){
            int size = Q.size();
            res += size;
            for(int i = 0; i < size; i++){
                TreeNode cur = Q.poll();
                if(cur.left != null) Q.offer(cur.left);
                if(cur.right != null) Q.offer(cur.right);
            }
        }
        return res;
    }
}