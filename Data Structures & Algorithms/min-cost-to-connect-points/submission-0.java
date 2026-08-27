class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0 || points[0] == null || points[0].length == 0) return 0;

        int cost = 0;
        int n = points.length;
        boolean visited[] = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Start with first point, dist is 0
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int dist = edge[0], source_i = edge[1];

            if (visited[source_i]) continue;

            // Visiting this point for the first time. Mark it & add edges to the heap to pick next node;
            visited[source_i] = true;
            cost += dist;
            addEdges(source_i, points, pq, visited);
        }
        return cost;
    }

    private void addEdges(int source_index, int[][] points, PriorityQueue<int[]> pq, boolean[] visited) {
        for (int i = 0; i<points.length; i++) {
            int[] target = points[i];
            int[] source = points[source_index];
            if (!visited[i]) {
                int dist = Math.abs(source[0] - target[0]) + Math.abs(source[1] - target[1]);
                pq.offer(new int[]{dist, i});
            }
        }
    }
}
