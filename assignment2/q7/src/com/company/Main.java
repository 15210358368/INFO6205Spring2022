class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int idx = 0;
        int ns = newInterval[0], ne = newInterval[1];
        LinkedList<int[]> res = new LinkedList<>();
        int n = intervals.length;

        while(idx < n && ns > intervals[idx][0])    res.add(intervals[idx++]);
        //1. add all before new

        if(res.isEmpty() || ns > res.getLast()[1]) {
            res.add(newInterval);
        }else{
            int[] intv = res.removeLast();
            intv[1] = Math.max(ne, intv[1]);
            res.add(intv);
        }
        // 2. add newinterval


        while(idx < n){
            int[] intv = intervals[idx++];
            int s = intv[0], e = intv[1];


            if(s > res.getLast()[1]) {
                res.add(intv);
            }else{
                intv = res.removeLast();
                intv[1] = Math.max(e, intv[1]);
                res.add(intv);
            }
        }

        return res.toArray(new int[res.size()][2]);
    }
}