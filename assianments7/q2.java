class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;


        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] vis = new boolean[n][1 << n];
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i, 0});
            vis[i][1 << i] = true;
        }


        while (!queue.isEmpty()) {
            int[] tuple = queue.poll();
            int idx = tuple[0], mask = tuple[1], dist = tuple[2];


            if (mask == (1 << n) - 1) return dist;


            for (int x : graph[idx]) {
                int next_mask = mask | (1 << x);
                if (!vis[x][next_mask]) {
                    queue.offer(new int[]{x, next_mask, dist + 1});
                    vis[x][next_mask] = true;
                }
            }
        }
        return 0;
    }
}
