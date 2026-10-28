class Solution {
    // Time = O(nlogn) // Sorting + O(n) // Pass = O(logn). Space = O(n)
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // Sort intervals as per start time, if tie then end time
        Arrays.sort(intervals, Comparator
            .comparingInt((int[] interval) -> interval[0])
            .thenComparingInt((int[] interval) -> interval[1]));

        int prev_end = intervals[0][1];

        int removed = 0;
        for (int i = 1; i < intervals.length; i++) {
            int current_start = intervals[i][0], current_end = intervals[i][1];

            if (current_start < prev_end) {
                // Overlap. Keep the interval that ends earlier
                removed += 1;
                prev_end = Math.min(prev_end, current_end);
            } else {
                prev_end = current_end;
            }
        }
        return removed;
    }
}
