class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0 || points[0] == null || points[0].length == 0) return 0;

        int[] minCost = new int[points.length];
        boolean[] visited = new boolean[points.length];

        // Randomly pick pont 0 to start with
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[0] = 0;

        // Track the sum of edges while building the MST
        int result = 0;

        for (int iteration = 0; iteration < points.length; iteration++) {

            int currentMinCost = Integer.MAX_VALUE, minCostPointIndex = -1;
            for (int i = 0; i < points.length; i++) {
                if (!visited[i]) {
                    if (minCost[i] < currentMinCost) {
                        minCostPointIndex = i;
                        currentMinCost = minCost[i];
                    }
                }
            }
            result += currentMinCost;
            visited[minCostPointIndex] = true;

            int[] chosen = points[minCostPointIndex];
            for (int i = 0; i < points.length; i++) {
                if (!visited[i]) {
                    int dist = Math.abs(chosen[0] - points[i][0]) + Math.abs(chosen[1] - points[i][1]);
                    if (dist < minCost[i]) {
                        // Found a shorter edge to reach an unvisited point from the newly chosen point
                        minCost[i] = dist;
                    }
                }
            }
        }
        return result;
    }

    // public int minCostConnectPoints(int[][] points) {
    //     if (points == null || points.length == 0 || points[0] == null || points[0].length == 0) return 0;

    //     int cost = 0;
    //     int n = points.length;
    //     boolean visited[] = new boolean[n];
    //     PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

    //     // Start with first point, dist is 0
    //     pq.offer(new int[]{0, 0});

    //     while (!pq.isEmpty()) {
    //         int[] edge = pq.poll();
    //         int dist = edge[0], source_i = edge[1];

    //         if (visited[source_i]) continue;

    //         // Visiting this point for the first time. Mark it & add edges to the heap to pick next node;
    //         visited[source_i] = true;
    //         cost += dist;
    //         addEdges(source_i, points, pq, visited);
    //     }
    //     return cost;
    // }

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
