class KthLargest {
    int k;
    PriorityQueue<Integer> minHeap;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        // root is always the kth largest since we keep it bounded to k items
        this.minHeap = new PriorityQueue<>();
        for (int num: nums) {
            this.add(num);
        }
    }
    
    public int add(int val) {
        this.minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
