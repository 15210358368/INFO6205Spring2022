class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TPair> queue = new ArrayDeque<>();
        queue.add(new TPair(root, 1));
        int maxWidth = 0;

        while(!queue.isEmpty()){

            TPair head = queue.peek();

            int qsize = queue.size();

            TPair pair = new TPair(null, 0);

            for(int i=0; i < qsize; i++){
                pair = queue.poll();
                TreeNode node = pair.node;

                if(node.left != null)
                    queue.add(new TPair(node.left, 2 * pair.index - 1));
                if(node.right != null)
                    queue.add(new TPair(node.right, 2 * pair.index));
            }

            maxWidth = Math.max(maxWidth, pair.index - head.index + 1) ;
        }
        return maxWidth;
    }
}

class TPair{
    TreeNode node;
    int index;
    public TPair(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}