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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return res;
        dfs(root, 0);
        Collections.reverse(res);
        return res;
    }

    public void dfs(TreeNode root, int level) {

        if(res.size() == level){
            res.add(new ArrayList<Integer>());
        }

        res.get(level).add(root.val);

        if(root.left != null){
            dfs(root.left, level + 1);
        }

        if(root.right != null){
            dfs(root.right, level + 1);
        }
    }

}