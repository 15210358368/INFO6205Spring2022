/** q7 129. Sum Root to Leaf Numbers
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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        dfs(root, root.val);
        return sum;
    }

    public void dfs(TreeNode root, int val){


        if(root.left != null) dfs(root.left, val * 10 + root.left.val);
        if(root.right != null) dfs(root.right, val * 10 + root.right.val);

        if(root.left == null && root.right == null) sum += val;

    }
}