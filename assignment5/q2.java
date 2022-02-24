/**
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
    List<List<Integer>> res;
    public List<List<Integer>> findLeaves(TreeNode root) {
        res = new ArrayList<>();
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if(root == null) return -1;

        int leftCnt = dfs(root.left);
        int rightCnt = dfs(root.right);

        int a = Math.max(leftCnt, rightCnt) + 1;
        if (res.size() == a)
            res.add(new ArrayList<>());

        res.get(a).add(root.val);
        return a;

    }
}