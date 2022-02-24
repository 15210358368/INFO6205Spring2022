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
    List<List<Integer>> tmp = new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);

        for(List<Integer> li : tmp){
            int max = Integer.MIN_VALUE;
            for(int i : li){
                if(max < i){
                    max = i;
                }
            }
            res.add(max);
        }

        return res;
    }

    public void dfs(TreeNode root, int depth){
        if(root == null) return;

        if(depth == tmp.size()){
            tmp.add(new ArrayList<>());
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);


        tmp.get(depth).add(root.val);

    }
}