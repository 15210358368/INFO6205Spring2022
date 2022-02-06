class Solution {
    public int minMeetingRooms(int[][] intervals) {

        if(intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // start time sortin 
        Queue<Integer> Q = new PriorityQueue<>((a, b) -> a - b); // end time sorting

        int room = 0;

        for(int i = 0; i < intervals.length; i++){
            if(Q.isEmpty()){
                room++;
                Q.offer(intervals[i][1]);
            }else{
                if(Q.peek() <= intervals[i][0]){
                    Q.poll();
                    Q.offer(intervals[i][1]);
                }else{
                    room++;
                    Q.offer(intervals[i][1]);
                }
            }
        }

        return room;

    }
}