/** q1 437. Path Sum III
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
    int res, tar;
    public int pathSum(TreeNode root, int targetSum) {
        res = 0;
        tar = targetSum;
        dfsNode(root);
        return res;
    }

    public void dfsNode(TreeNode root) {
        if(root == null) return;
        dfsRestPath(root, root.val);
        dfsNode(root.left);
        dfsNode(root.right);

    }

    public void dfsRestPath(TreeNode root, int val) {
        if(val == tar) res++;
        if(root.left != null) dfsRestPath(root.left, val + root.left.val);
        if(root.right != null) dfsRestPath(root.right, val + root.right.val);
    }
}