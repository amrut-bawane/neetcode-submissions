class Solution {
    class Edge {
        int target;
        int weight;
        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    // times[i] = (ui, vi, wi)
    public int networkDelayTime(int[][] times, int n, int k) {
        if (times == null || times.length == 0 || times[0].length == 0) return -1;

        int[] timeToReach = new int[n+1];
        Arrays.fill(timeToReach, Integer.MAX_VALUE);

        Map<Integer, List<Edge>> graph = new HashMap<>();
        // Fill the graph 
        for (int[] time: times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new Edge(time[1], time[2]));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Offer the starting node
        pq.offer(new int[]{0, k});
        timeToReach[k] = 0;

        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            int time = next[0], node = next[1];

            if (time > timeToReach[node]) continue;

            // For all edges, add entry to the PQ
            if (graph.containsKey(node)) {
                for (Edge edge: graph.get(node)) {
                    int target = edge.target;
                    int newTime = time + edge.weight;
                    if (newTime < timeToReach[target]) {
                        timeToReach[target] = newTime;
                        pq.offer(new int[]{newTime, target});
                    }
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int d = timeToReach[i];
            if (d == Integer.MAX_VALUE) return -1;
            res = Math.max(res, d);
        }
        return res;
    }
}
