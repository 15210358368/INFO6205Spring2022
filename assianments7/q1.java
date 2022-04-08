/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // 1. find nodes
        // 2. copy nodes
        // 3. copy relationships

        if(node == null) return null;
        List<Node> nodes = findNode(node);
        HashMap<Node, Node> mp = new HashMap<>();
        copyNodes(nodes, mp);
        copyPath(mp);
        return mp.get(node);
    }

    public static List<Node> findNode(Node root){
        Queue<Node> q = new ArrayDeque<>();
        List<Node> res = new ArrayList<>();

        q.offer(root);

        while(!q.isEmpty()){
            Node cur = q.poll();
            res.add(cur);
            for(Node n : cur.neighbors){
                if(!res.contains(n)) q.offer(n);
            }
        }

        return res;
    }

    public void copyNodes(List<Node> nodes, HashMap<Node, Node> mp){
        for(Node n : nodes){
            mp.put(n, new Node(n.val));
        }
    }

    public void copyPath( HashMap<Node, Node> mp){

        for(Node n : mp.keySet()){
            for(Node nei : n.neighbors){
                mp.get(n).neighbors.add(mp.get(nei));
            }
        }

    }
}