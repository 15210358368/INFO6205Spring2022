/** q5 987. Vertical Order Traversal of a Binary Tree
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
    List<List<Integer>> nodes;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        nodes = new ArrayList<>();
        dfs(root, 0 , 0);
        Collections.sort(nodes, (a, b) ->
                a.get(0) != b.get(0) ? a.get(0) - b.get(0) :
                        (a.get(1) != b.get(1) ? a.get(1) - b.get(1) : a.get(2) - b.get(2)));

        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        int idx = -1;
        int curLevel = Integer.MIN_VALUE;

        for(List<Integer> li : nodes){
            int col = li.get(0);
            int row = li.get(1);
            int val = li.get(2);

            if(curLevel != col){
                curLevel = col;
                idx++;
                ans.add(new ArrayList<Integer>());
            }

            ans.get(idx).add(val);

        }

        return ans;

    }

    public void dfs(TreeNode root, int col, int row){
        if(root == null) return;
        List<Integer> n = new ArrayList();

        n.add(col);
        n.add(row);
        n.add(root.val);

        nodes.add(n);
        dfs(root.left, col - 1, row + 1);
        dfs(root.right, col + 1, row + 1);
    }
}