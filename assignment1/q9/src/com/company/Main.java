class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> li = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            mp.put(nums[i],mp.getOrDefault(nums[i], 0) + 1);
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> mp.get(a) == mp.get(b) ? b - a  : mp.get(a) - mp.get(b));
        maxHeap.addAll(mp.keySet());


        while(!maxHeap.isEmpty()){

            int cur = maxHeap.remove();
            int num = mp.get(cur);

            while(num > 0){
                li.add(cur);
                num--;
            }

        }

        int[] res = new int[li.size()];
        int index = 0;
        for(int i : li){
            res[index] = i;
            index++;
        }

        return res;
    }
}