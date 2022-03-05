/** Question2 : 236. Lowest Common Ancestor of a Binary Tree
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // use BFS search and a HashMap to store the parent node

        Map<TreeNode, TreeNode> mp = new HashMap<>(); // node, node.parent
        mp.put(root, null);

        Queue<TreeNode> Q = new ArrayDeque<>();
        Q.offer(root);

        while(!Q.isEmpty()){
            TreeNode node = Q.poll();
            if(!mp.containsKey(node.left) && node.left != null){
                mp.put(node.left , node);
                Q.offer(node.left);
            }
            if(!mp.containsKey(node.right) && node.right != null){
                mp.put(node.right, node);
                Q.offer(node.right);
            }
        }

        Set<TreeNode> lca = new HashSet<>();
        while(p != null){
            lca.add(p);
            p = mp.get(p); // node = node.parent;
        }

        while(!lca.contains(q)){ // once lca contains q, they meet in one point
            q = mp.get(q);
        }

        return q;
    }
}