/** Question 4 297. Serialize and Deserialize Binary Tree
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null) return "";

        int index = 0;
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> Q = new ArrayDeque<>();
        Q.offer(root);
        sb.append(index);
        sb.append("#");
        sb.append(root.val);
        sb.append("#");

        while(!Q.isEmpty()){
            TreeNode node = Q.poll();

            index++;
            if(node.left != null){
                Q.offer(node.left);
                sb.append(index);
                sb.append("#");
                sb.append(node.left.val);
                sb.append("#");
            }else{
                sb.append(index);
                sb.append("#");
                sb.append("null");
                sb.append("#");
            }

            index++;
            if(node.right != null){
                Q.offer(node.right);
                sb.append(index);
                sb.append("#");
                sb.append(node.right.val);
                sb.append("#");
            }else{
                sb.append(index);
                sb.append("#");
                sb.append("null");
                sb.append("#");
            }

        }

        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.length() == 0 || data.equals("")) return null;

        int nodeidx = 0;
        String[] series = data.split("#");
        Queue<TreeNode> Q = new ArrayDeque<>();

        TreeNode root = new TreeNode(Integer.parseInt(series[nodeidx + 1]));
        Q.offer(root);

        while(!Q.isEmpty()){
            TreeNode node = Q.poll();

            nodeidx += 2;

            if(series[nodeidx + 1].equals("null")){
                node.left = null;
            }else{
                node.left = new TreeNode(Integer.parseInt(series[nodeidx + 1]));
                Q.offer(node.left);
            }



            nodeidx += 2;

            if(series[nodeidx + 1].equals("null")){
                node.right = null;
            }else{
                node.right = new TreeNode(Integer.parseInt(series[nodeidx + 1]));
                Q.offer(node.right);
            }

        }

        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));