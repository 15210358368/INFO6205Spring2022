/** Question3   687. Longest Univalue Path
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
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;

        int max = 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        if(root.left != null && root.right != null && root.left.val == root.val && root.right.val == root.val){
            ans = Math.max(ans, left + right + 2);
        }// two sides, this will never help with when calculate single side length, so just update on ans

        if(root.left != null && root.left.val == root.val){
            max = Math.max(max, left + 1);
        }// left

        if(root.right != null && root.right.val == root.val){
            max = Math.max(max, right + 1);
        }// right

        ans = Math.max(ans, max);

        return max;
    }
}