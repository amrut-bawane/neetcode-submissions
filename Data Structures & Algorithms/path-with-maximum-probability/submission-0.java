class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        if (n == 0) return 0;
        if (start_node == end_node) return 1.0;

        // { 0: [[1, 0.5], [2, 0.2]]}
        Map<Integer, List<double[]>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0], y = edges[i][1];
            double prob = succProb[i];
            graph.putIfAbsent(x, new ArrayList<>());
            graph.putIfAbsent(y, new ArrayList<>());
            
            graph.get(x).add(new double[] {y, prob});
            graph.get(y).add(new double[] {x, prob});
        }

        boolean[] visited = new boolean[n];

        // pq entry -> {prob, node_x, node_y} -> Max probability to reach from node x to y
        PriorityQueue<double[]>  pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Start with start node & known probability of 1 to reach itself
        pq.offer(new double[] {1, start_node});

        while (!pq.isEmpty()) {
            double[] candidate = pq.poll();
            double prob_till_now = candidate[0];
            int node_reached = (int) candidate[1];
            if (visited[node_reached]) {
                continue;
            }
            visited[node_reached] = true;
            if (node_reached == end_node) {
                return prob_till_now;
            }
            // Find all edges & compute probabilities
            if (graph.containsKey(node_reached)) {
                for (double[] edge: graph.get(node_reached)) {
                    int neighbor = (int) edge[0];
                    double prob = edge[1];

                    // Check if neighbor had already been reached earlier with higher success prob
                    if (!visited[neighbor]) {
                        // Record destination with updated prob
                        pq.offer(new double[] {prob * prob_till_now, neighbor});
                    }
                }
            }
        }

        // Could not reach end_node
        return 0;

    }
}