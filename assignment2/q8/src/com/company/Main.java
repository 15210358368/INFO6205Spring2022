class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> a[1] - b[1]); // sort asc by end time

        int count = 0;
        int[] current = intervals[0];

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < current[1]) count++; // increase count if overlapping
            else current = intervals[i];
        }

        return count;

    }
}