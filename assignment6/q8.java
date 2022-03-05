/** q8 1325. Delete Leaves With a Given Value
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
    int t;
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        t = target;
        return dfs(root);

    }


    public TreeNode dfs(TreeNode root){

        if(root == null) return null;
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if(root.left == null && root.right == null && root.val == t) root = null;
        return root;
    }

}