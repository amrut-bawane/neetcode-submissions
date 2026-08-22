class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int i = 0;
        
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            // Can straight away be added
            merged.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval = merge(intervals[i], newInterval);
            i++;
        }
        merged.add(newInterval);
        while (i < intervals.length) {
            merged.add(intervals[i]);
            i++;
        }
        return merged.toArray(new int[merged.size()][]);
    }

    private int[] merge(int[] interval1, int[] interval2) {
        return new int[] { Math.min(interval1[0], interval2[0]), Math.max(interval1[1], interval2[1])};
    }
}
