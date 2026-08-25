class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;

        // First, sort the intervals per interval start to make comparisons faster
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        int[] prev = null;

        for (int[] interval: intervals) {
            if (prev == null) {
                prev = interval;
                continue;
            }
            if (overlap(prev, interval)) {
                prev = merge(prev, interval);
            } else {
                merged.add(prev);
                prev = interval;
            }
        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }

    // interval1, interval2 sorted as per start
    private boolean overlap(int[] interval1, int[] interval2) {
        if (interval2[0] <= interval1[1]) {
                return true;
            }
        return false;
    }

    private int[] merge(int[] interval1, int[] interval2) {
        return new int[] { interval1[0], Math.max(interval1[1], interval2[1])};
    }
}
