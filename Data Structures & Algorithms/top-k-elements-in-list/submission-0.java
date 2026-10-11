class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;

        // 1. Track Frequency of each element
        // 2. Highest frequency items in Min Heap of size k
        // Time = O(nlogk). Space = O(n)

        // Min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Compute frequencies
        for (int num: nums) {
            freqMap.putIfAbsent(num, 0);
            freqMap.put(num, freqMap.get(num) + 1);
        }

        // Construct min heap of size k of frequncies
        for (int num: freqMap.keySet()) {
            int freq = freqMap.get(num);
            if (pq.size() < k) {
                pq.offer(new int[] {freq, num});
            } else {
                int leastFreq = pq.peek()[0];
                if (freq > leastFreq) {
                    pq.poll();
                    pq.offer(new int[] {freq, num});
                }
            }
        }

        int[] result = new int[k];
        int i = 0;
        for (int[] item: pq) {
            result[i] = item[1];
            i++;
        }
        return result;

    }
}
