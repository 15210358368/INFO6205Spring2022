class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        Queue<Integer> que = new PriorityQueue<>((a,b) -> mp.get(b) - mp.get(a));
        for(int key : mp.keySet()){
            que.offer(key);
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = (que.poll());
        }

        return res;
    }
}