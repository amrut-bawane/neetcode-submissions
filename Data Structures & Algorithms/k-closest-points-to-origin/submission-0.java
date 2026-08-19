class Solution {
    // k closest points to (0, 0)
    public int[][] kClosest(int[][] points, int k) {
        // Store distances in max heap of size k
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> {
            int dista = p1[0] * p1[0] + p1[1] * p1[1];
            int distb = p2[0] * p2[0] + p2[1] * p2[1];
            return Integer.compare(distb, dista);
        });      

        for (int[] point: points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] results = new int[k][2];
        int index = 0;
        // for (int[] point: maxHeap) {
        //     results[index++] = point;
        // }
        for (int i = 0; i < k; i++) {
            results[i] = maxHeap.poll();
        }
        return results;
    }
}
