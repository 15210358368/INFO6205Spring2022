class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();

        int n = firstList.length;
        int m = secondList.length;

        int i = 0; // pointers
        int j = 0;

        while(i < n && j < m){


            int left = Math.max(firstList[i][0], secondList[j][0]);
            int right = Math.min(firstList[i][1], secondList[j][1]);

            if(left <= right){
                ans.add(new int[]{left, right});
            }


            if(firstList[i][1] < secondList[j][1]){
                i++;
            }else{
                j++;
            }

        }
        return ans.toArray(new int[ans.size()][]);
    }


}