class Solution {

    Map<Integer, List<int[]>> graph;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        graph = getGraph(edges);


        int[] visited = new int[values.length];
        int[] max = new int[1];

        dfs(0, 0, 0, max, maxTime, values, visited);

        return max[0];
    }

    private void dfs(int node, int value, int time, int[] max, int maxTime, int[] values, int[] visited) {
        if (time > maxTime) {
            return;
        }


        if (visited[node] == 0) {
            value += values[node];
        }


        if (node == 0) {
            max[0] = Math.max(max[0], value);
        }

        if (graph.get(node) == null) {
            return;
        }

        visited[node]++;

        for (int[] next : graph.get(node)) {
            int nextTime = time + next[1];
            dfs(next[0], value, nextTime, max, maxTime, values, visited);
        }

        visited[node]--;
    }

    private Map<Integer, List<int[]>> getGraph(int[][] edges) {
        Map<Integer, List<int[]>> result = new HashMap<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int time = edge[2];
            result.putIfAbsent(from, new ArrayList<>());
            result.putIfAbsent(to, new ArrayList<>());
            result.get(from).add(new int[] {to, time});
            result.get(to).add(new int[] {from, time});
        }
        return result;
    }
}